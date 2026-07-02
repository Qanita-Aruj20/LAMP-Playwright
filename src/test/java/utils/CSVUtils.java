package utils;

import java.io.*;
import java.util.*;

public class CSVUtils {

    public static List<String[]> readCSV(String fileName) {
        List<String[]> data = new ArrayList<>();

        try {
            InputStream is = CSVUtils.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);

            if (is == null) {
                throw new RuntimeException("CSV file not found: " + fileName);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] values = line.split(",");
                    data.add(values);
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}