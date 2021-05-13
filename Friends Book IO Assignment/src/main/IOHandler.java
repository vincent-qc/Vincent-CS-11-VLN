package main;

import java.io.*;
import java.util.ArrayList;

class IOHandler {
    private static final ArrayList<Friend> allFriends = new ArrayList<>();

    /**
     * Writes out all data
     *
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Writes all Friends to data
     */
    static void writeOut() {
        try {
            FileWriter fWrite = new FileWriter("data.txt", false);
            BufferedWriter bWrite = new BufferedWriter(fWrite);

            for (Friend f : allFriends) bWrite.write(f.toTSV() + "\n");

            bWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads all data
     *
     * Requires: Nothing
     * Modifies: allFriends
     * Effects: Add Friends from data
     */
    static void readIn() {
        allFriends.clear(); // Reset Friends

        try {
            FileReader fRead = new FileReader("data.txt");
            BufferedReader bRead = new BufferedReader(fRead);

            String line;

            while ((line = bRead.readLine()) != null) {
                String[] data = line.split("\t");

                allFriends.add(new Friend(data[0], data[1], data[2], data[3], Boolean.parseBoolean(data[4])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Requires: Friend
     * Modifies: allFriends
     * Effects: Adds Friend to allFriends
     *
     * @param friend Friend to add
     */
    public static void addItemAllFriends(Friend friend) {
        allFriends.add(friend);
    }

    /**
     * Requires: Friend
     * Modifies: allFriends
     * Effects: Removes a Friend from allFriends
     *
     * @param friend Friend to remove
     */
    static void removeItemAllFriends(Friend friend) {
        allFriends.remove(friend);
    }


    /**
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Returns the allFriends ArrayList
     *
     * @return allFriends
     */
    static ArrayList<Friend> getAllFriends() {
        return allFriends;
    }
}
