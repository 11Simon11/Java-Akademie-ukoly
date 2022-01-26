package com.engeto.pokojoverostliny;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlantList {
    private static final String FILE_ITEM_DELIMITER = "\t";

    ArrayList<Plant> plants = new ArrayList<>();

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public Plant getPlant(int index) {
        return plants.get(index);
    }

    public void removePlant(int index) {
        plants.remove(index);
    }

    public int size() {
        return plants.size();
    }

    public void importFromFile(String pathAndFile) throws PlantException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(pathAndFile)))) {
            int line = 0;
            while (scanner.hasNextLine()) {
                String record = scanner.nextLine();
                line++;
                try {
                    this.addPlant(Plant.parse(record, FILE_ITEM_DELIMITER));
                } catch (PlantException e) {
                    throw new PlantException("Neplatný vstupní soubor "+pathAndFile+" na řádku "+line+":\n\t"+e.getLocalizedMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Vstupní soubor "+pathAndFile+" nebyl nalezen: "+e.getLocalizedMessage());
        }
    }

    public void exportToFile(String pathAndFile) throws PlantException {
        int line = 0;
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pathAndFile)))){
            for (Plant plant : plants) {
                String plantAsFileLine = plant.outputString(FILE_ITEM_DELIMITER);
                writer.println(plantAsFileLine);
                line++;
            }
        } catch (IOException e) {
            throw new PlantException("Error writing to : "+pathAndFile+" line "+line+": "+e.getLocalizedMessage());
        }
    }

}
