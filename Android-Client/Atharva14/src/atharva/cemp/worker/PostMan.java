package atharva.cemp.worker;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;
import android.widget.Toast;

public class PostMan {

String response1 = "";
	
	public String post(String json,String url){
		 
		try{
			
		HttpClient httpclient = new DefaultHttpClient();
		
	    HttpPost httppost = new HttpPost(url);	    
	    StringEntity mEntity=new StringEntity(json);
	   
	    httppost.setEntity(mEntity);
	    
	    httppost.setHeader("json",json.toString());
        httppost.getParams().setParameter("jsonpost",mEntity);
	    
	    /*httppost.setHeader("Accept", "application/json");
        httppost.setHeader("Content-type", "application/json");*/
        HttpResponse httpResponse = httpclient.execute(httppost);
        HttpEntity resEntityGet = httpResponse.getEntity();  
        
        if (resEntityGet != null) {  
	        // do something with the response
	       response1 = EntityUtils.toString(resEntityGet);
	       System.out.print("RESPSONSEEEEEEEEE "+response1);
	       Log.e("RESPONSEEEE", "RESPOSN " +response1);
	    }
	    
		}
		catch(Exception e){
			System.out.print("ERRRRRRRRRRRRRRRRR "+e);
			Log.e("ERRRRRR", "iCAMPUS" +e);
		}
		return response1;
	}

}
