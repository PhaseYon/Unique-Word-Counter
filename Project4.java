import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;

public class Project4 {
    public static void main(String[] args) {
        // Create a file chooser dialog
        JFileChooser j = new JFileChooser();
        String file = "";
        
        // Show the file chooser dialog and wait for user input
        int result = j.showOpenDialog(null);
        
        // If the user selects a file
        if (result == JFileChooser.APPROVE_OPTION) {
            // Read the selected file as a string
            file = readFileAsString(j.getSelectedFile().getPath());
        }

        // Create a TreeMap to store words and their frequencies
        Map<String, Integer> treemap = new TreeMap<>();

        // Remove all digits from the file content
        String temp = file.replaceAll("\\d", "");
        // Split the file content into words using non-word characters as delimiters
        String[] words = temp.split("\\W+");

        // Iterate through each word in the array
        for (String word : words){
            // Convert the word to lowercase and remove leading/trailing whitespace
            word = word.toLowerCase().trim();
            // If the word is not empty
            if (!word.isEmpty()){
                // Update the TreeMap with the word frequency
                treemap.put(word, treemap.getOrDefault(word, 0) + 1);
            }
        }

        // Print the words and their frequencies
        for (Map.Entry<String, Integer> entry : treemap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    // Method to read a file as a string
    public static String readFileAsString(String fileName) {
        String text = "";
        try {
            // Read all bytes from the specified file and convert to a string
            text = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            // Print the stack trace if an IOException occurs
            e.printStackTrace();
        }

        // Return the file content as a string
        return text;
    }
}



