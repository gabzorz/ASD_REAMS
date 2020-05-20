
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private int level;
    private int destination;
    private boolean aboard;

    /**
     * Constructor for objects of class Person
     */
    public Person(int id, String name, int level)
    {
        this.id = id;
        this.name = name;
        this.level = level;
        this.destination = level;
    }
    
    public boolean nameExists(String type) {
        return type.equals(this.name);
    }
    
    public boolean idExists(String type) {
        return type.equals(id);
    }
    public void call(int destination) {
        
    }
    
    public void move(int direction) {
        
    }
    
    public void board() {
        
    }
    
    public void alight() {
        
    }
    
    @Override
    public String toString() {
        String s = name + (id) + " on level" + level;
        return s;
    }

    
}
