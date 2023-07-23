package main;

import kategorie.KompozytKategorii;

public class Ui {

    public static void main(String[] args) {
        KompozytKategorii kompozytKategorii = new KompozytKategorii();
        kompozytKategorii.stworzDrzewo();
        kompozytKategorii.wypisz();
    }
}
