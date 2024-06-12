package api.endpoints;

/*Main URL - https://petstore.swagger.io/
 * post(create user) - https://petstore.swagger.io/v2/user
 * get(get user) - https://petstore.swagger.io/v2/user/{username}
 * put(update user) - https://petstore.swagger.io/v2/user/{username}
 * delete(delete user) - https://petstore.swagger.io/v2/user/{username}
 */
public class routes {

	public static String baseUrl="https://petstore.swagger.io/v2";
	public static String postUrl=baseUrl+"/user";
	public static String getUrl=baseUrl+"/user/{username}";
	public static String putUrl=baseUrl+"/user/{username}";
	public static String deleteUrl=baseUrl+"/user/{username}";
	
}
