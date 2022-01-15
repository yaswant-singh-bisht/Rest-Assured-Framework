package mo.authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicPreemptiveAuth extends BaseClass_Preemptive {
	
	@Test
	public void auth() {
		int code = RestAssured.given()
//		.auth().preemptive()
//		.basic("ToolsQA", "TestPassword")
//		.when()
//		.get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
		.get()
		.getStatusCode();

		System.out.println("Response code from server is " + code);
	}
	
	
}
