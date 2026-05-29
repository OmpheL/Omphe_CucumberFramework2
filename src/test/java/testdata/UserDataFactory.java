package testdata;

import com.github.javafaker.Faker;
import models.User;

public class UserDataFactory {

    private static final Faker faker = new Faker();

    public static User createUser(String groupName) {

        String password = "Test@123";

        return new User(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                password,
                password,
                groupName
        );
    }
}