package mo.request;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Post {

	@Test
	public void testPost() {
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "25");
		json.put("title", "Selenium webdriver");
		json.put("author", "Mike Arthur");
		
		request.body(json.toJSONString());
		
		Response response = request.post("");
		
		int code = response.getStatusCode();
		Assert.assertEquals(code, 201);
		
	}
		
}
