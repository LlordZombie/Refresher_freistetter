package bin2csv;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BinToCSV {

    public static void convertBin2CSV(String oldFilename, String newFileName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(oldFilename)); BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFileName), StandardCharsets.UTF_8))) {

            byte[] buffer = new byte[80];
            while (dis.read(buffer) != -1) {
                String personalNumber = new String(buffer, 0, 10, StandardCharsets.UTF_8).trim();
                String firstName = new String(buffer, 10, 20, StandardCharsets.UTF_8).trim();
                String lastName = new String(buffer, 30, 20, StandardCharsets.UTF_8).trim();
                String email = new String(buffer, 50, 30, StandardCharsets.UTF_8).trim();

                writer.write(personalNumber + ";" + firstName + ";" + lastName + ";" + email);
                writer.newLine();
            }
        }
    }
}
