package a.service.proj;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import twitter4j.JSONException;
import twitter4j.TwitterException;


// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

@XmlRootElement
@Path("/gramp")
public class ReturnCalls {
	 @GET
	  @Path("/testio")
	  @Produces(MediaType.TEXT_PLAIN)
	  @Consumes(MediaType.TEXT_PLAIN)
	 public String io(@QueryParam(value = "str") String str) throws ClientProtocolException, IOException{
			System.out.println(str);	
		  return SampleIO.getString(str);
	  }
	  
   @GET
   @Path("/getphone")
   @Produces(MediaType.TEXT_PLAIN)
   @Consumes(MediaType.TEXT_PLAIN)
  public String getPhone(@QueryParam(value = "imsi") String imsi) throws ClientProtocolException, IOException {
     System.out.println(imsi);  
     return QuesIO.getPhone(imsi);
   }
	 
   @POST
   @Path("/addphone")
   @Produces(MediaType.TEXT_PLAIN)
   @Consumes(MediaType.APPLICATION_JSON)
  public String addPhone(String input) throws ClientProtocolException, IOException, org.codehaus.jettison.json.JSONException{
	   return QuesIO.addPhone(input);
	       
   }
}
