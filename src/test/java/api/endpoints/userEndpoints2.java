package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//created to perform create,retrieve/read,update and delete request
public class userEndpoints2 {
	
	// method created for getting URL's from properties file
	public static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");// Load properties file
		return routes;
	}
	
	public static Response createUser(user payload)
	{
		String postUrl=getURL().getString("postUrl");
		Response response=given()
			.contentType(ContentType.JSON)		
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(postUrl);
		return response;
	}
	
	public static Response getUser(String username)
	{
		String getUrl=getURL().getString("getUrl");
		Response response=given()
			.pathParam("username", username)
		.when()
			.get(getUrl);
		return response;
	}
	
	public static Response updateUser(String username,user payload)
	{
		String putUrl=getURL().getString("putUrl");
		Response response=given()
			.pathParam("username", username)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.put(putUrl);
		return response;
	}
	public static Response deleteUser(String username)
	{
		String deleteUrl=getURL().getString("deleteUrl");
		Response response=given()
				.pathParam("username", username)
		.when()
			.delete(deleteUrl);
		return response;
	}

}
