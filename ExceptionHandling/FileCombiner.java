package ExceptionHanding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCombiner {
    public static void main(String[] args) {
        BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        BufferedWriter writer = null;

        try {
            // Open the first file for reading
            reader1 = new BufferedReader(new FileReader("file1.txt"));
            // Open the second file for reading
            reader2 = new BufferedReader(new FileReader("file2.txt"));
            // Open the third file for writing
            writer = new BufferedWriter(new FileWriter("combined.txt"));

            String line;
            // Read from the first file and write to the combined file
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            // Read from the second file and write to the combined file
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("The data from file1.txt and file2.txt has been successfully combined into combined.txt.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Ensure all resources are properly closed
            try {
                if (reader1 != null) reader1.close();
                if (reader2 != null) reader2.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("Failed to close resources: " + e.getMessage());
            }
        }
    }
}

