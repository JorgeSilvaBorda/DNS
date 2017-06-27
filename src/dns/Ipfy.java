package dns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Jorge Silva Borda
 */
public class Ipfy {
    private URL url;
    private HttpsURLConnection conexion;
    private String direccion = Parametros.URLIP;
    
    
    public JSONObject getIp(){
        JSONObject json;
        try{
            this.url = new URL(this.direccion);
            this.conexion = (HttpsURLConnection)url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String linea;
            while((linea = br.readLine()) != null){
                builder.append(linea);
                builder.append(Parametros.SEP);
            }
            json = new JSONObject(builder.toString());
            return json;
        }catch (IOException | JSONException ex) {
            System.out.println("No se pudo obtener la ip.");
            System.out.println(ex);
            json = new JSONObject();
            json.put("estado", "error");
            json.put("error", ex.toString());
            return json;
        }
    }
}
