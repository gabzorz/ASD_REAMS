public class Person {
    private int id;
    private String name;
    private int level;
    private int destination;
    private boolean aboard;

    public Person(int id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.destination = level;
        this.aboard = false;
    }
    
    public boolean idExists(int Id) {
        return Id == id;
    }
    
    //public boolean aboard() {
     //   return true;
    //}
    
    public void call(int destination) {
        this.destination = destination;
    }
   
    public void move(int direction) {
        
    }
    
    public void board() {
        this.aboard = true;
    }
    
    public void alight() {
        this.aboard = false;
    }
    
    @Override
    public String toString() {
        String s = "";
            if (level == destination)
                s += name + "(" + id + ")" + " on level " + level;
            else if (level != destination && aboard == false)
                s += name + "(" + id + ")" + " on level " + level + " waiting to go to level " + destination;
            else if (aboard == true)
                s += name + "(" + id + ")" + " on level " + level + " going to level " + destination;
        return s;
    }
}