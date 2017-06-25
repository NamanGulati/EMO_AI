   	import java.util.Map;
   	import java.util.Arrays;
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
    	
    	static Employee [] employees = new Employee[8];
    	static int count = 0;
    	
    	
        public static void main(String[] args)
        {
         
            try
            {
            	populate();
            	Window frame = new Window(employees);
        		frame.setVisible(true);
        		                
            }
            
            catch (Exception e)
            {
                System.out.println(e.getMessage());
        		e.printStackTrace(System.out);
            }
        }
        
        public static Emotions determineEmotions(String imagePath) throws Exception
        {	
        	HttpClient httpClient = new DefaultHttpClient();
        	//   NOTE: You must use the same region in your REST call as you used to obtain your subscription keys.
            //   For example, if you obtained your subscription keys from westcentralus, replace "westus" in the 
            //   URL below with "westcentralus"
        	
            URIBuilder uriBuilder = new URIBuilder("https://westus.api.cognitive.microsoft.com/emotion/v1.0/recognize");

            URI uri = uriBuilder.build();
            HttpPost request = new HttpPost(uri);

            // Request headers. Replace the example key below with your valid subscription key.
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "24d5cbbfd9ce4f71baef47b58626782f");

            // Request body. Replace the example URL below with the URL of the image you want to analyze.
            StringEntity reqEntity = new StringEntity(imagePath);
            request.setEntity(reqEntity);
            
            
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            
            String str=null;
            
            if (entity != null)
            {
            	str = EntityUtils.toString(entity);
            	str = str.substring(1, str.length() - 1);
                System.out.println(str);
            }
        	
        	byte [] jsonData = str.getBytes();
            ObjectMapper objectMapper = new ObjectMapper();
            Emotions e = objectMapper.readValue(jsonData, Emotions.class);
            return e;
        }
    
        public static void addEmployee(String [] info, Emotions emos)
        {
        	employees[count] = new Employee(info[0], info[1], info[2], emos, info[3]);
        	System.out.println("Name:" + employees[count].getName());
            System.out.println("Age:" + employees[count].getAge());
            System.out.println("Position:" + employees[count].getPosition());
            System.out.println("Sentiments:" + employees[count].getE().getScores().getNeutral());
            System.out.println("");
            count++;
        }
        
        public static void populate()
        {
        	try
        	{
        	String [] employeeInfo = {"Tyrone", "56", "CEO", "{ \"url\": \"https://s-media-cache-ak0.pinimg.com/originals/41/88/e7/4188e742647bb9bca78a7e9dc46ccaa9.jpg\" }"};
        	addEmployee(employeeInfo, determineEmotions(employeeInfo[3]));
        	
        	String [] employeeInfo1 = {"Simon", "67", "Janitor", "{ \"url\": \"http://debmillswriter.com/wp-content/uploads/2016/03/Blog-Contempt-2-liveforchristresources.jpg\" }"};
        	addEmployee(employeeInfo1, determineEmotions(employeeInfo1[3]));
        	
        	String [] employeeInfo2 = {"Jessica", "17", "Chauffeur", "{ \"url\": \"http://cdn2.stylecraze.com/wp-content/uploads/2015/05/Surprised-Face-exercies.jpg\" }"};
        	addEmployee(employeeInfo2, determineEmotions(employeeInfo2[3]));
        	
        	String [] employeeInfo3 = {"Leo", "42", "VP", "{ \"url\": \"http://i3.kym-cdn.com/entries/icons/original/000/019/712/48029_ori.jpg\" }"};
        	addEmployee(employeeInfo3, determineEmotions(employeeInfo3[3]));
        	
        	String [] employeeInfo4 = {"Sarah", "17", "HR Manager", "{ \"url\": \"http://www.study-body-language.com/images/sadness.jpg\" }"};
        	addEmployee(employeeInfo4, determineEmotions(employeeInfo4[3]));
        	
        	String [] employeeInfo5 = {"Chris", "47", "Chef", "{ \"url\": \"https://previews.123rf.com/images/zzuzya/zzuzya1604/zzuzya160400011/57053528-Man-head-shot-with-neutral-face-expression-and-white-background-Stock-Photo.jpg\" }"};
        	addEmployee(employeeInfo5, determineEmotions(employeeInfo5[3]));
        	
        	String [] employeeInfo6 = {"Benny", "34", "Auditor", "{ \"url\": \"http://www.oscarboy.com/wp-content/uploads/2016/03/cumberbatch.jpeg\" }"};
        	addEmployee(employeeInfo6, determineEmotions(employeeInfo6[3]));
        	
        	String [] employeeInfo7 = {"Donald", "70", "Secretary", "{ \"url\": \"http://religiondispatches.org/wp-content/uploads/2016/10/trump_disgust-690x460.jpg\" }"};
        	addEmployee(employeeInfo7, determineEmotions(employeeInfo7[3]));
        	}
        	catch (Exception e)
            {
                System.out.println(e.getMessage());
        		e.printStackTrace(System.out);
            }
        	
        }
    }