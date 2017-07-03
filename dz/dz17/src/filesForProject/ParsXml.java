package filesForProject;

import dz17.Employees;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ParsXml {
    private static final String LINK = "http://kiparo.ru/t/salary.xml";
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
               File file = new File("salary.xml");
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
        
        //парсим XML
        Document dom = null;
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//за нас делает new
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("salary.xml");                   
        }catch(Exception e){
            System.out.println("Ошибка открытия файла" + e.toString());
            return;
        }
        Element root = dom.getDocumentElement();
        System.out.println("tag 1 = " + root.getTagName());
        
        NodeList nameNodeList = root.getElementsByTagName("name");
        Node nameNode = nameNodeList.item(0);
        System.out.println("tag 2 = " + nameNode.getNodeName());
        
        String name = nameNode.getFirstChild().getNodeValue();
        System.out.println("name = " + name);
        
        NodeList locationNodeList = root.getElementsByTagName("location");
        Node locationNode = locationNodeList.item(0);
        System.out.println("tag 3 = " + locationNode.getNodeName());
        
        String location = locationNode.getFirstChild().getNodeValue();
        System.out.println("location = " + location);
        
        NodeList baseSalaryNodeList = root.getElementsByTagName("baseSalary");
        Node baseSalaryNode = baseSalaryNodeList.item(0);
        System.out.println("tag 4 = " + baseSalaryNode.getNodeName());
        
        String baseSalary = baseSalaryNode.getFirstChild().getNodeValue();
        System.out.println("baseSalary = " + baseSalary);
        
        NodeList employeesNodeList = root.getElementsByTagName("employees");
        
        Node employeesNode = employeesNodeList.item(0);
        System.out.println("tag 5 = " + employeesNode.getNodeName());

        //NodeList elementsNodeList = employeesNode.getChildNodes();

        ArrayList<Employees> list = new ArrayList<>();

        for (int i = 0; i < employeesNodeList.getLength(); i++) {

            Node node = employeesNodeList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Employees el = new Employees();

            System.out.println("======================================");

            Element element = (Element) node;
            System.out.println("tag = " + node.getNodeName());
            
            //id
            String id = element.getElementsByTagName("id").item(0).getTextContent();
            System.out.println("id : " + id);

            el.setId(Integer.valueOf(id));

            // name
            NodeList nameElemlist = element.getElementsByTagName("name");
            System.out.println("length: " + nameElemlist.getLength());
            Element nameElement = (Element) nameElemlist.item(0);
            String nameEmployees = nameElement.getFirstChild().getNodeValue();
            System.out.println("name : " + nameEmployees);

            el.setName(nameEmployees);
            
            //degree
            NodeList degreeElemlist = element.getElementsByTagName("degree");
            Element degreeElement = (Element) degreeElemlist.item(0);
            String degreeEmployees = degreeElement.getFirstChild().getNodeValue();
            System.out.println("degree : " + degreeEmployees);

            el.setDegree(degreeEmployees);
            
            //dateOfBirth
            NodeList dateOfBirthElemlist = element.getElementsByTagName("dateOfBirth");
            Element dateOfBirthElement = (Element)dateOfBirthElemlist.item(0);
            String dateOfBirthEmployees = dateOfBirthElement.getFirstChild().getNodeValue();
            System.out.println("dateOfBirth : " + dateOfBirthEmployees);

            el.setDateOfBirth(Date.valueOf(dateOfBirthEmployees));
            
            //yearExperience
            String yearExperience = element.getElementsByTagName("yearEperience").item(0).getTextContent();
            System.out.println("yearExperience : " + yearExperience);

            el.setYearExperience(Integer.valueOf(yearExperience));
            
            //rate
            String rate = element.getElementsByTagName("rate").item(0).getTextContent();
            System.out.println("rate : " + rate);

            el.setRate(Double.valueOf(rate));
            
            //emails
            NodeList emailsElemlist = element.getElementsByTagName("emails");
            ArrayList<String> emailsList = new ArrayList<>();
            int h = emailsElemlist.getLength();
            System.out.println("length emails: " + h);
            for(int k = 0; k < emailsElemlist.getLength(); k++){
                Element emailsElement = (Element)emailsElemlist.item(k);
                String email = emailsElement.getFirstChild().getNodeValue();
                System.out.println("email: " + email);
                emailsList.add(email);
            }
            System.out.println(emailsList.toString());
            el.setEmails(emailsList);
            
            //visible
            String isVisible = element.getElementsByTagName("visible").item(0).getTextContent();
            System.out.println("isVisible : " + isVisible);

            el.setIsVisible(Boolean.valueOf(isVisible));

            list.add(el);
        }

        for(Employees e: list) {

         System.out.println(e.toString());

        }
        
        
        
    
    }
}
