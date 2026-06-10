import java.util.regex.Pattern;

public class RegistrationService {

    // Email validation regex
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,10}$";

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile(EMAIL_REGEX);

    public boolean registerUser(String email, int age)
            throws InvalidEmailException {


        // Null or empty validation
        if (email == null || email.trim().isEmpty()) {
            throw new InvalidEmailException(
                    "Email cannot be null or empty");
        }

        // Email format validation
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new InvalidEmailException(
                    "Invalid email format");
        }

        // Age validation
        if (age < 18) {
            throw new UnderageException(
                    "User must be at least 18 years old");
        }

        // Registration successful
        return true;
    }
}