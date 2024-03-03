import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import Files.Payload;
import Files.reusablemethod;

public class Basics {

	public static void main(String[] args) throws IOException {
		
		//Validate if Add Place API is working as expected 
		// We're using three method 
		//("given":all input details 
		// ("when" : Submit the API (Resource and HTTP method will go to this method
		// "then" :validate the response
		//Add place-> update Place with New Address -> Get Place to validate if New  Address is present in response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\dibya\\OneDrive\\Documents\\OneNote Notebooks\\Student.json")))).when().post("maps/api/place/add/json")
						.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
						.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		JsonPath js= new JsonPath(response);
		String placeID=js.get("place_id");
		System.out.println(placeID);
		
		//Update Place
		String newAddress= "1451EWS1550_208021";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-type","application/json")
		.body("{\r\n"
				+ "    \"place_id\": \""+placeID+"\",\r\n"//This is the PostAPI means new address added and get place id in response
				+ "    \"address\": \""+newAddress+"\",\r\n"//here we're updating the address on which old place id get.
				+ "    \"key\": \"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//GetPlace
		
		String getPlaceResponse= given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeID)
		.when().get("maps/api/place/get/json")
		.then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1=reusablemethod.rawtoJSON(getPlaceResponse);
		String actualAddress=js1.getString(getPlaceResponse);
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
						
	}

}
