package Files;

import io.restassured.path.json.JsonPath;

public class reusablemethod {
	
	public static  JsonPath rawtoJSON(String response)
	{
		JsonPath  js1= new JsonPath(response);
		return js1;
	}

}
