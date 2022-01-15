package mo.request;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Put {

	@Test
	public void testPost() {
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "25");
		json.put("title", "Selenium webdriver");
		json.put("author", "Mike renamed");
		
		request.body(json.toJSONString());
		
		Response response = request.put("");
		
		int code = response.getStatusCode();
		
		System.out.println("Response code " + code);
		
		Assert.assertEquals(code, 200);
		
		
	}
	
	
	
}
