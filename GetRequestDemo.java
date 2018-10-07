package basic;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response; 


public class GetRequestDemo {

		/*
		 * Given I have this information
		   When I perform this action
		   Then this should be the output
		 * */		
		@BeforeClass		
		public void setup() {
			RestAssured.baseURI = "https://maps.googleapis.com"; 
			RestAssured.basePath = "/maps/api"; 			
		}
		@Test(enabled=true)		
		public void statusCodeVerification() {
			given()
				.param("units", "imperial")
				.param("origins", "Washington,DC")
				.param("destinations", "New+York+City,NY")
				.param("key", "<<API__key>>")
			.when()
				.get("/distancematrix/json")
			.then()
				.statusCode(200);			
		
	}
		
		@Test
		public void getResponseBody() {
			Response response = 
			given()
				.param("units", "imperial")
				.param("origins", "Washington,DC")
				.param("destinations", "New+York+City,NY")
				.param("key", "AIzaSyCMoOfjyBUtJnqRYxeCI8EXHaiApUNYUv4")
			.when()
				.get("/distancematrix/json");
			System.out.println(response.body().asString());	
		}
}


