/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: CristinaFidelino
 *
 * Created on 20 March 2018, 10:17 AM
 */

#include <cstdlib>
#include <iostream>
#include <string>
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) 
{
    //cout << testString + "\n" + ;
    string testString;
    cout << "What day is it today: ";
    getline (cin, testString);
    if (testString == "Wednesday")
    {
        cout << "It is Wednesday my dudes \n";
        cout << "AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH";
        
    }
    else
    {
        cout << "It is not Wednesday my dudes";
    }
    //cout << "Welcome " + testString + "\n";
    //cout << "What is your favourite colour? \n";
    //getline (cin, testString);
    //cout << "Your favourite colour is " + testString + "\n";
    return 0;
}

