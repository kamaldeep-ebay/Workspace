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

import twitter4j.JSONException;
import twitter4j.TwitterException;


// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

@XmlRootElement
@Path("/localo")
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
   @Path("/getques")
   @Produces(MediaType.TEXT_PLAIN)
   @Consumes(MediaType.TEXT_PLAIN)
  public String getQues(@QueryParam(value = "ques") String ques) throws ClientProtocolException, IOException {
     System.out.println(ques);  
     return QuesIO.getQues(ques);
   }
	 
	 @GET
   @Path("/getquesoncat")
   @Produces(MediaType.TEXT_PLAIN)
   @Consumes(MediaType.TEXT_PLAIN)
  public String getQuesForCategory(@QueryParam(value = "category") String category) throws ClientProtocolException, IOException {
     System.out.println(category);  
     return QuesIO.getQuesForCategory(category);
   }
	 
	 @POST
   @Path("/addques")
   @Produces(MediaType.TEXT_PLAIN)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public String addQues(@FormParam("ques") String ques,
      @FormParam("category") String category) throws ClientProtocolException, IOException {
     System.out.println(ques);  
     return String.valueOf(QuesIO.addQues(ques,category));
   }
	 
	 @GET
   @Path("/removeques")
   @Produces(MediaType.TEXT_PLAIN)
   @Consumes(MediaType.TEXT_PLAIN)
  public String removeQues(@QueryParam(value = "ques") String ques) throws ClientProtocolException, IOException {
     System.out.println(ques);  
     return QuesIO.removeQues(ques);
   }
	 
	 @POST
   @Path("/linkques")
   @Produces(MediaType.TEXT_PLAIN)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public void linkQues(@FormParam("ques") String ques,
      @FormParam("oldcategory") String oldcategory,
      @FormParam("newcategory") String newcategory) throws ClientProtocolException, IOException{
	       System.out.println(ques+oldcategory+newcategory);
	       QuesIO.changeCategoryForQues( ques, oldcategory, newcategory);
	       
   }
}
