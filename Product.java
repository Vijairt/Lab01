public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    // Constructor with all fields
    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
    }

    public double getCost() {
        return cost;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // Converts product to CSV string
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f", name, description, ID, cost);
    }

    // Converts product to JSON string
    public String toJSON() {
        return String.format("{\"name\":\"%s\",\"description\":\"%s\",\"ID\":\"%s\",\"cost\":%.2f}",
                name, description, ID, cost);
    }

    // Converts product to XML string
    public String toXML() {
        return String.format("<Product><name>%s</name><description>%s</description><ID>%s</ID><cost>%.2f</cost></Product>",
                name, description, ID, cost);
    }

    // Returns a readable string representation of the object
    @Override
    public String toString() {
        return name + " (" + ID + "): " + description + " - $" + cost;
    }

    // Equality based on ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return ID.equals(product.ID);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(ID);
    }
}
