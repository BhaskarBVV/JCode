import java.util.*;
public class editor {
    public static class Person {
        int age;
        String name;

        Person() {
            System.out.println("defalut constructor of person called");
        }
        Person(int age, String name) {
            this.age = age;
            this.name = name;
            System.out.println("Parameterized  constructor of person called");
        }
        // Here, this kind of poylmorphism is compile time polymorphism
        void walk() {
            System.out.println(name + " " + "is walking" + " called from person class");
        }
        void walk(int steps) {
            System.out.println(name + " " + "is walking" + " " + steps + " called from perosn class");
        }
    }

  
    public static class developer extends Person {
        public developer() {
            System.out.println("defalut constructor of developer called");
        }
        public developer(int age, String name) {
            this.age = age;
            this.name = name;
            System.out.println("Parameterized constructor of developer called");
        }
        // Here, the walk() and walk(steps) will be iherited in developer class
        // and walk() function is also written here
        // Hence, here it represenst the run time polymorphism
        void walk() {
            System.out.println(name + " " + "is walking" + " called from developer class itself");
        }
    }

  
    public static class SDE extends developer {
        SDE() {
            System.out.println("default constructor of SDE called");
        }
        SDE(int age, String name) {
            super(age, name);// this super is used to call constructor of parent class,
          
            // here it will call the parametrized constructor of its parent class(developer)
            // Now since, the parametrized constructor of developer don't have super(age, name). Hence, it will call default constructor of its parent class(person).
            // If the parametrized constructor of developer had super(age, name). Then, it would have called parametrized constructor of its parent class(person).
          
            System.out.println("Parameterized constructor of SDE called");
        }
    }

  
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        developer d1 = new developer(21, "sf");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        // Now d1 can use eat(), walk() of parent class and variables are inherited into it;
        d1.walk();
        // now d1 wil search for walk() first in developer and then in its nearest parent and then its nearest parent...until found.
        d1.walk(210);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        SDE s1 = new SDE();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        SDE s2 = new SDE(19, "abc");
    }
}

OUTPUT:
// ---------------------------------------------------------------------------------------------------------------------------
// defalut constructor of person called
// Parameterized constructor of developer called
// ---------------------------------------------------------------------------------------------------------------------------
// sf is walking called from developer class itself
// sf is walking 210 called from perosn class
// ---------------------------------------------------------------------------------------------------------------------------
// defalut constructor of person called
// defalut constructor of developer called
// default constructor of SDE called
// ---------------------------------------------------------------------------------------------------------------------------
// defalut constructor of person called
// Parameterized constructor of developer called
// Parameterized constructor of SDE called
