package by.epam.chekun.domain.util.hasher;

public interface PasswordHashKeeper {
    String generateHash(String login, String password);
}
