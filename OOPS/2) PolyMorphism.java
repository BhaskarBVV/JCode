import java.util.*;

public class editor {

    public static class Person {
        // class properties
        int age;
        String name;

        void walk() {
            System.out.println(name + " " + "is walking");
        }

        // Polymorphism - poly + morphism ->> multiple forms
        // Polymorphism is of two types: run time and compile time polymorphism
        // This is complile time polyporphism....
        // run time polymorphism will be in inheritance later on...
        void walk(int steps) {
            System.out.println(name + "walked" + steps);
        }

    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "bhaskar";
        p1.age = 21;
        System.out.println(p1.name + " " + p1.age);
        p1.walk(); 
        p1.walk(109);
    }

}
