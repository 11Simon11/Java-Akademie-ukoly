package com.engeto.ukol01b;

import java.math.BigDecimal;

public class Main {

    /** Vypíše pozdrav na obrazovku */
    public static void ukol1VypisHello() {
        System.out.println("Hello world!");
    }
    /** Vytvoří proměnnou pro text, uloží hodnotu a vypíše na obrazovku */
    public static void ukol2TextovaPromenna() {
        String uzivatel = "Karel";
        System.out.println(uzivatel);
    }

    /** Vytvoří proměnnou pro celé číslo, uloží hodnotu a vypíše na obrazovku */
    public static void ukol3CiselnaPromenna() {
        int pocetLekci = 10;
        System.out.println(pocetLekci);
    }

    /** Vytvoří proměnnou pro desetinné číslo, uloží hodnotu a vypíše na obrazovku */
    public static void ukol4PromennaDesetinneCislo() {
        double cena = 10.0;
        System.out.println(cena);
    }

    /** Vytvoří proměnnou pro desetinné číslo a nastaví do ní nulu.
     * Poté přičte desetkrát po sobě hodnotu 1/10 a výsledek vypíše na obrazovku.
     * Požadujeme přesný výsledek bez zaokrouhlovacích chyb!
     */
    public static void ukol5PresnePricitani() {
        BigDecimal cena = BigDecimal.ZERO;
        for (int i = 0; i < 10; i++) {
            cena.add(BigDecimal.valueOf(0.1));
        }
        System.out.println(cena);
        // Má vypsat "1.0". Ale vypíše "0.9999" !!!
    }

    /** Vytvoří proměnnou pro desetinné číslo BigDecimal, uloží hodnotu a vypíše na obrazovku */
    public static void ukol6NastaveniHodnotyBigDecimal() {
        BigDecimal cena = BigDecimal.ZERO;
        cena = cena.add(BigDecimal.valueOf(0.1));
        System.out.println(cena);
    }

    /** Vytvoří proměnnou pro uložení výkonu motoru. Poté vypíše na obrazovku větu, do které hodnotu vloží */
    public static void ukol7PromennaCisloASpojeniTextu() {
        int vykonMotoru = 120;
        System.out.println("Výkon motoru je: "+vykonMotoru+" kW.");
    }

    /** Vytvoří proměnnou pro uložení velikosti košile. Poté vypíše na obrazovku větu, do které hodnotu vloží */
    public static void ukol8SpojeniTextu() {
        int velikostKosile = 37;
        System.out.println("Velikost košile je: " + velikostKosile + ".");
    }

    /** Vypíše na obrazovku text */
    public static void ukol9ZapisMetody() {
        System.out.println("Metoda *skoro* bez chybičky!");
    }

    public static void main(String[] args) {
        System.out.println("Oprav chyby a spusť všechny metody!");
        System.out.println(
                "PS: Všechny komentáře naráz odstraníš,"+System.lineSeparator()
                        +"když označíš celý blok komentáře a pak zmáčkneš klávesovou zkratku"+System.lineSeparator()
                        +"<Ctrl>+</> - použij lomítko na numerické klávesnici.");
        ukol1VypisHello();
        ukol2TextovaPromenna();
        ukol3CiselnaPromenna();
        ukol4PromennaDesetinneCislo();
        ukol5PresnePricitani();
        ukol6NastaveniHodnotyBigDecimal();
        ukol7PromennaCisloASpojeniTextu();
        ukol8SpojeniTextu();
        ukol9ZapisMetody();
    }
}