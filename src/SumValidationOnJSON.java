import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidationOnJSON {

	@Test
	public void sumofcources() {
		JsonPath js = new JsonPath(Payload.Cousename());
		int count = 0;
		for (int i = 0; i < count; i++) {
			int price = js.get("courses[" + i + "].price");
			int copies = js.get("courses[" + i + "].copies");
			int amount = price * copies;
			System.out.println(amount);
			
		}
	}

}
