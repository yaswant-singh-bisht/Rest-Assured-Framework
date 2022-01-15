package mo.authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OAuth1 {
	@Test
	public void postTweet() {
		Response resp = RestAssured.given()
		.auth()
		.oauth("hJnCLHWEgs6t8RJc7HmkDC0aC"
				, "vIi4GURHJc2KdnNrpophA4i21D6FRwdsD4YumpKgaq10vXalnE"
				, "872376120284508162-qr3Y6kxebFKZoG9e0TUP78hw39CLaJd"
				, "9hdrrhQt3Y5WTyrl9XjumpgjR1S3tH2AYQDdDotlbT1mq")
		.post("https://api.twitter.com/1.1/statuses/update.json?status=Dummy tweet via API");
		
		System.out.println(resp.getStatusCode());
		
		System.out.println(resp.body().asString());
		
		System.out.println(resp.body().jsonPath().prettify());
		
		JsonPath json = resp.jsonPath();
		String tweetId = json.get("id_str");
				
		System.out.println("Tweet Id is " + tweetId);
		
	}
}
