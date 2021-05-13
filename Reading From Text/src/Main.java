import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        // Init
        ArrayList<String> lines = new ArrayList<>();
        FileReader fReader = new FileReader("ProgrammingHistory.txt");
        BufferedReader bReader = new BufferedReader(fReader);

        // Read the file
        String line;
        while((line = bReader.readLine()) != null) lines.add(line);

        // The Test
        System.out.println(findWord("the", lines));
    }

    /**
     * Requires: String word, Lines
     * Modifies: Nothing
     * Effects: returns a formatted string detailing what the indices are
     *
     * @param word The word to find
     * @param lines The arraylist of lines
     * @return Formatted String
     */
    private static String findWord(String word, ArrayList<String> lines) {
        String result = "The word " + word + " can be found in these lines (starting from index 0): ";

        // Loop through the lines and add them to the result
        for(int i = 0; i < lines.size(); i++)
            if(lines.get(i).contains(word))
                result += (i + ", ");

        return result.substring(0, result.length() - 2); // Remove the last ', '
    }
}
