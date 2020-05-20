/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

/**
 *
 * @author CristinaFidelino
 */
public class Calculator {
     public int add(int a, int b){

      return a+b;

  } 

  public int subtract(int a, int b){

    return a-b;

  }

  public int mul(int a, int b){

      return a*b;

  }

  public double power(int a, int b){

      return Math.pow(a,b);

  }

  public int evaluate(String expression) {

    int sum = 0;

    for (String summand: expression.split("\\+"))

      sum += Integer.valueOf(summand);

    return sum;

  }
}
