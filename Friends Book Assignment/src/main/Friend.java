package main;

public class Friend {
    // Friend Info
    private final String fName;
    private final String lName;
    private final String phone;
    private final String email;
    private boolean starred = false;

    Friend(String fName, String lName, String email, String phone) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
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
