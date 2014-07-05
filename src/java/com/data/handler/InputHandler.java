/*
 File: InputHandler.java
 July 05 2014     Kalyan Kasyap   Contains behavior to create yaml file and to serialize objects to yaml file
 */

package com.data.handler;
import com.data.model.Inventory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ho.yaml.YamlEncoder;

public class InputHandler {

    /* InputHandler properties */
    File file;
    Scanner scan;
    List<String> items;
    Inventory inventory;
    YamlEncoder yamlEncoder;
    OutputStream outputStream;
    private final String filePath = "d:\\output-text.yaml";

    /**
     * Creates a new instance of FileaccessResource
     */
    public InputHandler() {     /* Implementation goes here */
        scan = new Scanner(System.in);      /* creates an object of Scanner */
        file = new File(filePath);          /* creates an object of File by taking filePath */
        items = new ArrayList<>();          /* creates an object of ArrayList */
    }
    
    /* to create yaml file and to serialize objects to yaml file */
    public void readUserInput() {

        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file);
            yamlEncoder = new YamlEncoder(outputStream);
            inventory = new Inventory();

            System.out.println("Enter Inventory Name:");
            String name = scan.next();
            inventory.setName(name);

            System.out.println("Enter Inventory Date (MM/DD/YYYY):");
            String date = scan.next();
            inventory.setDate(date);

            System.out.println("Enter Inventory Day:");
            String day = scan.next();
            inventory.setDay(day);

            System.out.println("Enter No of Items to input:");
            int no = scan.nextInt();

            for (int i = 0; i < no; i++) {
                System.out.println("Enter Item" + i + ":");
                items.add(scan.next());
            }

            inventory.setItems(items);
            yamlEncoder.writeObject(inventory);
            yamlEncoder.close();
            outputStream.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(InputHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
