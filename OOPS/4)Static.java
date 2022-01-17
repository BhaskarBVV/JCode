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
