package mo.authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class OAuth2 {

	@Test
	public void accessValidAPI() {
		Response resp = RestAssured
		.given()
		.auth()
		.oauth2("6672931fd7038d9132cb22c3e7b430d19e5a77f9") // existing token
		.post("http://coop.apps.symfonycasts.com/api/2646/chickens-feed");
		
		//System.out.println("Status Code is " + resp.getStatusCode());
		
		//System.out.println("Code is " + resp.body().asString());
		
		Assert.assertEquals(resp.getStatusCode(), 200);
		
		
	}

	@Test
	public void accessInvalidAPI() {
		Response resp = RestAssured
		.given()
		.formParam("client_id", "YashAPITest") // Generate token
		.formParam("client_secret", "31e7515204e34400c94bd773cb65b88c")
		.formParam("grant_type", "client_credentials")
		.post("http://coop.apps.symfonycasts.com/token");
		
		//System.out.println(resp.jsonPath().prettify());
		
		String token = resp.jsonPath().get("access_token");
		System.out.println("Token is - "+token);
		
		Response resp1 = RestAssured
		.given()
		.auth()
		.oauth2(token)
		.post("http://coop.apps.symfonycasts.com/api/2646/eggs-collect");
		
		//System.out.println("Status Code is " + resp.getStatusCode());
		
		//System.out.println("Code is " + resp.body().asString());
		
		Assert.assertEquals(resp1.getStatusCode(), 401);
		
		
	}

}
