package fib.asw;

import java.util.ResourceBundle;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;

public class Tasca_5 {
	private static final String FIB_ASW_ID = "109862447110628983";
	private static final String STATUSES_REQUEST = String.format(
			"https://mastodont.cat/api/v1/accounts/%s/statuses", FIB_ASW_ID);
	private static final String BOOST_REQUEST = "https://mastodont.cat/api/v1/statuses/%s/reblog";
	
    public static void main(String[] args) {
    	
    	try {
    		String output = Request.get(STATUSES_REQUEST).execute().returnContent().asString();
    		
    		JSONArray jsonStatuses = new JSONArray(output);
    		JSONObject jsonLast = jsonStatuses.getJSONObject(0);
    		String content = jsonLast.getString("content");
    		System.out.println(content);
    		
    		String id = jsonLast.getString("id");
    		String boostURI = String.format(BOOST_REQUEST, id);
    		String TOKEN = ResourceBundle.getBundle("token").getString("token");
    		Request.post(boostURI)
                    .addHeader("Authorization","Bearer "+TOKEN)
                    .execute()
                    .returnContent()
                    .asString();

    		
    		
    	} catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}
