package data;

import org.testng.annotations.DataProvider;
import utils.CSVUtils;
import java.util.List;

public class TestData {

    @DataProvider(name = "loginData")
    public Object[][] getData() {

        List<String[]> csvData = CSVUtils.readCSV("testdata.csv");

        Object[][] data = new Object[csvData.size()][2];

        for (int i = 0; i < csvData.size(); i++) {
            data[i][0] = csvData.get(i)[0].trim().replace("\"", "");
            data[i][1] = csvData.get(i)[1].trim().replace("\"", "");
        }

        return data;
    }
}