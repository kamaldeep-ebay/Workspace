package a.service.proj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class QuesIO {

	static volatile HashMap<String, DataModel> dataPoints = new HashMap<String, DataModel>();	 
  
   	public static String getPhone(String imsi) {
	// TODO Auto-generated method stub
	
   		if(dataPoints.containsKey(imsi))
   			return dataPoints.get(imsi).toString();
   		else
   			return "Phone not present";
  }

	//public static String addPhone(JSONArray input) throws JSONException {
   	public static String addPhone(String input1){
	// TODO Auto-generated method stub
		
		// check valid JSON
		//JSONArray ar = (JSONArray)input;
		
   		  String rssi=null;
		  Integer pos_x=null;
		  Integer pos_y=null;
		  String imsi=null;
		  Long time=null;
		  
		  JSONObject input;
		try {
			input = new JSONObject(input1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return "Invalid JSON";
		}
		  
		  try {
			if(input.getString("rssi")!=null)
				  rssi = input.getString("rssi");
			  else
				  return "Invalid input";
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return "Invalid JSON".concat(".Missing rssi");
		}
		  
		  
		  try {
			if(((Integer)input.getInt("pos_x"))!=null)
				  pos_x=input.getInt("pos_x");
			  else
				  return "Invalid input";
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return "Invalid JSON".concat(".Missing x position");
		}
		 
		  try {
			if(((Integer)input.getInt("pos_y"))!=null)
				  pos_y=input.getInt("pos_y");
			  else
				  return "Invalid input";
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return "Invalid JSON".concat(".Missing y position");
		}
		  
		  try {
			if(input.getString("imsi")!=null)
				  imsi = input.getString("imsi");
			  else
				  return "Invalid input";
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return "Invalid JSON".concat(".Missing imsi");
		}
		  
		  try {
			if(((Long)input.getLong("time"))!=null)
				  time=input.getLong("time");
			  else
				  return "Invalid input";
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return "Invalid JSON".concat(".Missing time");
		}
		  
		  DataModel dm = new DataModel(rssi, pos_x, pos_y, imsi, time);
		  
		  dataPoints.put(imsi, dm);
		  System.out.println("added:"+dm.toString());	
		  return "Successful Input";
  }
  
}
