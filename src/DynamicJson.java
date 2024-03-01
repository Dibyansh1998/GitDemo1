import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.reusablemethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle)
	{
		String responce=RestAssured.baseURI="http://216.10.245.166";
		given().header("Content-Type","application/json")
		.body(Payload.AddBook(isbn,aisle))
		.post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		//Below line of code convert the String to JSON
		JsonPath js=reusablemethod.rawtoJSON(responce);
		String id=js.get("ID");
		System.out.println(id);
	}
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		//Array: Array is collection of same data type
		//multidimensional array = Collection of array
		return new Object[][] {{"abcd","1234"},{"defg","4567"},{"ghij","7890"}};
	}

}
