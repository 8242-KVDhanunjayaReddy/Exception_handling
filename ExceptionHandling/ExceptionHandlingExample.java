package ExceptionHanding;

import java.io.IOException;

public class ExceptionHandlingExample {
    public static void processData(String data) throws IOException {
        if (data == null) {
            throw new NullPointerException("Data cannot be null");
        }
        if (data.isEmpty()) {
            throw new IOException("Data cannot be empty");
        }

        System.out.println("Processing data: " + data);
    }

    public static void main(String[] args) {
        try {

            processData("Sample data");


            processData(null);

            processData("");
        } catch (NullPointerException e) {
            System.err.println("Caught an unchecked exception: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught a checked exception: " + e.getMessage());
        } finally {
            System.out.println("Processing complete.");
        }
    }
}

