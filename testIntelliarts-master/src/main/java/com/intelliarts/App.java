package com.intelliarts;

import com.intelliarts.command.Command;
import com.intelliarts.command.CommandManager;
import com.intelliarts.exception.IncorrectCurrencyException;
import com.intelliarts.exception.IncorrectFormatException;
import com.intelliarts.model.PaymentEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class App 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<PaymentEntry> payments = new ArrayList<>();
        CommandManager commandManager = new CommandManager(payments);
        String line;

        System.out.println("Enter line:");
        while(!(line = reader.readLine().trim()).equals("exit")) {
            String[] param = line.split("\\s");
            Command command = commandManager.getCommand(param[0]);
            try {
                command.execute(param);
            } catch (IncorrectFormatException e) {
                System.out.println("Incorrect format");
                e.printStackTrace();
            } catch (IncorrectCurrencyException e) {
                System.out.println("Incorrect currency");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Wrong format");
                e.printStackTrace();
            }
            System.out.println("Enter line:");
        }
    }
}
