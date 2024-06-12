package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//created to perform create,retrieve/read,update and delete request
public class userEndpoints {
	
	public static Response createUser(user payload)
	{
		Response response=given()
			.contentType(ContentType.JSON)		
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(routes.postUrl);
		return response;
	}
	
	public static Response getUser(String username)
	{
		Response response=given()
			.pathParam("username", username)
		.when()
			.get(routes.getUrl	);
		return response;
	}
	
	public static Response updateUser(String username,user payload)
	{
		Response response=given()
			.pathParam("username", username)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.put(routes.putUrl);
		return response;
	}
	public static Response deleteUser(String username)
	{
		Response response=given()
				.pathParam("username", username)
		.when()
			.delete(routes.deleteUrl);
		return response;
	}

}
