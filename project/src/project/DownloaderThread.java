package project;

//этот поток скачивает JSON затем ждет пока его распарсит другой поток

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//затем скачивает XML и снова ждет пока его распарсит другой поток

public class DownloaderThread extends Thread{
    
    private ParserThread parserThread;
    private String typeOfFile;

    public void setTypeOfFile(String typeOfFile) {
        this.typeOfFile = typeOfFile;
    }
    
    public void setParserThread(ParserThread parserThread) {
        this.parserThread = parserThread;
    }
    
    //HTTPUrlConnector
    public void download(String typeOfFile){
        final String LINK;
        if(typeOfFile.equals("xml"))
            LINK = "http://kiparo.ru/t/salary.xml";
        else
            LINK = "http://kiparo.ru/t/salary.json";
        
        InputStream inputStream1 = null;
        FileOutputStream outputStream1 = null;
      
        try {
            //открываем соединение
            URL url = new URL(LINK);
            HttpURLConnection httpURLConnection = 
                    (HttpURLConnection)url.openConnection();
            //получаем код ответа от сайта или сервера
            int responseCode = httpURLConnection.getResponseCode();
            //проверяем успешное ли подключение т.е. проверка на ошибки
            if(responseCode == HttpURLConnection.HTTP_OK){
               inputStream1 = httpURLConnection.getInputStream(); 
               File file = new File("salary." + typeOfFile);
               outputStream1 = new FileOutputStream(file);
               byte[] buffer = new byte[1024]; // то что мы скачиваем т.е. полезная информация
               int bytesRead = -1; //количество прочитанных байт за одно чтение read()
               while((bytesRead = inputStream1.read(buffer)) != -1 ){
                   //записываем в файл байтф от 0 до "bytesRead" из массива buffer
                   outputStream1.write(buffer, 0, bytesRead);
               }
            } else{
                System.out.println("!!!responseCode = " + responseCode);
            }  
        } catch (Exception ex) {
            System.out.println("!!!Ошибка" + ex.toString());
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
                System.out.println("!!!Ошибка при закрытия стрима" + e.toString());
            }
        }
        
    }

    @Override
    public void run() {
        //скачиваем нужный файл
        download(typeOfFile);
        synchronized(parserThread){
            //пробуждаем поток парсера
            //System.out.println("пробуждаем другой поток");
            parserThread.notifyAll();
            //System.out.println("завершаем работу потока скачивания"); 
        }  
    }   
}
