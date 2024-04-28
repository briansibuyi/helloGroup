package APITesting;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class APITest {

	@Test
	public void APIcall() throws InterruptedException {
		
		Response respond = get("https://restapiexample.com/countryName=India");
		Thread.sleep(1000);
		//Response respond = get("https://dummy.restapiexample.com/api/v1/employees");
		
		System.out.println(respond.getStatusCode());
		System.out.println(respond.getTime());
		System.out.println(respond.getBody().asString());
		System.out.println(respond.getHeader("Content-type"));
		
		//Verifying results
		int statusCode = respond.getStatusCode();
		AssertJUnit.assertEquals(statusCode, 200);	
		Thread.sleep(2000);
	}
	
	@Test
	public void APICallPerRecord() throws InterruptedException {
		
		baseURI = "https://dummy.restapiexample.com/api";
		Thread.sleep(1000);
		given()
			.get("/v1/employee/1")
		.then()
			.statusCode(200)
			.log().all();
		Thread.sleep(2000);
	}
	
	@Test
	public void APICallPost() throws InterruptedException {
		baseURI = "https://dummy.restapiexample.com/api";
		//Map<String,Object> map = new HashMap<String,Object>();
		//map.put("test","123");
		
		JSONObject request = new JSONObject();
		
		request.put("test","137");
		Thread.sleep(1000);
		given()
			.body(request.toJSONString())
		.when()
			.post("/v1/create")
		.then()
			.statusCode(200)
			.log().all();
		Thread.sleep(2000);
	}	
}
