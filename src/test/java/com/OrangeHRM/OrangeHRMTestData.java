package com.OrangeHRM;

import org.testng.annotations.DataProvider;

public class OrangeHRMTestData {
	@DataProvider(name = "Login")
	public Object[][] getDataforLogin() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"Admin", "admin123" },
				{"Aparna", "admin123" },
				{"Aparna1", "admin123" }
				};

}
}