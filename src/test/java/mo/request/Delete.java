package mo.request;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Delete {

	@Test
	public void testDelete() {
		RequestSpecification request = RestAssured.given();
		
		Response response = request.delete("");
		
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
		
		
	}
	
}
