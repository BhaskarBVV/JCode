// basically, this() can be used to call one constructor from any other constructor,
// "this" can be used to access variables of same class.
import java.util.*;
public class editor {
    public static class Person {
        int age;
        String name;
        static int count = 0;

        Person() {
            count++;
        }

        // basically, this() can be used to call one constructor from any other constructor,
        Person(int age, String name) {
            // here this() is used to call a constructor that have no parameters
            this();
            // name = name;
            // age = Age;
            // variable = arguments passed have same spelling
            // This will be difficult to understand, to avoid this we use this
            this.age = age;
            this.name = name;
            //So "this" can be used to access variables of same class.
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "Abhi";
        p1.age = 21;
        Person p2 = new Person(21, "Bhaskar");
        System.out.println(p1.name + " " + p1.age);
        System.out.println(p2.name + " " + p2.age);
        System.out.println("Total number of objects created : " + Person.count);
    }
}

// Output:
// Abhi 21
// Bhaskar 21
// Total number of objects created : 2
