package mo.request;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {

	@Test
	public void testResponseCode() {
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,u&appid=b1b15e88fa797225412429c1c50c122a1");
		int statusCode = resp.getStatusCode();
		System.out.println("Status code is " + statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	public void testBody() {
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,u&appid=b1b15e88fa797225412429c1c50c122a1");
		String data = resp.asString();
		
		System.out.println("Data body is " + data);
		
		System.out.println("Response time is " + resp.getTime());
	
	}
	
}
