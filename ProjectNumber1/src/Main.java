public class Main {

    //Code your solution to problem number one here
    static int problemOne(String s){
        int answer = 0;

        // Iterates through the string and check if its a vowel
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                answer++;

        return answer;
    }

    //Code you problem number two here
    static int problemTwo(String s){
        int answer = 0;

        // Iterates through the string and check if the substring at that position to position + 3 is equal to "bob"
        for(int i = 0; i < s.length() - 2; i++)
            if(s.substring(i, i + 3).equals("bob"))
                answer++;

        return answer;
    }

    //Code your solution to problem number 3 here
    static String problemThree(String s){

        // Checks if the provided String is empty
        if(s.length() == 0) return "No String Provided";

        // Create two variables named Longest and Current
        String longest = String.valueOf(s.charAt(0));
        String current;

        // Iterate through the string
        for(int i = 0; i < s.length(); i ++) {

            // Set the current as the character at Index "i" in String "s"
            current = String.valueOf(s.charAt(i));

            // Iterate through all the letters that are behind the current letter
            for(int j = i + 1; j < s.length(); j++) {

                // Converts char to int and check if the next charcter is larger than the last letter of the "current" string
                // Basically checks if the new char is behind the current char in the alphabet
                // If so, it adds it to the "current" string and continues the loop
                if((int) current.charAt(current.length() - 1) <= (int) s.charAt(j)) {
                    current += String.valueOf(s.charAt(j));
                    continue;
                }

                // Breaks out of the loop to prevent adding future character that are behind the current character in the alphabet
                break;
            }

            // Sets the longest string as the current on if "current"'s length is longer
            if(current.length() > longest.length()) longest = current;
        }

        return longest;
    }

    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s;
    }
}
