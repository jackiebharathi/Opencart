package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = ".\\testData\\Opencart_loginData.xlsx"; // taking Excel file from testData folder
        ExcelUtility xlutil = new ExcelUtility(path); // creating an object for ExcelUtility

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        String logindata[][] = new String[totalrows][totalcols]; // 2D array to store data

        for (int i = 1; i <= totalrows; i++) { // skip header, start from 1
            for (int j = 0; j < totalcols; j++) {
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }
        return logindata; // return 2D array to the test method
    }
}
