package org.example;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Date date = new Date();
        String gotDate = date.toString();

        String trimDate = gotDate.replaceAll("\\s", "");
        String trimColon = trimDate.replaceAll("\\:","");
        System.out.println(trimColon+"@gmail.com");

    }
}
