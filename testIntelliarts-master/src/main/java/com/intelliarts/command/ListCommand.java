package com.intelliarts.command;

import com.intelliarts.exception.IncorrectFormatException;
import com.intelliarts.model.PaymentEntry;

import java.util.Comparator;
import java.util.List;


public class ListCommand extends Command {
    public ListCommand(List<PaymentEntry> history) {
        super(history);
    }

    public void execute(String[] params) throws IncorrectFormatException {
        if(params.length != 1) {
            throw new IncorrectFormatException();
        }
        history.stream().sorted(new Comparator<PaymentEntry>() {
            @Override
            public int compare(PaymentEntry o1, PaymentEntry o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        }).forEach(System.out::println);
    }
}
