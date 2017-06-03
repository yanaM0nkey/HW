package dz6;

//bankomat in dz5

public class Dz6 {

 
    public static void main(String[] args) {
        int[] array1 = new int[10];
        for(int i = 0; i < array1.length; i++) 
            array1[i] = 1;
        int[] array2 = new int[20];
        for(int i = 0; i < array2.length; i++) 
            array2[i] = 0;
        System.arraycopy(array1, 0, array2, 6, array1.length);
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " "); 
        }
        
        
    }
    
}
