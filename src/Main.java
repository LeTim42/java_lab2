import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputPath = sc.nextLine();
        File inputFile = new File(inputPath);
        IOUtils.checkInputFile(inputFile);
        char[] input = IOUtils.readCharArray(inputFile);
        System.out.print("Output file: ");
        String outputPath = sc.nextLine();
        Map<Character, Integer> frequency = getFrequencyMap(input);
        String output = frequencyMapToString(frequency);
        File outputFile = new File(outputPath);
        IOUtils.writeString(outputFile, output);
        System.out.println("Done!");
    }

    public static Map<Character, Integer> getFrequencyMap(char[] charArray) {
        Map<Character, Integer> frequency = new TreeMap<>();
        for (char c : charArray) {
            if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
                frequency.merge(c, 1, Integer::sum);
            }
        }
        return frequency;
    }

    public static String frequencyMapToString(Map<Character, Integer> frequency) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            builder.append(entry.getKey()).append(": ").append(entry.getValue()).append('\n');
        }
        return builder.toString();
    }
}
