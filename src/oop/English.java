package oop;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//import javax.net.ssl.HttpsURLConnection;

public class English {
	
	public Object executePost(String targetURL, String urlParameters) {
		  HttpURLConnection con = null;

		  try {
		    //Create connection
		    URL url = new URL(targetURL);
		    con = (HttpURLConnection) url.openConnection();
		    con.setRequestMethod("POST");
		    con.setRequestProperty("Content-Type", 
		        "application/x-www-form-urlencoded");

		    con.setRequestProperty("Content-Length", 
		        Integer.toString(urlParameters.getBytes().length));
		    con.setRequestProperty("Content-Language", "en-US");  

		    con.setUseCaches(false);
		    con.setDoOutput(true);

		    //Send request
		    DataOutputStream wr = new DataOutputStream (
		    		con.getOutputStream());
		    wr.writeBytes(urlParameters);
		    wr.close();

		    //Get Response  
		    InputStream is = con.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    StringBuilder res = new StringBuilder(); // or StringBuffer if Java version 5+
		    String line;
		    while ((line = rd.readLine()) != null) {
		      res.append(line);
		      res.append('\r');
		    }
		    rd.close();
		    Object x = res;
		    return x;
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
		    if (con != null) {
		    	con.disconnect();
		    }
		  }
		}
	
//
//	 String urlParameters =
//	        "fName=" + URLEncoder.encode("???", "UTF-8") +
//	        "&lName=" + URLEncoder.encode("???", "UTF-8");
	

	
	
	

}
