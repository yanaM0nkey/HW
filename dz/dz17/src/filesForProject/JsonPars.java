package filesForProject;

import com.google.gson.Gson;
import dz17.Employees;
import dz17.Root;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonPars {

  
    private static final String LINK = "http://kiparo.ru/t/salary.json";
    //DOM парсер
    public static void main(String[] args) {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        
        try {
            //открываем соединение
            URL url = new URL(LINK);
            HttpURLConnection httpURLConnection = 
                    (HttpURLConnection)url.openConnection();
            //получаем код ответа от сайта или сервера
            int responseCode = httpURLConnection.getResponseCode();
            //проверяем успешное ли подключение т.е. проверка на ошибки
            if(responseCode == HttpURLConnection.HTTP_OK){
               inputStream = httpURLConnection.getInputStream();
               File file = new File("salary.json");
               outputStream = new FileOutputStream(file);
               byte[] buffer = new byte[1024]; // то что мы скачиваем т.е. полезная информация
               int bytesRead = -1; //количество прочитанных байт за одно чтение read()
               while((bytesRead = inputStream.read(buffer)) != -1 ){
                   //записываем в файл байтф от 0 до "bytesRead" из массива buffer
                   outputStream.write(buffer, 0, bytesRead);
                   
               }
            } else{
                System.out.println("responseCode = " + responseCode);
            }
            
        } catch (Exception ex) {
            System.out.println("Ошибка" + ex.toString());
        } finally {
            try{
                if(inputStream != null){
                    inputStream.close();
                }
                if(outputStream != null){
                    outputStream.close();
                }
            }catch(Exception e){
                System.out.println("ОШибка при закрытия стрима" + e.toString());
            }
        }
        
        
        
        
        Root root = parseJson("salary.json");
        //Root root = parseGson("salary.json");
        //Root root = parseJackson("salary.json");
        //System.out.println(root.toString());
        
        
    }
    public static Root parseJson(String path){
        JSONParser parser = new JSONParser();
        Root root = null;
        
        try{
            JSONObject rootObj = (JSONObject)parser.parse(new FileReader(path));
            root = new Root();
            String name = (String)rootObj.get("name");
            System.out.println("name = " + name);
            root.setName(name);
            
            String location = (String)rootObj.get("location");
            System.out.println("location = " + location);
            root.setLocation(location);
            
            long baseSalary = (long)rootObj.get("baseSalary");
            System.out.println("baseSalary = " + baseSalary);
            root.setBaseSalary((int)baseSalary);
            
            ArrayList<Employees> employeesList = new ArrayList<>();
            JSONArray employeesArray = (JSONArray)rootObj.get("employees");
            for(Object item: employeesArray){
                JSONObject itemObj = (JSONObject)item;
                Employees employees = new Employees();
                long id = (long)itemObj.get("id");
                String nameEmployee = (String)itemObj.get("name");
                String degree = (String)itemObj.get("degree");
                String dateOfBirth = (String)itemObj.get("dateOfBirth");
                SimpleDateFormat format = new SimpleDateFormat();
                format.applyPattern("yyyy-mm-dd");
                Date docDate= format.parse(dateOfBirth);
                long yearExperience = (long)itemObj.get("yearEperience");
                try{
                    long rate = (long)itemObj.get("rate");
                    employees.setRate(Double.valueOf(rate));
                }catch(Exception e){
                    double rate = (double)itemObj.get("rate");
                    employees.setRate(rate);
                }
                ArrayList<String> emailsList = new ArrayList<>();
                JSONArray emailsArray = (JSONArray)itemObj.get("emails");
                for(Object item2: emailsArray) {
                    emailsList.add(String.valueOf(item2));
                }
                boolean isVisible = (boolean)itemObj.get("visible");
                employees.setId((int)id);
                employees.setName(nameEmployee);
                employees.setDegree(degree);
                employees.setDateOfBirth(docDate);
                employees.setYearExperience((int)yearExperience);
               
                employees.setEmails(emailsList);
                employees.setIsVisible(isVisible);
                employeesList.add(employees); 
                System.out.println(employees.toString());
            }
            root.setEmployees(employeesList);
            
            
            
        } catch(Exception e){
            System.err.println("Ошибка чтения json файла " + e.getMessage());
        }
        return root;
    }
   
    public static Root parseGson(String path){
        Root root = null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            root = gson.fromJson(reader, Root.class);
            
        } catch(Exception e){
            System.err.println("Ошибка чтения json файла " + e.toString());
        }
        
        
        
        return root;
    }
    
    public static Root parseJackson(String path){
        ObjectMapper mapper = new ObjectMapper();
        Root root = null;

		try {

			// Convert JSON string from file to Object
			root = mapper.readValue(new File(path), Root.class);
			//System.out.println(people.toString());

			

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
                return root;
                
    }

    
    
}

