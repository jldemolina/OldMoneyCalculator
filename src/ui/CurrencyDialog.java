package ui;

import java.util.Scanner;
import model.Currency;
import model.CurrencySet;

public class CurrencyDialog {

    private Currency currency;

    public void show() {
        while (true) {
            System.out.println("Introduzca la divisa sobre la que quiere realizar la operación:");
            Scanner scanner = new Scanner(System.in);
            Currency[] currencies = CurrencySet.getInstance().search(scanner.nextLine());

            if (currencies.length == 0)
                System.out.println("No se ha podido encontrar la divisa. Vuelva a intentarlo.");
            else if (currencies.length == 1) {
                currency = currencies[0];
                break;
            } else {
                System.out.println("Se encuentran varias coincidencias. Considere afinar la búsqueda:");
                for (Currency currency : currencies)
                    new CurrencyViewer(currency).show();
            }
        }
    }

    public Currency getCurrency() {
        return currency;
    }

}
