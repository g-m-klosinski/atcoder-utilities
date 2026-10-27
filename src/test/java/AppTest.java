import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void checkTaskValidityAlertsOnZeroArguments() {
        var coordinates = new String[] {};

        Optional<String> errorMessage = App.checkTaskValidity(coordinates);

        assertTrue(errorMessage.isPresent());
        assertTrue(errorMessage.get().startsWith("Usage:"));
    }
}
