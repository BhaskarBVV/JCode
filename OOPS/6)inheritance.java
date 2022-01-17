//There can be three types of inheritance in java: single, multilevel and hierarchical.


import java.util.*;
public class editor3 {

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
    }

    public static class developer extends Person {
        developer() {
            System.out.println("defalut constructor of developer called");
        }
        developer(int age, String name) {
            this.age = age;
            this.name = name;
            System.out.println("Parameterized constructor of developer called");
        }
    }

    public static class SDE extends developer {
        SDE() {
            System.out.println("default constructor of SDE called");
        }
        SDE(int age, String name) {
            this.age = age;
            this.name = name;
            System.out.println("Parameterized constructor of SDE called");
        }
    }

    public static void main(String[] args) {
        SDE d1 = new SDE(21, "bhaskar");
    }
}

// The defult constructor of parent will be called first, for any kind of constructor of child class called...
Output: 
// defalut constructor of person called
// defalut constructor of developer called
// Parameterized constructor of SDE called



{
  ...
    ...
    ...
public static void main(String[] args) {
        SDE d1 = new SDE();
    }
}
Output:
// defalut constructor of person called
// defalut constructor of developer called
// default constructor of SDE called
