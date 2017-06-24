   

	import java.util.Map;
	import java.awt.EventQueue;
	import java.net.URI;
    import org.apache.http.HttpEntity;
    import org.apache.http.HttpResponse;
    import org.apache.http.client.HttpClient;
    import org.apache.http.client.methods.HttpPost;
    import org.apache.http.entity.StringEntity;
    import org.apache.http.client.utils.URIBuilder;
    import org.apache.http.impl.client.DefaultHttpClient;
    import org.apache.http.util.EntityUtils;
    import com.fasterxml.jackson.databind.ObjectMapper;
	import com.fasterxml.jackson.core.JsonParser;
    import com.fasterxml.jackson.core.JsonParseException;
    import com.fasterxml.jackson.core.type.TypeReference;
    import com.fasterxml.jackson.core.type.ResolvedType;
    import com.fasterxml.jackson.core.ObjectCodec;
   // import com.fasterxml.jackson.core.*;

    import com.fasterxml.jackson.core.JsonParser;

    public class Main
    {
        public static void main(String[] args)
        {
            HttpClient httpClient = new DefaultHttpClient();
            
            try
            {
                // NOTE: You must use the same region in your REST call as you used to obtain your subscription keys.
                //   For example, if you obtained your subscription keys from westcentralus, replace "westus" in the 
                //   URL below with "westcentralus".
                URIBuilder uriBuilder = new URIBuilder("https://westus.api.cognitive.microsoft.com/emotion/v1.0/recognize");

                URI uri = uriBuilder.build();
                HttpPost request = new HttpPost(uri);

                // Request headers. Replace the example key below with your valid subscription key.
                request.setHeader("Content-Type", "application/json");
                request.setHeader("Ocp-Apim-Subscription-Key", "24d5cbbfd9ce4f71baef47b58626782f");

                // Request body. Replace the example URL below with the URL of the image you want to analyze.
                StringEntity reqEntity = new StringEntity("{ \"url\": \"http://dreamicus.com/data/face/face-04.jpg\" }");
                request.setEntity(reqEntity);
                

                HttpResponse response = httpClient.execute(request);
                
                HttpEntity entity = response.getEntity();
                
                String str=null;
                System.out.println("HELLO");
                
                if (entity != null)
                {
                	str = EntityUtils.toString(entity);
                    System.out.println(str);
                }
                
        		Window frame = new Window();
        		frame.setVisible(true);

               
                byte[] jsonData = str.getBytes();
                
                ObjectMapper objectMapper = new ObjectMapper();
                 

                Emotions e=objectMapper.readValue(str, Emotions.class);

                System.out.println(e.neutral);
                
            }
            
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                
            }
        }
    }