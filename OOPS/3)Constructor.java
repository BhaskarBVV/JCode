// At the time of calling constructor, memory for the object is allocated in the memory.

// There are rules defined for the constructor.
// 1)Constructor name must be the same as its class name
// 2)A Constructor must have no explicit return type
// 3)A Java constructor cannot be abstract, static, final, and synchronized

// Every time an object is created using the new() keyword, at least one constructor is called.
// It calls a default constructor if there is no constructor available in the class. In such case, Java compiler provides a default constructor by default.
// If you have written any one constructor on your own than compiler will not provide you any type of constructor, not even default constructor and you have to write it on your own 
// and is important to be written in case you have written any one constuctor..
  
// In this case we have written only parametrised  const. but not default cont.
// Hence, it will give error: "The constructor editor.Person() is undefinedJava(134217858)"
import java.util.*;
public class editor {
    public static class Person {
        int age;
        String name;
      // Parameterised constructor
        Person(int a) {
            System.out.println("Helo");
        }
    }
    public static void main(String[] args) {
        Person p1 = new Person(); // error bcz default constructor not found at time of objet creation.
    }
}
 
// You simply provide an empty defalut constructor if you have written any Parameterised constructor.
import java.util.*;
public class editor {
    public static class Person {
        int age;
        String name;
        Person() {
        }
        Person(int a) {
            System.out.println("Helo");
        }
    }
    public static void main(String[] args) {
        Person p1 = new Person(); // Now no error as default constructor found.
    }
}





---------------------------------------------------------------------------------------STATIC------------------------------------------------------------------------------------
import java.util.*;
public class editor {
    public static class Person {
        int age;
        String name;
        static int count = 0; // using static declares that the "count" is the property of class not of object.
      // Now "count"cannot be accessed by any object but only through the class...
        Person() {
            count++;
        }
    }
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
      // Now "count"cannot be accessed by any object but only through the class...
        System.out.println("Total number of objects created : " + Person.count);
    }
}
// Output:
// Total number of objects created : 2

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;
public class editor {
    public static class Person {
        int age;
        String name;
        static int count = 0;
        Person() {
            count++;
        }
        Person(int newAge, String newName) {
            name = newName;
            age = newAge;
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

Output: 
// Abhi 21
// Bhaskar 21
// Total number of objects created : 1 // Now number of objects are 1 bcz the creation of p2 called the parametrised constructor and "count" will be incremented by only 
// default constructor which is only called by p1.
