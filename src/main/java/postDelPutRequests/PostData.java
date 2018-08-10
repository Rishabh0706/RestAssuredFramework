package postDelPutRequests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostData {
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void test1(){
		
		RestAssured.baseURI ="https://reqres.in/api";
		RequestSpecification request =  RestAssured.given();
		request.header("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("name", "sad");
		json.put("job", "leader");
		
		request.body(json.toJSONString());
		
		Response response = request.post("/users");
		
		int code = response.getStatusCode();
		System.out.println("Status Code is ---> "+code);
		Assert.assertEquals(code, 201);
		
	}

}
