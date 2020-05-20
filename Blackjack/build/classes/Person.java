/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CristinaFidelino
 */
public abstract class Person {
    
    protected String name;
    protected Hand hand;

    public Person() {
    }

    public void drawCard(Deck deck) {
        hand.add(deck.removeCard());
        if (hand.busted()) {
            System.out.println(name + " busts with " + hand + "!");
        }
    }

    public abstract void haveTurn(Deck deck);

    @Override
    public String toString() {
        return name + " has " + hand;
    }
    
}
