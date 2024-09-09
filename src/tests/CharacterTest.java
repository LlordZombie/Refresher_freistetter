package tests;

import game.Farmer;
import game.GameCharacter;
import game.Warrior;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CharacterTest {
    public static List<GameCharacter> characters;

    public static void main(String[] args) {
        CharacterTest.loadTextFile("ressources/characters.csv");
        characters.forEach(System.out::println);
        CharacterTest.savePoints("outTests/points.txt");
        System.out.println();
        Warrior firstW = characters.stream().filter(c -> c instanceof Warrior).map(c -> (Warrior) c).findFirst().orElse(null);
        Farmer firstF = characters.stream().filter(c -> c instanceof Farmer).map(c -> (Farmer) c).findFirst().orElse(null);
        assert firstF != null;
        assert firstW != null;
        System.out.println(firstW);
        System.out.println(firstF);
        firstW.setEnergy(123);
        firstF.setEnergy(123);
        firstF.setProductivity(123);
        firstW.setForce(123);
        System.out.println(firstW);
        System.out.println(firstF);
        System.out.println(firstW.getSlogan());
        System.out.println(firstF.getSlogan());

    }

    public static void loadTextFile(String textFile) {
        characters = new ArrayList<>();
        try (BufferedReader b = Files.newBufferedReader(Path.of(textFile))) {
            b.lines().forEach(line -> {
                String[] parts = line.split(";");
                if (parts.length != 6) {
                    throw new IllegalArgumentException("Invalid line: " + line);
                }
                try {
                    if (parts[0].equalsIgnoreCase("farmer")) {
                        characters.add(new game.Farmer(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5])));
                    } else if (parts[0].equalsIgnoreCase("Warrior")) {
                        characters.add(new game.Warrior(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5])));
                    } else {
                        throw new IllegalArgumentException("Invalid character type: " + parts[0]);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid number: " + parts[3] + " or " + parts[5]);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void savePoints(String fileName) {
        int energySum = 0;
        int productivitySum = 0;
        int forceSum = 0;
        try (BufferedWriter b = Files.newBufferedWriter(Path.of(fileName))) {
            for (GameCharacter character : characters) {
                if (character instanceof Farmer) {
                    productivitySum += ((Farmer) character).getProductivity();
                } else if (character instanceof Warrior) {
                    forceSum += ((Warrior) character).getForce();
                }
                energySum += character.getEnergy();
            }
            b.write(energySum + "-" + forceSum + "-" + productivitySum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
