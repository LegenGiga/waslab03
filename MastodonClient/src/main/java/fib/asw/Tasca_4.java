package fib.asw;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ContentType;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Tasca_4 {

    private static final String LOCALE = "ca";
    public static void main(String[] args) {


        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM 'de' yyyy 'a les' HH:mm:ss", new Locale(LOCALE));
        String now = sdf.format(new Date());

        String my_status = "Hola, @fib_asw@mastodont.cat, ja sóc aquí! #waslab03\n[" + now + "]";

        JSONObject body = new JSONObject();
        body.put("status", my_status);
        body.put("language", LOCALE);

        String URI = "https://mastodont.cat/api/v1/statuses";
        String TOKEN = ResourceBundle.getBundle("token").getString("token");

        try {
            String output = Request.post(URI)
                    .bodyString(body.toString(), ContentType.parse("application/json"))
                    .addHeader("Authorization","Bearer "+TOKEN)
                    .execute()
                    .returnContent()
                    .asString();

            JSONObject result = new JSONObject(output);
            String id = result.getString("id");
            String url = result.getString("url");
            System.out.format("\n Acabes de publicar un nou tut:\n - id: %s\n - url: %s\n", id, url);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}