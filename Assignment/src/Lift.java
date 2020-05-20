import java.util.*;
/**
 * Write a description of class Lift here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lift
{
    // instance variables - replace the example below with your own
    private int number;
    private int bottom;
    private int top;
    private int level;
    private int direction;
    private LinkedList<Person> passengers = new LinkedList<Person> ();
    private LinkedList<Person> queue = new LinkedList<Person> ();

    /**
     * Constructor for objects of class Lift
     */
    public Lift(int number, int bottom, int top, int level)
    {
        this.number = number;
        this.bottom = bottom;
        this.top = top;
        this.level = level;
        this.direction = 0;
        
    }
    
    public void call(Person person) {
    }
    
    public void board(Person person){
        
    }
    public void alight(Person person){
        
    }
    public void operate(){
        
    }
    public int direction(int fromLevel, int toLevel) {
        return level;
    }
    public int suitability(int distance, int start, int destination) {
        return level;
    }
    public boolean isSuitable() {
        return true;
        //??
    }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < bottom; i++)
            s += " ";
        s += "|";
        for (int i = bottom; i <= top; i++)
            if (i == level)
                s += "O";
            else
                s += "-";
        s += "|";
        return s;
    }
}
