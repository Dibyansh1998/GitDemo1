package Files;

public class Payload {
	
	public static String Addplace()
	{
		 return "{\r\n"
		 		+ "    \"location\": {\r\n"
		 		+ "        \"lat\": -38.383494,\r\n"
		 		+ "        \"lng\": 33.427362\r\n"
		 		+ "    },\r\n"
		 		+ "    \"accuracy\": 50,\r\n"
		 		+ "    \"name\": \"DibyanshHome\",\r\n"
		 		+ "    \"phone_number\": \"(+91) 6394127924\",\r\n"
		 		+ "    \"address\":\"1457EWS1550_208020\",\r\n"
		 		+ "    \"type\": [\r\n"
		 		+ "        \"shoe park\",\"shop\"\r\n"
		 		+ "    ],\r\n"
		 		+ "    \"website\": \"http://rahulshettyacademy.com\",\r\n"
		 		+ "    \"language\": \"French-IN\"\r\n"
		 		+ "}";
	}
	public static String CousePrice()
	{
		return "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
	}
	public static String AddBook(String isbn, String aisle)
	{
		return "{\r\n"
				+ "    \"name\":\"Learn Appium Automation in Java\",\r\n"
				+ "    \"isbn\":\""+isbn+"\",\r\n"
				+ "    \"aisle\":\""+aisle+"\",\r\n"
				+ "    \"author\":\"John foe\"\r\n"
				+ "}";
	}

}
