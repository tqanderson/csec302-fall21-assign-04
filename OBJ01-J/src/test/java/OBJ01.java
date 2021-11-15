import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OBJ01 {

    OBJ01 c;

    @BeforeEach
    void setUp() {
        c = new OBJ01();
    }

    @Test
    public void testUserInputBeingReceived() {
        Object userInput = null;
        assertNotNull("The user input shouldn't be null", (String) userInput);
    }

    @Test
    public void checkIfQuantity() {
        NC_OBJ01 quantity = new NC_OBJ01();
        assertNotEquals("", quantity);
    }

    @Test
    public void testResult() {
        Object result = null;
        assertNotNull("This user input shouldn't be null", (String) result);
    }

}
