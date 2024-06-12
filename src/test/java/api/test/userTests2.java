package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndpoints2;
import api.payload.user;

import io.restassured.response.Response;

public class userTests2 {
	
	Faker faker=new Faker();
	user userPayload=new user();
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUserStatus(0);
		//logs
		logger=LogManager.getLogger(this.getClass());
	}
	@Test(priority=1)
	public void createUserRespose()
	{
		logger.info("**************Creating user**************");
		Response response= userEndpoints2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("**************user is created**************");
		
	}
	@Test(priority=2)
	public void getUserRespose()	
	{
		logger.info("**********Fetching user infomation*********");
		Response response= userEndpoints2.getUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("*******user infomation displayed************");
	}
	@Test(priority=3)
	public void updateUserRespose()
	{
		logger.info("************Updating user infomation*******");
		//updating the data
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		Response response= userEndpoints2.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();//we can also do like response.then().log().body().statusCode(200)
		Assert.assertEquals(response.getStatusCode(),200);//assert isn't needed if we do above step
		getUserRespose();
		logger.info("**************Updataion complete***********");
	}
	@Test(priority=4)
	public void deleteUserRespose()
	{
		logger.info("**************Deleting user****************");
		Response response= userEndpoints2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("**************Deletion complete************");
	}

}
