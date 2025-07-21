import java.io.*;

public class FileHandler {
    public static void main(String[] args) {
        String filePath = "sample.txt";

        // 1. Write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Welcome to CodTech Internship!");
            writer.newLine();
            writer.write("This is Task 1 - File Handling.");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Read from the file
        System.out.println("\nReading file:");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Append/Modify the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.newLine();
            writer.write("This line was added later.");
            System.out.println("\nFile updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
