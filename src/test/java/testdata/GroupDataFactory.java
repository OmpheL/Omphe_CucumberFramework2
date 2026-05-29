package testdata;

import com.github.javafaker.Faker;
import models.Group;

import java.time.LocalDate;

public class GroupDataFactory {

    private static final Faker faker = new Faker();

    private static Group createdGroup;

    public static Group createGroup() {

        createdGroup = new Group(
                faker.regexify("[A-Za-z0-9]{6}") + " Group",
                "This is a test group",
                String.valueOf(LocalDate.now().getYear()),
                String.valueOf(
                        faker.number().numberBetween(20, 100)
                ),
                LocalDate.now().toString(),
                LocalDate.now().plusMonths(6).toString()
        );

        return createdGroup;
    }

    public static Group getCreatedGroup() {

        if (createdGroup == null) {
            throw new RuntimeException("No group was created. Call createGroup() first.");
        }

        return createdGroup;
    }

    public static String getCreatedGroupName() {

        if (createdGroup == null) {
            throw new RuntimeException("No group was created. Call createGroup() first.");
        }

        return createdGroup.getName();
    }
}