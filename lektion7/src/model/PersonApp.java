package model;

public class PersonApp {

    public static void main(String[] args) {
        Person p = new Person("Bent", "Ole", "Christensen", 27, 12, 2000);
        p.printPerson();
        System.out.println("Initialer: " + p.getInit());
        System.out.println("Username: " + p.getUserName());

        System.out.println("Age: " + p.age(28, 12, 2050)); // p's age today
        System.out.println(p.leapYear(10));
        Person p1 = new Person("Bent", "ole",27,12,2000);
        p1.getUserName();
        // int year = 2017;
        // System.out.println("Er " + year + " skudår: " + p.leapYear(year));

    }
}
