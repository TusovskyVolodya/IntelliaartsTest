package com.intelliarts.command;

import com.intelliarts.exception.IncorrectCurrencyException;
import com.intelliarts.exception.IncorrectFormatException;
import com.intelliarts.model.Currency;
import com.intelliarts.model.PaymentEntry;
import com.intelliarts.utils.Utils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class AddCommand extends Command {
    public AddCommand(List<PaymentEntry> history) {
        super(history);
    }

    public void execute(String[] params) throws IncorrectFormatException, IncorrectCurrencyException {
        if(params.length < 5) {
            throw new IncorrectFormatException();
        }
        Date date = Utils.parseDate(params[1]);
        double costs = Double.parseDouble(params[2]);
        Currency currency = null;
        try {
            currency = Currency.valueOf(params[3]);
        } catch (IllegalArgumentException e) {
            throw new IncorrectCurrencyException();
        }
        String name = StringUtils.join(Arrays.copyOfRange(params, 4, params.length), " ");
        PaymentEntry paymentEntry = new PaymentEntry(date, costs, currency, name);
        history.add(paymentEntry);
    }
}
