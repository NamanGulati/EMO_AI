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
    	
    	static Employee [] employees = new Employee[10];
    	static int count = 0;
    	
    	
        public static void main(String[] args)
        {
         
            try
            {
            	
            	Window frame = new Window(employees);
        		frame.setVisible(true);
        		
        		String [] employeeInfo = null;
        		
        		while(employeeInfo == null);
        		{
        			employeeInfo = frame.inputVariables();
        		}
        		
        		System.out.println(Arrays.toString(employeeInfo));
        		addEmployee(employeeInfo, determineEmotions(employeeInfo[3]));
                
                
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
        	System.out.println(employees[count]);
        	System.out.println(employees[count].getName());
            System.out.println(employees[count].getAge());
            System.out.println(employees[count].getPosition());
            System.out.println(employees[count].getE().getScores().getNeutral());
            System.out.println(employees[count].getPath());
        	/*
        	for(int i=0;i<employees.length-1;i++){
        		employees[i]=new Employee("Bob","54","Manager",emos,"C");
        	}
        	employees[employees.length-1]=new Employee("Bill","54","Manager",emos,"C");
        	*/
        }
    }