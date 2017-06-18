package dz12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

// SAX
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler; 


public class SAXPars {

    
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        factory.setValidating(true);
        factory.setNamespaceAware(false);
        SAXParser parser;

        InputStream xmlData = null;
        try
        {
            xmlData = new FileInputStream("test.xml");

            parser = factory.newSAXParser();
            parser.parse(xmlData, new MyParser());

            
        } catch (FileNotFoundException e)
        {
            System.out.println("������ �������� �����" + e.toString());
            // ��������� ������, ���� �� ������
        } catch (ParserConfigurationException e)
        {
            System.out.println("������ Parser " + e.toString());
            // ��������� ������ Parser
        } catch (SAXException e)
        {
            System.out.println("������ SAX " + e.toString());
            // ��������� ������ SAX
        } catch (IOException e)
        {
            System.out.println("������ ����� " + e.toString());
            // ��������� ������ �����
        } 
        

    }
}

class MyParser extends DefaultHandler {
    
    ArrayList<People> list = null;
    People people = null;

    /*public ArrayList<People> getList() {
        return list;
    }*/
    
    boolean isAge = false;
    boolean isId = false;
    boolean isDegree = false;
    boolean isName = false;
    boolean isSurname = false;

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        System.out.println("���: "+qName);
        if(qName.equals("element")){
            people = new People();
            if (list == null)
                list = new ArrayList<>();
        }
        else if(qName.equals("namef"))
            System.out.println("namef "+ attributes.getValue("namef"));
        else if (qName.equalsIgnoreCase("age")) 
         isAge= true;
        else if (qName.equalsIgnoreCase("id")) 
         isId = true;
        else if (qName.equalsIgnoreCase("isDegree")) 
         isDegree = true;
        else if (qName.equalsIgnoreCase("name")) 
         isName = true;
        else if (qName.equalsIgnoreCase("surname")) 
         isSurname = true;
        
        
      
  //      System.out.println(attributes.getLength());
       // super.startElement(uri, localName, qName, attributes);

        
    }

    @Override
    public void characters(char[] c, int start, int length) 
                                                 throws SAXException {
        
        
        if (isAge) {
            String age = new String(c, start, length);
            people.setAge(Integer.parseInt(age));
            System.out.println("age: " 
            + age);
            isAge = false;
      }  else if (isId) {
            String id = new String(c, start, length);
            people.setId(Integer.parseInt(id));
            System.out.println("id: " 
            + id);
            isId = false;
      } else if (isDegree) {
            String degree= new String(c, start, length);
            people.setIsDegree(Boolean.parseBoolean(degree));
            System.out.println("isDegree: " 
            + degree);
            isDegree = false;
      } else if (isName) {
            String name = new String(c, start, length);
            people.setName(name);
            System.out.println("name: " 
            + name);
            isName = false;
      } else if (isSurname) {
            String surname = new String(c, start, length);
            people.setSurname(surname);
            System.out.println("surname: " 
            + surname);
            isSurname = false;
      }
        //list.add(new People(title, autor));
    }
  
    @Override
    public void endElement(String uri, String localName, String qName) 
                                                    throws SAXException {
        
        if(qName.equals("element"))
            list.add(people);
        System.out.println("��� ��������: "+qName);
        super.endElement(uri,localName, qName);
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("������ ������� ���������!");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("������ ��������� �������!");
        for(People e: list) 
         System.out.println(e.toString());
    }
    
    
}

    

