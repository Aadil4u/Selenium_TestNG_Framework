package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
    @DataProvider(name = "loginData")
    public static Object[][] getData() {
        return ExcelReader.getDataFromSheetWithHeaders("login", System.getProperty("user.dir") + "/testdata/Login Data.xlsx");
    }

}
