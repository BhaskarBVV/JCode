import java.util.*;

public class editor {

    public static class Person {
        // class properties
        int age;
        String name;

        // class methods same as behaviour (simply functions)
        void walk() {
            System.out.println(name + " " + "is walking");
        }

        void eat() {
            System.out.println(name + " " + "is eating");
        }

    }

    public static void main(String[] args) {
      
        Person p1 = new Person();
        p1.name = "bhaskar";
        p1.age = 21;
        System.out.println(p1.name + " " + p1.age);
        p1.eat(); // eat method is called
        p1.walk(); // walk method is called
      
        Person p2 = new Person();
        p2.name = "Abhishek";
        p2.age = 21;
        System.out.println(p2.name + " " + p2.age);
        p2.eat();
        p2.walk();
    }
  
  
  OUTPUT:
// bhaskar 21
// bhaskar is eating
// bhaskar is walking
// Abhishek 21
// Abhishek is eating
// Abhishek is walking

}
