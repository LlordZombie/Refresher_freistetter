package tests;

import bin2csv.BinToCSV;

import java.io.IOException;

public class bin2csvTests {
    public static void main(String[] args) {
        try {
            BinToCSV.convertBin2CSV("ressources/people.dat", "outTests/persons.csv"

            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
