package dz17;

//���� ����� ��������� JSON ����� ���� ���� ��� ��������� ������ �����

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//����� ��������� XML � ����� ���� ���� ��� ��������� ������ �����

public class DownloaderThread extends Thread{
    
    private ParserThread parserThread;

    public void setParserThread(ParserThread parserThread) {
        this.parserThread = parserThread;
    }
    

    @Override
    public void run() {
        
        String LINKJSON = "http://kiparo.ru/t/salary.json";
        InputStream inputStream1 = null;
        FileOutputStream outputStream1 = null;
      
        try {
            //��������� ����������
            URL url = new URL(LINKJSON);
            HttpURLConnection httpURLConnection = 
                    (HttpURLConnection)url.openConnection();
            //�������� ��� ������ �� ����� ��� �������
            int responseCode = httpURLConnection.getResponseCode();
            //��������� �������� �� ����������� �.�. �������� �� ������
            if(responseCode == HttpURLConnection.HTTP_OK){
               inputStream1 = httpURLConnection.getInputStream();
               File file = new File("salary.json");
               outputStream1 = new FileOutputStream(file);
               byte[] buffer = new byte[1024]; // �� ��� �� ��������� �.�. �������� ����������
               int bytesRead = -1; //���������� ����������� ���� �� ���� ������ read()
               while((bytesRead = inputStream1.read(buffer)) != -1 ){
                   //���������� � ���� ����� �� 0 �� "bytesRead" �� ������� buffer
                   outputStream1.write(buffer, 0, bytesRead);
                   
               }
            } else{
                System.out.println("responseCode = " + responseCode);
            }
            
            
        } catch (Exception ex) {
            System.out.println("������" + ex.toString());
        }
        finally {
            try{
                if(inputStream1 != null){
                    inputStream1.close();
                }
                if(outputStream1 != null){
                    outputStream1.close();
                }
            }catch(Exception e){
                System.out.println("������ ��� �������� ������" + e.toString());
            }
        }
        
        synchronized(parserThread){
            //���������� ����� �������
            System.out.println("D - ���������� ������ �����");
            parserThread.notifyAll();
            //���� ��������
            System.out.println("D - ���� ��������");
            
        }
        synchronized(this){
            try {
                wait();
            } catch (InterruptedException ex) {
                
            }
        }
        String LINKXML = "http://kiparo.ru/t/salary.xml";
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
      
        try {
            //��������� ����������
            URL url = new URL(LINKXML);
            HttpURLConnection httpURLConnection = 
                    (HttpURLConnection)url.openConnection();
            //�������� ��� ������ �� ����� ��� �������
            int responseCode = httpURLConnection.getResponseCode();
            //��������� �������� �� ����������� �.�. �������� �� ������
            if(responseCode == HttpURLConnection.HTTP_OK){
               inputStream = httpURLConnection.getInputStream();
               File file = new File("salary.xml");
               outputStream = new FileOutputStream(file);
               byte[] buffer = new byte[1024]; // �� ��� �� ��������� �.�. �������� ����������
               int bytesRead = -1; //���������� ����������� ���� �� ���� ������ read()
               while((bytesRead = inputStream.read(buffer)) != -1 ){
                   //���������� � ���� ����� �� 0 �� "bytesRead" �� ������� buffer
                   outputStream.write(buffer, 0, bytesRead);
                   
               }
            } else{
                System.out.println("responseCode = " + responseCode);
            }
            
            
        } catch (Exception ex) {
            System.out.println("������" + ex.toString());
        }
        finally {
            try{
                if(inputStream != null){
                    inputStream.close();
                }
                if(outputStream != null){
                    outputStream.close();
                }
            }catch(Exception e){
                System.out.println("������ ��� �������� ������" + e.toString());
            }
        }
        synchronized(parserThread){
            //���������� ����� �������
            System.out.println("D - ���������� ������ �����");
            parserThread.notifyAll();
            System.out.println("D - ��������� ������");
            
        }
        
        

        
    }
    
    
    
}
