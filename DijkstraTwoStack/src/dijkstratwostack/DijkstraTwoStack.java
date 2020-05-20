/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstratwostack;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author CristinaFidelino
 */
public class DijkstraTwoStack {

    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                String exp[] = scanner.nextLine().split(" ");
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        for(int i = 0; i < exp.length; i++) {
                        String s = exp[i];
            if (s.equals("(")) {
            }
            else if (s.equals("+") || s.equals("*")) {
                ops.push(s);
            } else if (s.equals(")")) {
                getComp(ops, vals);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        getComp(ops, vals);
        System.out.println(vals.pop());
    }

    private static void getComp(Stack<String> ops, Stack<Double> vals) {
        String op = ops.pop();
        if (op.equals("+")) {
            vals.push(vals.pop() + vals.pop());
        } else if (op.equals("*")) {
            vals.push(vals.pop() * vals.pop());
        }
    }
}
