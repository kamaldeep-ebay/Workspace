package a.service.proj;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jettison.json.JSONArray;

import twitter4j.JSONException;
import twitter4j.TwitterException;


// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@XmlRootElement
@Path("/test")
public class ReturnCalls {
	 @GET
	  @Path("/testio")
	  @Produces(MediaType.TEXT_PLAIN)
	//  @Consumes(MediaType.TEXT_PLAIN)
//public HashMap<String, List<String>> getAllTweetsForUser(@QueryParam(value = "user") String user) throws ClientProtocolException, IOException, TwitterException {
	 public String query(String str) throws ClientProtocolException, IOException, org.codehaus.jettison.json.JSONException {
			System.out.println(str);	
		  return SampleIO.getString(str);
	  }
	  
}