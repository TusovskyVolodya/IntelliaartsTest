package com.intelliarts.command;

import com.intelliarts.exception.IncorrectCurrencyException;
import com.intelliarts.exception.IncorrectFormatException;
import com.intelliarts.model.PaymentEntry;

import java.util.List;


public abstract class Command {
    protected List<PaymentEntry> history;

    public Command(List<PaymentEntry> history) {
        this.history = history;
    }

    public abstract void execute(String[] params) throws IncorrectFormatException, IncorrectCurrencyException;
}
