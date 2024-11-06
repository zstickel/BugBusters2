package memorizingtool;//Chapter 2

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//One sunny morning, as Lily strolled by the village square, she noticed a...

/**
 * This class provides functionality for processing files in some way.
 * The FileProcessor class offers methods to read and write files.
 * <p>
 * With the FileProcessor class at our disposal, we can confidently work with files in this application.
 * It simplifies the process of reading, writing, and managing files, allowing us to focus on the actual logic of our programs.
 */
class FileReaderInteger {
    public List<Integer> read(String fileName) throws IOException {
        List<Integer> list = new LinkedList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
        }
        return list;
    }
}

class FileWriterInteger {
    public void write(String fileName, List<Integer> data) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Integer i : data) {
                printWriter.println(i);
            }
        }
    }
}

class FileReaderWords {
    public List<String> read(String fileName) throws IOException {
        List<String> list = new LinkedList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        }
        return list;
    }
}

class FileWriterWords {
    public void write(String fileName, List<String> data) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (String i : data) {
                printWriter.println(i);
            }
        }
    }
}

class FileReaderBoolean implements AutoCloseable {
    List<Boolean> list = new LinkedList<>();
    public List<Boolean> read(String fileName) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Boolean.parseBoolean(line));
            }
        }
        return list;
    }
    @Override
    public void close() {
        try {
            list.clear();
            list = null;

        } catch (Exception e) {
            System.err.println("Error during cleanup: " + e.getMessage());
        }
    }
}

class FileWriterBoolean  {
    public void write(String fileName, List<Boolean> data) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Boolean i : data) {
                printWriter.println(i);
            }
        }
    }

}