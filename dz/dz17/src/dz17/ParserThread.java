package dz17;

//этот поток ждет пока скачается JSON затем парсит его


import java.io.FileReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//потом снова ждет XML и парсит его
public class ParserThread extends Thread{

    private DownloaderThread downloaderThread;

    public void setDownloaderThread(DownloaderThread downloaderThread) {
        this.downloaderThread = downloaderThread;
    }
    
    
    @Override
    public void run() {
         
        
        synchronized(this){
            
            //спим, ждем вызова с другого потока
            System.out.println("P - спим");
            try {
                wait();
            } catch (InterruptedException ex) {
                
            }
        }
        System.out.println("P - парсим JSON");
        
        //парсим JSON
        Root rootJson = parseJson("salary.json");
        
        synchronized(downloaderThread){
            //пробуждаем другой поток
            System.out.println("P - пробуждаем другой поток");
            downloaderThread.notifyAll();
            //спим, ждем вызова с другого потока
            System.out.println("P - спим");
            
            
        }
        synchronized(this){
            try {
                    wait();
                } catch (InterruptedException ex) {

                }
        }
        System.out.println("P - парсим XML");
        
       
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

       
        System.out.println("P - завершаем работу");
       
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
                java.util.Date docDate= format.parse(dateOfBirth);
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
    
}
