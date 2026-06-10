import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationServiceTest {

    private RegistrationService registrationService;

    @BeforeEach
    void setUp() {
        registrationService = new RegistrationService();
    }

    @Test
    void testSuccessfulRegistration()
            throws InvalidEmailException {

        boolean result =
                registrationService.registerUser(
                        "john.doe@example.co",
                        25);

        assertTrue(result);
    }

    @Test
    void testNullEmailThrowsException() {

        assertThrows(
                InvalidEmailException.class,
                () -> registrationService.registerUser(
                        null,
                        25)
        );
    }

    @Test
    void testEmptyEmailThrowsException() {

        assertThrows(
                InvalidEmailException.class,
                () -> registrationService.registerUser(
                        "",
                        25)
        );
    }

    @Test
    void testInvalidEmailFormatThrowsException() {

        assertThrows(
                InvalidEmailException.class,
                () -> registrationService.registerUser(
                        "invalid-email",
                        25)
        );
    }

    @Test
    void testUnderageUserThrowsException() {

        assertThrows(
                UnderageException.class,
                () -> registrationService.registerUser(
                        "user@example.com",
                        16)
        );
    }

    @Test
    void testAgeExactly18IsAccepted()
            throws InvalidEmailException {

        boolean result =
                registrationService.registerUser(
                        "adult@example.com",
                        18);

        assertTrue(result);
    }
}