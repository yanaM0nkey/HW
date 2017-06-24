package dz13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class JacksonPars {
    
    public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		try {

			// Convert JSON string from file to Object
			Root people = mapper.readValue(new File("E:\\HW\\HW\\dz\\dz13\\test.json"), Root.class);
			System.out.println(people.toString());

			

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    
    /*public static void main(String[] args) {
        readValue();
    }
     
    private static void readValue() {
        ObjectMapper mapper = new ObjectMapper();
        String filepath = File.separator + "test.json";
        try {
            People people = (People) mapper.readValue(new FileInputStream(filepath),
                    People.class);
            System.out.println(people.toString());
        } catch (IOException ex) {
            //Logger.getLogger(JacksonExample.class.getName())
                    //.log(Level.SEVERE, null, ex);
        }
    
    }*/
    
    
    
}
