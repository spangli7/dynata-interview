package survey.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneralFileReader {

    public static List<String> readLines(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("This file is not found");
        } catch (IOException e) {
            System.out.println("Error reading file " + e.getMessage());
        }

        return lines;

    }

}
