package com.intelliarts.command;

import com.intelliarts.model.PaymentEntry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommandManager {
    private Map<String, Command> commandMap;
    private List<PaymentEntry> payments;
    public CommandManager(List<PaymentEntry> payments) {
        this.commandMap = new HashMap<String, Command>();
        this.payments = payments;
        commandMap.put("add", new AddCommand(payments));
        commandMap.put("delete", new DeleteCommand(payments));
        commandMap.put("list", new ListCommand(payments));
        commandMap.put("total", new TotalCommand(payments));
    }

    public Command getCommand(String commandName) {
        return commandMap.get(commandName);
    }
}
