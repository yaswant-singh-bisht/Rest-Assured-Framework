package mo.authentication;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass_Preemptive {
	
	@BeforeClass
	public void authBase() {
		RestAssured.authentication = RestAssured.preemptive().basic("ToolsQA", "TestPassword");
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication/";
	}
}
