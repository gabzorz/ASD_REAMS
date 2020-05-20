import java.util.*;
/**
 * Write a description of class Building here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Building
{
    // instance variables - replace the example below with your own
    private int entrance = 2;
    private int bottom = 1;
    private int top = 6;
    private LinkedList<Person> people = new LinkedList<Person>();
    private LinkedList<Lift> lifts = new LinkedList<Lift>();
    private String mode;

    public static void main (String [] args) {
        new Building().use();
    }

    /**
     * Constructor for objects of class Building
     */
    public Building()
    {
        mode = readMode();
        lifts.add(new Lift(1, 1, 6, 2));
        lifts.add(new Lift(2, 2, 6, 2));
        lifts.add(new Lift(3, 2, 5, 2));
        

    }
     
    private String readMode() {
        System.out.print("Mode: ");
        return In.nextLine();
    }

    public void use() {
        char choice;
        while ((choice = readChoice()) != 'x') {
            switch (choice) {
                case 'a' : addPerson(); break;
                case 'r' : removePerson(); break;
                case 'p' : showPeople(); break;
                case 'c' : call(); break;
                case 'l' : showLifts(); break;
                case 'o' : operate(); break;
                default: help(); break;
            }
        }
    }

    private char readChoice() {
        System.out.print("Choice a/r/p/c/l/o): ");
        return In.nextChar();
    }
    
    private void addPerson() {
        int id = readPersonId();
        String name = readName();
        //Person newPerson = people(name);
            //if (newPerson == null)
                   //people.add(new Person());
            //else 
                //System.out.println("ID already exists");
    }
    
    private void removePerson() {
    }
    
    private void showPeople() {
        //for (Person people : people)
            //System.out.println(people);
    }
    
    private void call() {
        int id = readPersonId();
        int destination;
        
        //if (id != null)
            //destination = readDestination();
        //else 
            //System.out.println("No such ID" );
        
    }
    
    private void showLifts() {
        for (Lift lift : lifts)
        System.out.println(lift);
    }
    
    private void operate() {
    }

    private String readName() {
        System.out.print("Name: ");
        return In.nextLine();
    }
    
    private int readDestination() {
        System.out.println("Destination: ");
        return In.nextInt();
    }
    
    private int readPersonId() {
        System.out.println("Person ID: ");
        return In.nextInt();
    }
    
    /**private Person people (String type) {
        for (Person people : people)
            if (people.idExists(type))
                return people;
        return null;
    }
    /**private Person person (int id) {
        return "";
    }**/
    
    private void help() {
        System.out.println("Menu");
        System.out.println("a = add person");
        System.out.println("r = remove persom");
        System.out.println("p = show people");
        System.out.println("c = call lft");
        System.out.println("l = show lifts");
        System.out.println("o = operate");
    }
}

