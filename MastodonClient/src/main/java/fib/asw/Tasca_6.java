package fib.asw;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.hc.client5.http.fluent.Request;
import org.json.JSONArray;
import org.json.JSONObject;

public class Tasca_6 {
	
	private static final String WEB_TEMPLATE = "<head>\n" + 
			"    <meta charset=\"UTF-8\">\n" + 
			"    <title>Darrers tuts dels comptes seguits</title>\n" + 
			"    <style>\n" + 
			"  :root {\n" + 
			"    --primary-color: #1da1f2;\n" + 
			"    --secondary-color: #17bf63;\n" + 
			"    --background-color: #ffffff;\n" + 
			"    --card-bg: #fefefe;\n" + 
			"    --header-bg: #f8f9fa;\n" + 
			"    --text-color: #333333;\n" + 
			"    --muted-text: #6c757d;\n" + 
			"    --border-radius: 8px;\n" + 
			"  }\n" + 
			"\n" + 
			"  body {\n" + 
			"    font-family: \"Helvetica Neue\", Arial, sans-serif;\n" + 
			"    margin: 0;\n" + 
			"    padding: 20px;\n" + 
			"    background-color: var(--background-color);\n" + 
			"    color: var(--text-color);\n" + 
			"    line-height: 1.6;\n" + 
			"  }\n" + 
			"\n" + 
			"  .header {\n" + 
			"    background-color: var(--header-bg);\n" + 
			"    padding: 20px;\n" + 
			"    margin-bottom: 30px;\n" + 
			"    border-radius: var(--border-radius);\n" + 
			"    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" + 
			"  }\n" + 
			"\n" + 
			"  .header h1 {\n" + 
			"    margin: 0 0 10px;\n" + 
			"    font-size: 1.8em;\n" + 
			"  }\n" + 
			"\n" + 
			"  .account {\n" + 
			"    background-color: var(--card-bg);\n" + 
			"    padding: 20px;\n" + 
			"    margin: 15px 0;\n" + 
			"    border-radius: var(--border-radius);\n" + 
			"    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);\n" + 
			"  }\n" + 
			"\n" + 
			"  .account-avatar {\n" + 
			"    width: 40px;\n" + 
			"    height: 40px;\n" + 
			"    border-radius: 50%;\n" + 
			"    vertical-align: middle;\n" + 
			"    margin-right: 10px;\n" + 
			"  }\n" + 
			"\n" + 
			"  .tut {\n" + 
			"    border-left: 4px solid var(--primary-color);\n" + 
			"    padding: 15px;\n" + 
			"    margin: 15px 0;\n" + 
			"    background-color: #ffffff;\n" + 
			"    border-radius: var(--border-radius);\n" + 
			"    transition: transform 0.2s;\n" + 
			"  }\n" + 
			"\n" + 
			"  .tut:hover {\n" + 
			"    transform: translateX(5px);\n" + 
			"  }\n" + 
			"\n" + 
			"  .timestamp {\n" + 
			"    color: var(--muted-text);\n" + 
			"    font-size: 0.85em;\n" + 
			"  }\n" + 
			"\n" + 
			"  .emoji {\n" + 
			"    height: 1.2em;\n" + 
			"    vertical-align: middle;\n" + 
			"  }\n" + 
			"\n" + 
			"  .reblog {\n" + 
			"    border-left-color: var(--secondary-color);\n" + 
			"  }\n" + 
			"\n" + 
			"  .error {\n" + 
			"    color: #b71c1c;\n" + 
			"    padding: 15px;\n" + 
			"    background-color: #ffebee;\n" + 
			"    border-radius: var(--border-radius);\n" + 
			"    border: 1px solid #f44336;\n" + 
			"  }\n" + 
			"\n" + 
			"    </style>\n" + 
			"</head>\n" + 
			"<body>\n" + 
			"<div class=\"header\">\n" + 
			"<h1>Els cinc tuts més recents + informació del comptes seguits per l'usuari 'fib_asw'</h1>\n" + 
			"<p>%s</p>\n" + 
			"</div>\n" + 
			"%s" +
			"</body>";
	private static final String FIB_ASW_ID = "109862447110628983";
	private static final String ACCOUNTS_FOLLOW_REQUEST = String.format(
			"https://mastodont.cat/api/v1/accounts/%s/followers", FIB_ASW_ID);
	
    public static void main(String[] args) {
    	List<JSONObject> accountObjects = new ArrayList<JSONObject>();
    	
    	try {
    		String output = Request.get(ACCOUNTS_FOLLOW_REQUEST).execute().returnContent().asString();
    		
    		JSONArray jsonAccounts = new JSONArray(output);
    		int numAccounts = jsonAccounts.length();
    		
    		accountObjects = new ArrayList<JSONObject>(numAccounts);
    		for (int i = 0; i < numAccounts; i++) {
    			accountObjects.add(i, jsonAccounts.getJSONObject(i));
    		}
    		

    	} catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
