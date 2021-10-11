package com.techelevator.util;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TELog {

    public static void log(String message) {
        LocalDateTime now = LocalDateTime.now();
        try (PrintWriter logger = new PrintWriter(new FileWriter("logs/search.log", true))) {
            logger.println(now + " : " + message);
        } catch (FileNotFoundException e) {
            TELogException logException = new TELogException("Caught FileNotFoundException. Message: " +  e.getMessage());
            throw logException;
        } catch (IOException e) {
            throw new TELogException(e.getMessage());
        }
    }
}
