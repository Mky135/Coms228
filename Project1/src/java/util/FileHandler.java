package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Miguel Flores
 * A class to ease the handling of files
 */
public class FileHandler extends File {
    /**
     * The path to the file
     */
    private final String fileName;

    /**
     * The {@link File} object representing the file
     */
    private File file;

    /**
     * Creates a new file object using the directory of the fileName
     * @param fileName
     */
    public FileHandler(String fileName) {
        super(fileName);
        this.fileName = fileName;
        file = new File(fileName);
    }

    /**
     * Gets a line of file
     *
     * @param line the line number of the line to be returned
     * @return String of the line specified
     */
    public String getLine(int line) {
        try {
            return Files.readAllLines(Paths.get(fileName)).get(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return Number of lines in the file
     */
    public int getNumLines() {
        int count = 0;
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while (bufferedReader.readLine() != null) {
                    count++;
                }

                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return count;
    }

}