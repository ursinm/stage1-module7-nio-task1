package com.epam.mjc.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class FileReader {
    
    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try (Stream<String> lines = Files.lines(Paths.get(file.toURI()))) {
            lines.forEach(line -> {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    switch (key) {
                        case "Name":
                            profile.setName(value);
                            break;
                        case "Age":
                            profile.setAge(Integer.parseInt(value));
                            break;
                        case "Email":
                            profile.setEmail(value);
                            break;
                        case "Phone":
                            profile.setPhone(value);
                            break;
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;
    }
}
