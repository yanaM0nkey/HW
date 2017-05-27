package dz2;

import java.util.Arrays;
import java.util.Random;

public class Dz2 {

    public static void main(String[] args) {
        program1();
        System.out.println("-------------------------------------------------");
        program2();
        System.out.println("-------------------------------------------------");
        program3();
        System.out.println("-------------------------------------------------");
        program4();
    }
    
    public static void program1(){
        int [] array = printIn(10,100);
        printOut(array);
        int min = array[0];
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
            if(array[i] > max){
                max = array[i];
            }
        }
        System.out.println("min value = " + min);
        System.out.println("max value = " + max);
        for(int i = 0; i < array.length; i++){
            if(array[i] == min)
                array[i] = 0;
            if(array[i] == max)
                array[i] = 99;
        }
        printOut(array);
    }
    
    public static void program2(){
        float [] array = printIn(10);
        printOut(array);
        float a = 0;
        for(int i = 0; i < array.length; i++){
            float elem = array[i];
            int num = 0;
            for (int j = 0; j < array.length; j++){
                if(elem == array[j])
                    num++;    
            }
            if(num != 1 && a != elem){
                System.out.println("[" + elem + "] - повторений " + num);
                a = elem;
            }
        }
    }
    
    public static void program3(){
        int [] array = printIn(10,10);
        printOut(array);
        for (int i = array.length-1; i >= 0; i--) {
            System.out.print(array[i] + "   "); 
        }
        System.out.println();
    }
    
    public static void program4(){
        int [] array = printIn(10,10);
        printOut(array);
        Arrays.sort(array);
        printOut(array);
    }
    
    public static void printOut(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   "); 
        }
        System.out.println();
    }
    
    public static void printOut(float [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   "); 
        }
        System.out.println();
    }
    
    public static int[] printIn(int n, int m){
        int[] array = new int[n];
        Random rand = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(m);
        }
        return array;
    }
    
    public static float[] printIn(int n){
        float[] array = new float[n];
        Random rand = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = 1;//rand.nextFloat()*10;
        }
        return array;
    }
    
    
   
}
  
