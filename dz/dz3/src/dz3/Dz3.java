package dz3;

import java.util.Arrays;
import java.util.Scanner;


public class Dz3 {
    
    public static void main(String[] args) {
       int [] array = printIn(10);
       printOut(array);
       System.out.println("Выберите сортировку, 1 - сортировка выбором, "
               + "2 - сортировка пузырьком, 3 - сортировка стандартным методом в java");
       Scanner s = new Scanner(System.in);
       int s2 = s.nextInt();
       switch (s2){
           case 1:
             selectionSort(array);
             break;
           case 2:
             bubbleSort(array);
             break;
           case 3:
               sort(array);
               break; 
           default:
               System.out.println("Сортировка не была выбрана!");
       }
       printOut(array);
       
    }
    
    public static int[] printIn(int n){
        int[] array = new int[n];
        Scanner s = new Scanner(System.in);
        System.out.println("Введите массив целых чисел: ");
        for(int i = 0; i < array.length; i++){
            array[i] = s.nextInt();
        }
        return array;
    }
    
    public static void printOut(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   "); 
        }
        System.out.println();
    }
    
    //сортировка выбором
    public static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_i = i; 
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }
    
    //сортировка пузырьком
    public static void bubbleSort(int[] arr){  
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( arr[j] > arr[j+1] ){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
    
    //сортировка стандартным методом в java
    public static void sort(int [] arr){
        Arrays.sort(arr);
    }
}
