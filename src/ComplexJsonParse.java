import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(Payload.CousePrice());

		// Print number of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);

		// Print purchase Amount
		int purchaseAmmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmmount);

		// Print title of the first course
		String titleFirstCourse = js.get("courses[0].title");
		System.out.println(titleFirstCourse);

		// Print all course prices with respective prices
		for (int i = 0; i < count; i++) {
			String coursesTitles = js.get("courses[" + i + "].title");
			System.out.println(js.get("courses[" + i + "].price").toString());
			System.out.println(coursesTitles);

		}
		// Print number of copies sold by RPA Course
		System.out.println("Print number of copies sold by RPA Course");
		for (int i = 0; i < count; i++) {
			String coursesTitles = js.get("courses[" + i + "].title");
			if (coursesTitles.equalsIgnoreCase("RPA")) {
				// Copies Sold
				int copies_rate = js.get("courses[" + i + "].copies");
				System.out.println(copies_rate);
				break;
			}

		}

	}

}
