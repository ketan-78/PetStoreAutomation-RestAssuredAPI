package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndpoints;
import api.payload.user;
import api.utilities.dataProviders;
import io.restassured.response.Response;

public class daraDrivenTests {
	
	@Test(priority=1,dataProvider="Data",dataProviderClass = dataProviders.class)
	public void postUserData(String userID,String userName,String firstName,String lastName,String Email,String password,String phoneNum)
	{
		user userPayload=new user();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastname(lastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(password);
		userPayload.setPhone(phoneNum);
		Response response= userEndpoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=2,dataProvider="UserNames",dataProviderClass = dataProviders.class)
	public void deleteUserByName(String userName)
	{
		Response response= userEndpoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(),200);
	}

}
