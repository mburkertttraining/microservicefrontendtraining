package ch.erni.frontend.service;

import ch.erni.frontend.model.Ernian;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class FileWriterReaderServiceImpl implements FileWriterReaderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileWriterReaderServiceImpl.class);

    @Override
    public Map<UUID, Ernian> readErnians() {
        ClassLoader classLoader = getClass().getClassLoader();
        String resource = new File(classLoader.getResource("json").getFile()).getAbsolutePath();
        Map<UUID, Ernian> ernians = new HashMap<>();
        List<String> jsonFilenameList = getJsonFileNameList(getAllFilenames(resource));
        for (String filename : jsonFilenameList) {
            Ernian ernian = readErnian(resource + "/", filename);
            if (ernian != null) {
                ernians.put(ernian.getId(), ernian);
            }
        }
        return ernians;
    }

    @Override
    public void writeErnians(Ernian ernian) {
        ObjectMapper mapper = new ObjectMapper();
        Objects.requireNonNull(ernian.getId(), "The value is not allowed to be Null.(Ernian Id)");
        ClassLoader classLoader = getClass().getClassLoader();
        String resource = new File(classLoader.getResource("json").getFile()).getAbsolutePath();
        File file = new File(resource + "/ernian_" + ernian.getId() + ".json");
        try {
            // Serialize Java object info JSON file.
            mapper.writeValue(file, ernian);
        } catch (IOException e) {
            LOGGER.error("Could not write File in directory due to:", e.getMessage());
        }
    }

    private Ernian readErnian(String fileDirectory, String filename) {
        ObjectMapper mapper = new ObjectMapper();
        Ernian ernian = null;
        try {
            ernian = mapper.readValue(new File(fileDirectory + filename), Ernian.class);
        } catch (IOException e) {
            LOGGER.error("Json file could not be parsed to Object due to Error: {}.", e.getMessage());
        }
        return ernian;
    }

    private List<String> getJsonFileNameList(List<String> allFilenames) {
        List<String> jsonFilnames = new ArrayList<>();
        for (String filname : allFilenames) {
            if (filname.contains(".json")) {
                jsonFilnames.add(filname);
            }
        }
        return jsonFilnames;
    }
    private List<String> getAllFilenames(String directory) {
        Objects.requireNonNull(directory, "The Value String directory is not allowed to be null");
        List<String> listOfNames = new ArrayList<>();
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile() && listOfFiles[i] != null) {
                    listOfNames.add(listOfFiles[i].getName());
                } else if (listOfFiles[i].isDirectory() && listOfFiles[i] != null) {
                    listOfNames.add(listOfFiles[i].getName());
                }
            }
        }
        return listOfNames;
    }
}
