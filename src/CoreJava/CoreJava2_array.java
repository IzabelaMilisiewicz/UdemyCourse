package CoreJava;

import java.util.ArrayList; //stad jest nasza klasa array list

public class CoreJava2_array {
    public static void main(String[] args){

        int[] arr2 = {1,2,3,4,5,6,7,8,9,11,22,55,65,7,41,25,86};

        //liczby podzielne przez 2
        for (int i=0; i<arr2.length; i++) {
            if (arr2[i] % 2 == 0) {
                System.out.println(arr2[i]);
                break; //kończy loop
            }
            else{
                System.out.println(arr2[i] + " is not multiple of two");
            }
        }

        ArrayList<String> a = new ArrayList<String>();
        // class_name object_name(any) = new class_name
        //ArrayList is a class builded in Java
        //if you want to access any methods presented in the class.
        //You have to create object of that class. - wywyołuje się je przez object.method
        // a to object
        //new operator will locate memory
        //thanks to this class you can dynamically change number of elements in the array
        a.add("Rysio");
        a.add("Maria");
        a.add("selenium");
        a.add("Study");
        a.add("Academy");
        a.add("test");
        a.add("Naomi");
        a.remove(3);
        System.out.println(a.get(4));


    }
}
