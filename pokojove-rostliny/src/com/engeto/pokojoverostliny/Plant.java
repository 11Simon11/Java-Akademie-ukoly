package com.engeto.pokojoverostliny;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Plant {

    static final int DEFAULT_WATERING_FREQUENCY = 7;

    String name;
    String notes;
    LocalDate planted;
    LocalDate lastWatering;
    int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate planted, LocalDate lastWatering, int frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.lastWatering = lastWatering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name, LocalDate planted, int frequencyOfWatering) {
        this(name, "", planted, LocalDate.now(), frequencyOfWatering);
    }

    public Plant(String name) {
        this(name, LocalDate.now(), DEFAULT_WATERING_FREQUENCY);
    }

    public static Plant parse(String text, String delimiter) throws PlantException {
        String[] items = text.split(delimiter);

        int numberOfItems = items.length;
        if (numberOfItems != 5) throw new PlantException("Nesprávný počet údájů na řádku: " + text);

        String name = items[0];
        String notes = items[1];
        try {
            int frequencyOfWateringInDays = Integer.parseInt(items[2]);
            LocalDate lastWatering = LocalDate.parse(items[3]);
            LocalDate planted = LocalDate.parse(items[4]);

            return new Plant(name, notes, lastWatering, planted, frequencyOfWateringInDays);
        }
        catch (DateTimeParseException ex) { throw new PlantException("Špatně zadané datum na řádku: \""+text+"\"\n\t"+ex.getLocalizedMessage()); }
        catch (NumberFormatException ex) { throw new PlantException("Špatně zadané číslo na řádku: \""+text+"\"\n\t"+ex.getLocalizedMessage()); }
    }

    public String outputString(String delimiter) {
        return getName() + delimiter + getNotes() + delimiter + getFrequencyOfWatering() + delimiter
                + getLastWatering() + delimiter + getPlanted();
    }

    public String getWateringInfo() {
        return getName() + ": poslední zalévání: " + getLastWatering() +
                ", další zalévání: " + getLastWatering().plusDays(getFrequencyOfWatering());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getLastWatering() {
        return lastWatering;
    }

    public void setLastWatering(LocalDate lastWatering) throws PlantException {
        if (lastWatering.isBefore(getPlanted())) throw new PlantException("Datum posledního zalévání" + lastWatering +
                "nesmí být starší než datum zasazení" + getPlanted());
        this.lastWatering = lastWatering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if (frequencyOfWatering < 1) throw new PlantException("Frekvence zalévání musí být menší než 1 den! Zadáno: " +frequencyOfWatering);
        this.frequencyOfWatering = frequencyOfWatering;
    }
}
