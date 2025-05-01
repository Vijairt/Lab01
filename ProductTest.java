import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Laptop", "Gaming laptop with RTX GPU", "P001", 1499.99);
    }

    @Test
    void testConstructorAndToString() {
        assertEquals("Laptop (P001): Gaming laptop with RTX GPU - $1499.99", product.toString());
    }

    @Test
    void testSetName() {
        product.setName("Desktop");
        assertTrue(product.toString().startsWith("Desktop"));
    }

    @Test
    void testSetDescription() {
        product.setDescription("Powerful desktop PC");
        assertTrue(product.toString().contains("Powerful desktop PC"));
    }

    @Test
    void testSetCost() {
        product.setCost(1999.99);
        assertEquals(1999.99, product.getCost());
    }

    @Test
    void testToCSV() {
        assertEquals("Laptop,Gaming laptop with RTX GPU,P001,1499.99", product.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = "{\"name\":\"Laptop\",\"description\":\"Gaming laptop with RTX GPU\",\"ID\":\"P001\",\"cost\":1499.99}";
        assertEquals(expected, product.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Product><name>Laptop</name><description>Gaming laptop with RTX GPU</description><ID>P001</ID><cost>1499.99</cost></Product>";
        assertEquals(expected, product.toXML());
    }

    @Test
    void testEquals() {
        Product sameID = new Product("Other", "Other description", "P001", 100.0);
        assertEquals(product, sameID);
    }
}
