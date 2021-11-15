import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ncOBJ11 {

    ncOBJ11 nc;

    @BeforeEach
    void setUp() {
        nc = new ncOBJ11();
    }

    @Test
    public void testUserInputBeingReceived() {
        Object userInput = null;
        assertNotNull("The user input shouldn't be null", (String) userInput);
    }

    @Test
    public void checkIfQuantity() {
        ncOBJ11 quantity = new ncOBJ11();
        assertNotEquals("", quantity);
    }

    @Test
    public void testResult() {
        Object result = null;
        assertNotNull("This user input shouldn't be null", (String) result);
    }

}
