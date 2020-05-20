import java.util.*;

public class Lift {
    private int number;
    private int bottom;
    private int top;
    private int level;
    private int direction;
    private LinkedList<Person> passengers = new LinkedList<Person> ();
    private LinkedList<Person> queue = new LinkedList<Person> ();
    
    
    public Lift(int number, int bottom, int top, int level) {
        this.number = number;
        this.bottom = bottom;
        this.top = top;
        this.level = level;
        this.direction = 0;        
    }
    
    
    public void call(Person person) {
        queue.add(person);
    }
    
    public void board(Person person) {
            queue.remove(person);
            passengers.add(person);
            person.board();
    }
    
    public void alight(Person person) {
        passengers.remove(person);
    }
    
    public void operate() {
        
    }
    
    public Person removeQueue() {
        return queue.removeFirst();
    }
    
    /**public void addQueue(Person person){
        queue.add(person);
    }**/
    
    public int direction(int fromLevel, int toLevel) {
        return fromLevel;
    }
    
    int suitability(int distance, int start, int destination) {
        int x = 0;
        return x;
    }
    
    @Override
    public String toString() {
        String s = "";
            s+= "Lift " + number + " ";
        for (int i = 0; i < bottom; i++)
            s += " ";
        s += "|";
        for (int i = bottom; i <= top; i++)
            if (i == level)
                s += "0";
            else
                s += "-";
        s += "|";
        if (direction == 1)
            s += " UP";
        else if (direction == -1)
            s += " DOWN";
        return s;
    }
}
