package com.epam.mjc.io;

import java.io.File;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Map<String, String> profileData = new HashMap<>();
        
        try {
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line.contains(": ")) {
                    String[] keyValue = line.split(": ", 2);
                    if (keyValue.length == 2) {
                        profileData.put(keyValue[0], keyValue[1].trim());
                    }
                }
            }

            String name = profileData.get("Name");
            Integer age = Integer.parseInt(profileData.get("Age"));
            String email = profileData.get("Email");
            Long phone = Long.parseLong(profileData.get("Phone"));

            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            System.err.println("Error occurred while reading the file: " + e.getMessage());
            return null;
        } catch (NumberFormatException e) {
            System.err.println("Error in data format: " + e.getMessage());
            return null;
        }
    }
}
