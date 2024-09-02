package tests;

import game.GameCharacter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CharacterTest {
    public List<GameCharacter> characters;

    public CharacterTest(String fileName) {
        characters = new ArrayList<>();
        loadTextFile(fileName);
    }

    public void loadTextFile(String textFile) {
        try (BufferedReader b = Files.newBufferedReader(Path.of(textFile))) {
            b.lines().forEach(line -> {
                String[] parts = line.split(";");
                if (parts.length != 6) {
                    throw new IllegalArgumentException("Invalid line: " + line);
                }
                if (parts[0].equalsIgnoreCase("farmer")) {
                    characters.add(new game.Farmer(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5])));
                } else if (parts[0].equalsIgnoreCase("Warrior")) {
                    characters.add(new game.Warrior(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5])));
                } else {
                    throw new IllegalArgumentException("Invalid character type: " + parts[0]);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void savePoints(String fileName) {
        int energySum = 0;
        int productivitySum = 0;
        int forceSum = 0;
        try (BufferedWriter b = Files.newBufferedWriter(Path.of(fileName))) {
            for (GameCharacter character : characters) {
                if (character instanceof game.Farmer) {
                    productivitySum += ((game.Farmer) character).getProductivity();
                } else if (character instanceof game.Warrior) {
                    forceSum += ((game.Warrior) character).getForce();
                }
                energySum += character.getEnergy();

            }
            b.write(energySum +"-"+ forceSum + "-" + productivitySum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CharacterTest test = new CharacterTest("ressources/characters.csv");
        test.characters.forEach(System.out::println);
        test.savePoints("outTests/points.txt");
    }
}
