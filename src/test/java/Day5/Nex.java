package Day5;
import org.json.JSONArray;
import org.json.JSONException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

//import net.minidev.json.JSONObject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
public class Nex 
{
	int bookingId = 0;
	int statuscode = 0;
	int count = 1;
	@Test(priority = 1)
	public void testPostUsingExternalFile() throws FileNotFoundException, JSONException, ParseException
	{
		
		String authEndpoint = "https://restful-booker.herokuapp.com/auth";
		HashMap<String, String> credentials = new HashMap<String, String>();
		credentials.put("username", "admin");
		credentials.put("password", "password123");

		Response authResponse = given()
		    .contentType("application/json")
		    .body(credentials)
		    .when()
		    	.post(authEndpoint);

		String token = authResponse.jsonPath().getString("token");

		
		

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("dummy_bookings.json");
		if (inputStream == null) 
		{
		    throw new FileNotFoundException("The file dummy_bookings.json was not found in the classpath");
		}
		Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
		String jsonContent = scanner.hasNext() ? scanner.next() : "";
		scanner.close();
		jsonContent = jsonContent.trim(); // Trim the string to remove any leading/trailing whitespace

		
		JSONArray data = new JSONArray(jsonContent);
		//System.out.println("Number of bookings: " + data.length());

		
		
		for (int i = 0; i < data.length(); i++) 
		{
		    JSONObject booking = data.getJSONObject(i);
		    Response res =  given()
            .contentType("application/json")
            .body(booking.toString())
            //.log().all()  // Log request details
            .when()
            	.post("https://restful-booker.herokuapp.com/booking");
		    statuscode= res.getStatusCode();
		    //Assert.assertEquals(statuscode, 200, "The status code is okay.");
		 
			 bookingId = res.jsonPath().getInt("bookingid");
			 System.out.println("Extracted booking ID: " + bookingId);
			 
			 res.prettyPrint();
			 
			 
			 Response getRes = given()
					 		   .contentType("application/json")
					 		   .when()
					 		   		.get("https://restful-booker.herokuapp.com/booking/" + bookingId);
					 		   statuscode = getRes.getStatusCode();
					 		   //Assert.assertEquals(statuscode, 200, "The status code is okay.");
			 
 		    getRes.prettyPrint();
			 
			 
			 
			 
 		   if (count == 1) {
               booking.put("firstname", booking.getString("firstname") + " Updated");
           } else if (count == 2) {
               booking.put("lastname", booking.getString("lastname") + " Updated");
           } else if (count == 3) {
               int totalPrice = booking.getInt("totalprice");
               booking.put("totalprice", totalPrice + 10);
           } else if (count == 4) {
               boolean depositPaid = booking.getBoolean("depositpaid");
               booking.put("depositpaid", !depositPaid);
           } else if (count == 5) {
               booking.put("additionalneeds", "Modified needs");
           } else if (count == 6 || count == 7) {
               JSONObject bookingDates = booking.getJSONObject("bookingdates");
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               Date checkinDate = sdf.parse(bookingDates.getString("checkin"));
               Date checkoutDate = sdf.parse(bookingDates.getString("checkout"));
               Calendar cal = Calendar.getInstance();
               if (count == 6) {
                   cal.setTime(checkinDate);
                   cal.add(Calendar.DAY_OF_MONTH, 1);
                   bookingDates.put("checkin", sdf.format(cal.getTime()));
               } else {
                   cal.setTime(checkoutDate);
                   cal.add(Calendar.DAY_OF_MONTH, -2);
                   bookingDates.put("checkout", sdf.format(cal.getTime()));
               }
           }
 		    
			 
			 //booking.put("firstname", booking.getString("firstname") + "Updated");
			 //System.out.println("Updated first name: " + booking.getString("firstname"));
			 Response putResponse = given()
					 	.header("Content-Type", "application/json")
					    .header("Accept", "application/json")
					    .header("Cookie", "token=" + token)
				        .body(booking.toString())
				        .when()
				        	.put("https://restful-booker.herokuapp.com/booking/" + bookingId);
			 
			 System.out.println("Record " + bookingId + "updated");
			 statuscode = putResponse.getStatusCode();
			 //Assert.assertEquals(statuscode, 200, "The record is modified.");
			 putResponse.prettyPrint();
			 
			 
			 Response getRes2 = given()
			 		   .contentType("application/json")
			 		   .when()
			 		   		.get("https://restful-booker.herokuapp.com/booking/" + bookingId);
			 		   statuscode = getRes2.getStatusCode();
			 getRes2.prettyPrint();		   
			 
			 
			 
			 
			 Response delres = given()
					    .header("Cookie", "token=" + token)
					    .when()
					    .delete("https://restful-booker.herokuapp.com/booking/" + bookingId);
			 System.out.println("Booking ID " + bookingId + " deleted");
			 statuscode = delres.getStatusCode();
			 //Assert.assertEquals(statuscode, 201, "The record is deleted.");
			 
			 delres.prettyPrint();
			 
			 Response getRes3 = given()
			 		   .contentType("application/json")
			 		   .when()
			 		   		.get("https://restful-booker.herokuapp.com/booking/" + bookingId);
			 		   statuscode = getRes3.getStatusCode();
			 		   //Assert.assertEquals(statuscode, 404, "The record is not found.");
			 getRes3.prettyPrint();	
			 
			 count = count + 1;
			 if(count > 7)
					 count = 1;
		}
	}	
}	
	
	



