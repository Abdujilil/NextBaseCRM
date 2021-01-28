package com.NextBaseCRM.utility;

import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class DataUtils {

    public static Faker faker = new Faker();
    public static final Random random = new Random();

    public static String firstName() {
        return faker.name().firstName();
    }

    public static String invalidFirstName() {
        return faker.name().username();
    }

    public static String lastName() {
        return faker.name().lastName();
    }

    public static String invalidLastName() {
        return faker.name().username();
    }

    public static String userName() {
        return faker.name().firstName() + random.nextInt(999);
    }

    public static String invalidUserName() {
        return null;
    }

    public static String email() {
        return faker.internet().emailAddress();
    }

    public static String invalidEmail() {
        return null;
    }

    public static String password() {
        return faker.internet().password(8,16,true);
    }

    public static String invalidPassword() {
        return null;
    }

    public static String phoneNumber() {  // 123-123-1234
        return faker.number().digits(3) + "-"
         + faker.number().digits(3) + "-"
         + faker.number().digits(4);
    }

    public static String invalidPhoneNumber() {
        return null;
    }

    public static String dateOfBirth() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Date dob = faker.date().birthday();
        return dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(df);
    }

    public static String invalidDateOfBirth() {
        return null;
    }

    public static int number(int upperLimit) {
        return random.nextInt(upperLimit);
    }

    public static int number(int digits, int upperLimit) {
        int number;
        do {
            number = Integer.parseInt(faker.number().digits(digits));
        } while (number >= upperLimit);
        return number;
    }

    public static String number(String digits, String upperLimit) {
        String number;
        do {
            number = faker.number().digits(Integer.parseInt(digits));
        } while (Integer.parseInt(number) >= Integer.parseInt(upperLimit));
        return number;
    }

    public static String generateRandomMessage() {

        return faker.chuckNorris().fact();

    }

}
