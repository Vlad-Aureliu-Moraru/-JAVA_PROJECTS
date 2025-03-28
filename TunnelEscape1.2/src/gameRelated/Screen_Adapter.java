package gameRelated;

import java.io.*;

public class Screen_Adapter {private final static String filePath = "assets\\screenInfo\\screenInfo.txt";

    public Screen_Adapter() {
    }

    public void writeInFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully at: " + filePath);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public int getH() {
        return getValueFromFile(filePath, "H");
    }

    public int getW() {
        return getValueFromFile(filePath, "W");
    }

    private static int getValueFromFile(String filePath, String key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(key)) {
                    return getValueFromLine(line, key);
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        System.err.println("Key '" + key + "' not found in the file.");
        return 0;
    }

    private static int getValueFromLine(String line, String key) {
        if (line == null || line.isEmpty()) {
            System.err.println("Input line is null or empty.");
            return 0;
        }

        if (!line.contains(key)) {
            System.err.println("Key '" + key + "' not found in the line.");
            return 0;
        }

        String[] parts = line.split(key + "\\s*:\\s*");
        if (parts.length > 1) {
            String valuePart = parts[1].trim();
            String number = valuePart.split("\\s+")[0];
            try {
                return Integer.parseInt(number);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format for key '" + key + "': " + number);
            }
        }
        return 0;
    }
}
