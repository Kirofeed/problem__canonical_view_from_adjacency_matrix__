import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path inputFile = Paths.get("input.txt");
        Path outputFile = Paths.get("output.txt");
        try (BufferedReader reader = Files.newBufferedReader(inputFile);
             PrintStream printStream = new PrintStream(Files.newOutputStream(outputFile))) {
            int n = Integer.parseInt(reader.readLine());
            int[] canonicalView = new int[n];
            for (int i = 0; i < n; i++) {
                String[] lines = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    if (Integer.parseInt(lines[j]) == 1) {
                        canonicalView[j] = i + 1;
                    }
                }
            }
            for (int i : canonicalView) {
                printStream.print(i + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}