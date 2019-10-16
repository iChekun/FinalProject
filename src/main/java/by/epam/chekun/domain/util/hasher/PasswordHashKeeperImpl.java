package by.epam.chekun.domain.util.hasher;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PasswordHashKeeperImpl implements PasswordHashKeeper {


    /**
     * Generate hash-string on base of given parameters (login and password).
     * Salt is generated on base of login (because login is unchangeable),
     * then password is encoded and returned.
     *
     * @param login user's login.
     * @param password user's password.
     * @return encoded password.
     */
    public String generateHash(String login, String password) {
        byte[] salt = login.getBytes();
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] encoded = factory.generateSecret(spec).getEncoded();
            return new String(encoded, UTF_8);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {

        }
        throw new RuntimeException();
    }
}
