package main;

public class Friend {

    // Friend Info
    private final String fName;
    private final String lName;
    private final String phone;
    private final String email;
    private boolean starred = false;

    Friend(String fName, String lName, String email, String phone, Boolean starred) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.starred = starred;
    }

    /**
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Returns TSV String
     *
     * @return Friend Object and its data put in TSV row
     */
    String toTSV() {
        return this.fName + "\t" + this.lName + "\t" + this.email + "\t" + this.phone + "\t" + this.starred;
    }

    /**
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Returns Formatted String
     *
     * @return Formatted String with FName, LName and (✭)
     */
    @Override
    public String toString() {
        return fName.toUpperCase() + " " + lName.toUpperCase() + (starred ? "   ✭" : ' ');
    }

    // Getters and Setters

    String getfName() {
        return fName;
    }

    String getlName() {
        return lName;
    }

    String getPhone() {
        return phone;
    }

    String getEmail() {
        return email;
    }

    void star() {
        this.starred = !this.starred;
    }

    boolean isStarred() {
        return starred;
    }
}
