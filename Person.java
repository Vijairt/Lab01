public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getID() { return ID; }
    public String getTitle() { return title; }
    public int getYOB() { return YOB; }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return String.valueOf(year - YOB);
    }

    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    public String toCSV() {
        return String.join(",", firstName, lastName, ID, title, String.valueOf(YOB));
    }

    public String toJSON() {
        return String.format("{\"firstName\":\"%s\",\"lastName\":\"%s\",\"ID\":\"%s\",\"title\":\"%s\",\"YOB\":%d}",
                firstName, lastName, ID, title, YOB);
    }

    public String toXML() {
        return String.format("<Person><firstName>%s</firstName><lastName>%s</lastName><ID>%s</ID><title>%s</title><YOB>%d</YOB></Person>",
                firstName, lastName, ID, title, YOB);
    }

    @Override
    public String toString() {
        return formalName() + " (" + ID + "), born " + YOB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return YOB == person.YOB && ID.equals(person.ID);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(ID, YOB);
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

}
