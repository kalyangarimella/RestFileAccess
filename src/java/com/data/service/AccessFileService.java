/*
 File: AccessFileService.java
 July 03 2014     Kalyan Kasyap   To display contents of YAML file based on REST Web Service invocation
 */
package com.data.service;

import com.data.model.Inventory;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.ho.yaml.YamlDecoder;

/**
 * REST Web Service
 */
@Path("fileaccess")
public class AccessFileService {

    private final String filePath = "d:\\output-text.yaml";
    
    /**
     * Creates a new instance of FileaccessResource
     */
    public AccessFileService() {
    }

    /**
     * Retrieves representation of an instance of
     * com.data.service.AccessFileService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/display")
    @Produces("text/html")
    public String getFileContent() {
        
        try {
            System.out.println("file: "+new File(".").getAbsoluteFile());
            // file creation by passing file name
            File file = new File(filePath);

            if (file.exists()) {    /* check if file exists */

                // reading File content using InputStream object (usually file is stored in a server)
                InputStream inputStream = new FileInputStream(file);

                // creating YamlDecoder instance by passing InputStream instance
                YamlDecoder yamlDecoder = new YamlDecoder(inputStream);

                // reading object of type Inventory and converting it to Inventory object
                Inventory inv = (Inventory) yamlDecoder.readObjectOfType(Inventory.class);

                // return the result by invoking toString() on the Inventory instance
                return inv.toString();                
                
            } else {
                System.out.println("File doesn't exist in the path " + filePath + " specified");
            }

        } catch (FileNotFoundException | EOFException exception) {
            System.out.println(exception.getMessage());
        } 

        return null;
        
    } // end of method 
    
} // end of class
