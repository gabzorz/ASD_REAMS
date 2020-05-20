import java.util.*;
public class Building {
    private int entrance = 2;
    private int bottom = 1;
    private int top = 6;
    private LinkedList<Lift> lifts = new LinkedList<Lift>();
    private LinkedList<Person> people = new LinkedList<Person>();
    private String mode;
    
    public static void main (String [] args) {
        new Building().use();
    }
    
    public Building() {
        mode = readMode();
        lifts.add(new Lift (1, 1, 6, entrance));
        lifts.add(new Lift (2, 2, 6, entrance));
        lifts.add(new Lift (3, 2, 5, entrance));
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
        System.out.print("Choice (a/r/p/c/l/o/x): ");
        return In.nextChar();
    }
    private void addPerson() {
        int id = readPersonId();
        Person existingId = person(id);
            
        if (existingId == null) {
            Person addPeople = new Person (id, readName(), entrance);
            people.add(addPeople);
        } 
        
        else if (existingId != null){
            System.out.println("ID already exists");
        }   
        
    }
    
    private void removePerson() {
        int id = readPersonId();
        Person existingId = person(id);
        for (Person removeId : people)
            if (removeId.idExists(id)) {
                people.remove(removeId);
                break;
            }
            if (existingId == null)
            System.out.println("No such person");
    }
    
    private void showPeople() {
            for (Person person : people)
            System.out.println(person);
    }
    
    private void call() {
        int id = readPersonId();
        //int destination = readDestination();
        
        Person callId = person(id);
        
        if (callId == null)
            System.out.println("No such ID");
        
        
        else {
            callId.call(readDestination());
            
            Lift bestLift = lifts.getFirst();
            bestLift.call(callId);
        }
       
        
    }
    
    private void showLifts() {
        for (Lift lift : lifts){
                System.out.println(lift);
            }
         
   
    }
    
    private void operate() {
    }

    private String readName() {
        System.out.print("Name: ");
        return In.nextLine();
    }
    
    private int readDestination() {
        System.out.print("Destination level: ");
        return In.nextInt();
    }
    
    private int readPersonId() {
        System.out.print("Person ID: ");
        return In.nextInt();
    }
    
    private Person person (int i) {
        for (Person person : people)
            if (person.idExists(i))
                return person;
        return null;
    }

    
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