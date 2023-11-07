package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        try {
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            System.out.println("Benvenuto alla biglietteria! Inserisci D per verificare la presenza di biglietti, A per acquistare un biglietto e Q per uscire");

            Scanner input = new Scanner(System.in);

            String messfromuser;
            String messfromserver = "L";
            boolean exit=true;

            while(exit==true){
                messfromuser = input.nextLine();
                out.writeBytes(messfromuser + "\n");

                messfromserver = in.readLine();

                if(messfromserver.equals("5.")){
                    System.out.println("Biglietti disponibili: 5");
                }
                if(messfromserver.equals("4.")){
                    System.out.println("Biglietti disponibili: 4");
                }
                if(messfromserver.equals("3.")){
                    System.out.println("Biglietti disponibili: 3");
                }
                if(messfromserver.equals("2.")){
                    System.out.println("Biglietti disponibili: 2");
                }
                if(messfromserver.equals("1.")){
                    System.out.println("Biglietti disponibili: 1");
                }
                if (messfromserver.equals("@")) {
                    System.out.println("Biglietto acquistato con successo");
                }
                if(messfromserver.equals(".")){
                    exit=false;
                }
                if(messfromserver.equals("..")){
                    exit=false;
                }

            }

            if(messfromserver.equals(".")){
                System.out.println("I biglietti sono esauriti");
            }
            
            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
