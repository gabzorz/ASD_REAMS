package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A person boards and alights lifts.
 */
public class Person {
    private int id;
    private String name;
    private IntegerProperty level = new SimpleIntegerProperty();
    private IntegerProperty destination = new SimpleIntegerProperty();
    private BooleanProperty aboard = new SimpleBooleanProperty();
    private StringProperty strAboard = new SimpleStringProperty();
    private StringProperty strLvl = new SimpleStringProperty();
    private StringProperty dstLvl = new SimpleStringProperty();

    public Person(int id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level.set(level);
        this.destination.set(level);
        this.strLvl.set("Level " + level);
        this.dstLvl.set("Level " + destination.get());
        setStrAboard(aboard.get());
    }

    // PROPERTIES

    public int getId() {
        return id;
    }
    
    public String getStrLvl() { return strLvl.get(); }
    public final void setStrLvl(String strLvl) { this.strLvl.set("Level " + strLvl); }
    public ReadOnlyStringProperty strLvlProperty() { return strLvl; }
    
    public String getDstLvl() { return dstLvl.get(); }
    public final void setDstLvl(String dstLvl) { this.dstLvl.set("Level " + dstLvl); }
    public ReadOnlyStringProperty dstLvlProperty() { return dstLvl; }
    
    public String getStrAboard() { return strAboard.get(); }
    public final void setStrAboard(Boolean strAboard) { 
        if (strAboard) {
            this.strAboard.set("Yes"); 
        }
        else
            this.strAboard.set("No"); 
         }
    
    public ReadOnlyStringProperty strAboardProperty() { return strAboard; }

    public String getName() {
        return name;
    }

    public int getLevel() { return level.get(); }
    private final void setLevel(int level) { this.level.set(level) ; }
    public ReadOnlyIntegerProperty levelProperty() { return level; }
    
    public int getDestination() { return destination.get(); }
    private final void setDestination(int destination) { this.destination.set(destination); }
    public ReadOnlyIntegerProperty destinationProperty() { return destination; }
    
    public boolean isAboard() { return aboard.get(); }
    private final void setIsAboard(boolean aboard) { 
        this.aboard.set(aboard); 
    }
    public ReadOnlyBooleanProperty aboardProperty() { return aboard; }

    // FUNCTIONS and PROCEDURES

    public void call(int destination) {
        this.destination.set(destination);
    }

    public void move(int direction) {
        level.set(level.get() + direction);
    }

    public boolean hasId(int id) {
        return this.id == id;
    }

    public boolean canBoard(int liftLevel, int liftDirection) {
        return isAt(liftLevel) && isHeadingIn(liftDirection);
    }

    public boolean isAt(int level) {
        return this.level.get() == level;
    }

    public boolean isHeadingIn(int direction) {
        return direction == direction();
    }

    public int direction() {
        return Direction.fromTo(level.get(), destination.get());
    }

    public boolean isIdle() {
        return !aboard.get() && level.get() == destination.get();
    }

    public boolean isWaiting() {
        return !aboard.get() && level.get() != destination.get();
    }

    public boolean hasArrived() {
        return level.get() == destination.get();
    }

    /**
     * Determine the direction that this person wants the lift to go in.
     */
    public int liftDirection(int liftLevel) {
        return Direction.fromTo(liftLevel, level.get() == liftLevel ? destination.get() : level.get());
    }

    public void board() {
        aboard.set(true);
    }

    public void alight() {
        aboard.set(false);
    }

    @Override
    public String toString() {
        return name;
    }
}
