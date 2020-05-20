package model;

import java.util.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * A Lift carries people to their destinations.
 */
public class Lift {
    private int number;
    private StringProperty strLift = new SimpleStringProperty();
    private StringProperty strLevel = new SimpleStringProperty();
    private int bottom;
    private int top;
    private IntegerProperty level = new SimpleIntegerProperty();
    private IntegerProperty direction = new SimpleIntegerProperty();
    private ObservableList<Person> passengers = FXCollections.observableArrayList();
    private IntegerProperty passengerSize = new SimpleIntegerProperty();
    private ObservableList<Person> queue = FXCollections.observableArrayList();
    private IntegerProperty waiting = new SimpleIntegerProperty();

    public Lift(int number, int bottom, int top, int level) {
        this.number = number;
        this.bottom = bottom;
        this.top = top;
        this.level.set(level);
        this.direction.set(Direction.STATIONARY);
        this.strLift.set("Lift " + number);
        this.strLevel.set(stringLevel());
        this.passengerSize.set(passengers.size());
        this.waiting.set(queue.size());
        //this.space = space;
    }
    
    private String stringLevel() {
        String s = "";
        for (int i = 0; i < bottom; i++)
            s += " ";
        s += "|";
        for (int i = bottom; i <= top; i++)
            if (i == level.get())
                s += level.get();
            else
                s += " ";
        s += "|";
        return s;
    }
    
            
    // PROPERTIES

    public int getNumber() { return number; }

    public String getStrLift() { return strLift.get(); }
    public final void setStrLift(String strLvl) { this.strLift.set("Lift " + strLvl); }
    public ReadOnlyStringProperty strLiftProperty() { return strLift; }
    
    public String getStrLevel() { return strLevel.get(); }
    public final void setStrLevel(String strLevel) {this.strLevel.set("|" + strLevel + "|"); }
    public ReadOnlyStringProperty strLevelProperty() {return strLevel; }
    
    public int getBottom() { return bottom; }

    public int getTop() { return top; }

    public int getLevel() { return level.get(); }
    private final void setLevel(int level) { this.level.set(level); }
    public ReadOnlyIntegerProperty levelProperty() { return level; }

    public int getDirection() { return direction.get(); }
    private final void setDirection(int direction) { this.direction.set(direction); }
    public ReadOnlyIntegerProperty directionProperty() { return direction; }

    public ObservableList<Person> getPassengers() {
        return passengers;
    }
    
    public int getPassengerSize() { return passengerSize.get(); }
    private final void setPassengerSize(int passengerSize) { this.passengerSize.set(passengerSize); }
    public ReadOnlyIntegerProperty passengerSizeProperty() { return passengerSize; }
    
    public ObservableList<Person> getQueue() {
        return queue;
    }
    
    public int getWaiting() { return waiting.get(); }
    private final void setWaiting(int waiting) { this.waiting.set(waiting); }
    public ReadOnlyIntegerProperty waitingProperty() { return waiting; }

    // FUNCTIONS and PROCEDURES

    public void call(Person person) {
        queue.add(person);
    }

    private void board(Person person) {
        queue.remove(person);
        passengers.add(person);
        person.board();
    }

    private void alight(Person person) {
        passengers.remove(person);
        person.alight();
    }

    /**
     * This procedure carries out the operation of a lift for one step of time.
     * It is intended to be called repeatedly.
     */
    public void operate() {
        // This is slightly different from Assignment 1
        Person nextPerson = nextPerson();
        if (direction.get() == Direction.STATIONARY) {
            if (nextPerson != null)
                direction.set(nextPerson.liftDirection(getLevel()));
        }
        if (alight() || board()) {
            if (passengers.isEmpty())
                direction.set(Direction.STATIONARY);
        }
        else {
            move();
            if (isAtBoundary() || passengers.isEmpty() && anyoneWaitingHere())
                direction.set(Direction.STATIONARY);
        }
    }

    private boolean anyoneWaitingHere() {
        if (queue.isEmpty())
            return false;
        Person person = queue.get(0);
        return person.isAt(level.get());
    }

    private void move() {
        level.set(level.get() + direction.get());
        for (Person person : passengers)
            person.move(direction.get());
    }

    /**
     * Determine the next person to service.
     */
    private Person nextPerson() {
        // Take the next passenger if there is one
        if (passengers.size() > 0)
            return passengers.get(0);
        // Otherwise go to pick up the next waiting if there is one
        else if (queue.size() > 0)
            return queue.get(0);
        // Otherwise there is no next person
        else
            return null;
    }

    private boolean board() {
        int count = 0;
        for (Person person : new LinkedList<Person>(queue))
            if (person.canBoard(getLevel(), direction.get())) {
                board(person);
                count++;
            }
        return count > 0;
    }

    private boolean alight() {
        int count = 0;
        for (Person person : new ArrayList<Person>(passengers))
            if (person.hasArrived()) {
                alight(person);
                count++;
            }
        return count > 0;
    }

    private boolean isAtBoundary() {
        return getLevel() == bottom || getLevel() == top;
    }

    private int distanceTo(int target) {
        return Math.abs(target - getLevel());
    }

    public int suitability(int distance, int start, int destination) {
        if (!canTake(start, destination))
            return 0;
        else if (direction.get() * Direction.fromTo(getLevel(), start) < 0)
            return 1;
        else if (direction.get() == -Direction.fromTo(start, destination))
            return distance + 1 - distanceTo(start);
        else
            return distance + 2 - distanceTo(start);
    }

    private boolean canTake(int start, int destination) {
        return canReach(start) && canReach(destination);
    }

    private boolean canReach(int level) {
        return level >= bottom && level <= top;
    }

    @Override
    public String toString() {
        return "Lift " + number;
    }
}
