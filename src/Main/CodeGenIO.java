package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CodeGenIO {
    public String ReadFile(String fileToRead) {
        String str = "";

        try {
            File file = new File(fileToRead);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                str += scanner.nextLine() + "\n";
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error! Header file not found.");
            System.out.println(e.getMessage());
        }

        return str;
    }

    public void WriteFile(String fileName, String data) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(data);
            writer.close();
            System.out.println("File written to successfully");

        } catch (IOException e) {
            System.out.println("An error occurred while creating a file");
            System.out.println(e.getMessage());
        }
    }
}
