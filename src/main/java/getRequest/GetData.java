package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

//import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetData {
	
	@Test
	public void testBody(){
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification request = RestAssured.given();
		Response resp = request.get("/Hyderabad");
		
		//Getting response data
		String data = resp.asString();
		System.out.println("Data is ---> "+data);
		
		//Getting response status code
		int code = resp.getStatusCode();
		System.out.println("Status Code is ---> "+code);
		Assert.assertEquals(code, 200);
		
		//Getting response time
		System.out.println("Response Time ---> "+resp.getTime());
		
		//Getting status line
		String statusLine = resp.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		//Getting response headers
		/* Note: Response.GetHeader(String headerName) method does exactly the
		 * same thing as the Response.Header(String headerName) method does*/
		String contentType = resp.header("Content-Type");
		System.out.println("Content-Type value: " + contentType);
	 
		
		String serverType =  resp.header("Server");
		System.out.println("Server value: " + serverType);
	 
		String acceptLanguage = resp.header("Content-Encoding");
		System.out.println("Content-Encoding: " + acceptLanguage);
		
		String cache = resp.header("cache-control");
		System.out.println("Cache-Control: " + cache);
		
		// Get all the headers. Return value is of type Headers.
		// Headers class implements Iterable interface, hence we
		// can apply an advance for loop to go through all Headers
		// as shown in the code below
		Headers allHeaders = resp.headers();
	 
		// Iterate over all the Headers
		for(Header header : allHeaders)
		{
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
		
		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = resp.jsonPath();
	 
		// Let us print the city variable to see what we got
		System.out.println("City received from Response ----> " + jsonPathEvaluator.get("City"));
	 
		// Print the temperature node
		System.out.println("Temperature received from Response ----> " + jsonPathEvaluator.get("Temperature"));
	 
		// Print the humidity node
		System.out.println("Humidity received from Response ----> " + jsonPathEvaluator.get("Humidity"));
	 
		// Print weather description
		System.out.println("Weather description received from Response ----> " + jsonPathEvaluator.get("WeatherDescription"));
	 
		// Print Wind Speed
		System.out.println("Wind Speed received from Response ----> " + jsonPathEvaluator.get("WindSpeed"));
	 
		// Print Wind Direction Degree
		System.out.println("Wind Direction Degree received from Response ----> " + jsonPathEvaluator.get("WindDirectionDegree"));
	}
}
