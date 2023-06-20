import java.util.Scanner;

public class Arrays{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // data_type[] ref_variable = new data_type[Size];
        // int[] marks = {10 ,20 ,30 ,40 ,50};
        // String[] name = new String[5];
        // System.out.println(name[2]);

        /*
         * Array input
         * primitive data type 
        */

        // int[] marks = new int[5];
        // for (int i = 0; i < marks.length; i++) { //marks.length => size of an array(start from 1)
        //     marks[i] = in.nextInt();      
        // }
        // System.out.println(java.util.Arrays.toString(marks));

        
        // for (int i = 0; i < marks.length; i++) {
        //     System.out.println(marks[i] + " ");
        // }

        /* 
        enhanced for loop

        for (data_type ref_variable: array_variable) {
           // body 
        }
        */ 

        // for (int number : marks){
        //     System.out.println(number); 
        // }

        /*
         * Complex data type that are stored in heap memory
        */
        String[] name = new String[4];
        for (int i = 0; i < name.length; i++) {
            name[i] = in.next();
        }
        System.out.println(java.util.Arrays.toString(name));

        //modify
        name[2] = "Ayush";
        System.out.println(java.util.Arrays.toString(name));
        System.out.println(name.length);

    }
}