/*
 File: Encoder.java
 July 05 2014     Kalyan Kasyap   Test Application which invokes InputHandler to serialize objects to yaml file
 */
package com.data.handler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Encoder {

    /* main method of the application which invokes InputHandler behavior */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputHandler inputHandler = new InputHandler();
        inputHandler.readUserInput();
    }
}
