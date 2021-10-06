package com.techelevator.util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TELog {


    public static void log(String message){
        //creating a time-stamp for log messages:
        //no public constructors

        //Sortable
        try(PrintWriter logger = new PrintWriter(new FileWriter("logs/search.log", true))){
            LocalDateTime now = LocalDateTime.now();
            logger.println(now+ ": " + message);

        }catch(FileNotFoundException e){
            //take message out of FileNotFoundException and puts it in TELogException
            TELogException logException = new TELogException(e.getMessage());
            throw logException;
        }catch(IOException e){
            //place exceptions from MOST specific to least specific.
            throw new TELogException((e.getMessage())); //line 17 can be written as line 13
        }
    }
}
