package mo.authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CookieAuth {
	@Test
	public void createJSessionID() {
		JSONObject json = new JSONObject();
		json.put("username", ""); // add user id
		json.put("password", ""); // add password
		
		Response resp = RestAssured.given()
		.header("Content-type","")
		.body(json)
		.post("");//Add URL
		
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().jsonPath().prettify());
		String sessionID = resp.getCookies().get("SESSIONID");
		
		Response resp1 = RestAssured.given().contentType(ContentType.JSON)
		.cookie("SESSIONID", sessionID)
		.body("")
		.post();
		
		System.out.println(resp1.getBody().jsonPath().prettify());
		
		
	}

}
