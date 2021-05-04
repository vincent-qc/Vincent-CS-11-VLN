package main;

public class Friend {
    private static int idCounter = 0;
    private final int id;
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

        // ID
        this.id = idCounter;
        idCounter++;
    }

    /**
     * Currently Method Is only for Development
     * Prints Name, Email and Phone
     * TODO: Remove / Refactor method once finished
     */
    public void print() {
        System.out.println(
                fName.toUpperCase() + " " + lName.toUpperCase() +
                        "\n" + "EMAIL: " + email + "\n" +
                        "PHONE: " + phone
        );
    }

    // Invert Starred
    void star() {
        this.starred = !this.starred;
    }

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

    boolean isStarred() {
        return starred;
    }
}
