package a.service.proj;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;



public class SampleIO {

   
  public static String getString(String str) throws ClientProtocolException, IOException, JSONException{
   
    
    //  sed 's/"//g' a | tr -d '\n'
    
    // Assumed that " is escaped with \ and newline is removed.  
    
    String st = "[    {        \"ifa\": \"D169FDBA-A760-4FF8-8874-071EB367A687\",        \"appid\": \"ebay-int-test\",        \"eventname\": \"test_ebay_event\",        \"test_ebay_param01\": \"test_ebay_value01\",        \"test_ebay_param02\": \"test_ebay_value02\",        \"test_ebay_param03\": \"test_ebay_value03\",        \"test_ebay_param04\": \"test_ebay_value04\",        \"test_ebay_param05\": \"test_ebay_value05\",        \"test_ebay_param06\": \"test_ebay_value06\",        \"test_ebay_param07\": \"test_ebay_value07\",        \"test_ebay_param08\": \"test_ebay_value08\",        \"test_ebay_param09\": \"test_ebay_value09\",        \"test_ebay_param10\": \"test_ebay_value10\"    },    {        \"ifa\": \"D169FDBA-A760-4FF8-8874-071EB367A687\",        \"appid\": \"ebay-int-test\",        \"eventname\": \"test_ebay_event\",        \"test_ebay_param01\": \"test_ebay_value01\",        \"test_ebay_param02\": \"test_ebay_value02\",        \"test_ebay_param03\": \"test_ebay_value03\",        \"test_ebay_param04\": \"test_ebay_value04\",        \"test_ebay_param05\": \"test_ebay_value05\",        \"test_ebay_param06\": \"test_ebay_value06\",        \"test_ebay_param07\": \"test_ebay_value07\",        \"test_ebay_param08\": \"test_ebay_value08\",        \"test_ebay_param09\": \"test_ebay_value09\",        \"test_ebay_param10\": \"test_ebay_value10\"    },    {        \"ifa\": \"D169FDBA-A760-4FF8-8874-071EB367A687\",        \"appid\": \"ebay-int-test\",        \"eventname\": \"test_ebay_event\",        \"test_ebay_param01\": \"test_ebay_value01\",        \"test_ebay_param02\": \"test_ebay_value02\",        \"test_ebay_param03\": \"test_ebay_value03\",        \"test_ebay_param04\": \"test_ebay_value04\",        \"test_ebay_param05\": \"test_ebay_value05\",        \"test_ebay_param06\": \"test_ebay_value06\",        \"test_ebay_param07\": \"test_ebay_value07\",        \"test_ebay_param08\": \"test_ebay_value08\",        \"test_ebay_param09\": \"test_ebay_value09\",        \"test_ebay_param10\": \"test_ebay_value10\"    },    {        \"ifa\": \"D169FDBA-A760-4FF8-8874-071EB367A687\",        \"appid\": \"ebay-int-test\",        \"eventname\": \"test_ebay_event\",        \"test_ebay_param01\": \"test_ebay_value01\",        \"test_ebay_param02\": \"test_ebay_value02\",        \"test_ebay_param03\": \"test_ebay_value03\",        \"test_ebay_param04\": \"test_ebay_value04\",        \"test_ebay_param05\": \"test_ebay_value05\",        \"test_ebay_param06\": \"test_ebay_value06\",        \"test_ebay_param07\": \"test_ebay_value07\",        \"test_ebay_param08\": \"test_ebay_value08\",        \"test_ebay_param09\": \"test_ebay_value09\",        \"test_ebay_param10\": \"test_ebay_value10\"    },    {        \"ifa\": \"D169FDBA-A760-4FF8-8874-071EB367A687\",        \"appid\": \"ebay-int-test\",        \"eventname\": \"test_ebay_event\",        \"test_ebay_param01\": \"test_ebay_value01\",        \"test_ebay_param02\": \"test_ebay_value02\",        \"test_ebay_param03\": \"test_ebay_value03\",        \"test_ebay_param04\": \"test_ebay_value04\",        \"test_ebay_param05\": \"test_ebay_value05\",        \"test_ebay_param06\": \"test_ebay_value06\",        \"test_ebay_param07\": \"test_ebay_value07\",        \"test_ebay_param08\": \"test_ebay_value08\",        \"test_ebay_param09\": \"test_ebay_value09\",        \"test_ebay_param10\": \"test_ebay_value10\"    },    {        \"ifa\": \"D169FDBA-A760-4FF8-8874-071EB367A687\",        \"appid\": \"ebay-int-test\",        \"eventname\": \"test_ebay_event\",        \"test_ebay_param01\": \"test_ebay_value01\",        \"test_ebay_param02\": \"test_ebay_value02\",        \"test_ebay_param03\": \"test_ebay_value03\",        \"test_ebay_param04\": \"test_ebay_value04\",        \"test_ebay_param05\": \"test_ebay_value05\",        \"test_ebay_param06\": \"test_ebay_value06\",        \"test_ebay_param07\": \"test_ebay_value07\",        \"test_ebay_param08\": \"test_ebay_value08\",        \"test_ebay_param09\": \"test_ebay_value09\",        \"test_ebay_param10\": \"test_ebay_value10\"    }]";
   
    StringBuffer strbuf  = new StringBuffer();
    JSONArray jsar = new JSONArray(st);

    for(int i=0;i<jsar.length();i++)
    {
      JSONObject obj = new JSONObject(jsar.get(i).toString());
      
      strbuf.append(obj.toString());
      strbuf.append("\n\n");
      
    }
   
    return strbuf.toString();
  }
}
