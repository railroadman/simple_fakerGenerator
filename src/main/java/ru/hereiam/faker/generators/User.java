package ru.hereiam.faker.generators;

import com.github.javafaker.Faker;

public class User {

    private final String lastName;
    private final String firstName;
    private final String streetAddress;
    private final Integer age;
    private final String login;
    private final String password;
    //private final String zipCode;
    //private final String occupation;
    //private final String sex;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLogin() {
        return login;
    }

    public Integer getAge() {
        return age;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {

        private String lastName;
        private String firstName;
        private String streetAddress;
        private Integer age;
        private String login;
        private String password;
        private String zipCode;
        private String occupation;
        private String sex;
        private Faker faker;


        public Builder() {
            this.faker = new Faker();
        }

        public Builder age(Integer from, Integer to) {
            this.age = from + (int) (Math.random() * ((to - from) + 1));
            return this;

        }

        public Builder login() {
            this.login = this.faker.name().firstName();
            return this;
        }

        public Builder firstName() {
            this.firstName = this.faker.name().firstName();
            return this;
        }

        public Builder lastName() {
            this.lastName = this.faker.name().lastName();
            return this;

        }

        public Builder password(String pattern) {
            this.password = this.faker.regexify(pattern);
            return this;
        }

        public Builder streetAddress() {
            this.streetAddress = this.faker.address().streetAddress();
            return this;
        }

        public User build() {
            return new User(this);

        }

    }

    private User(Builder b) {
        this.firstName = b.firstName;
        this.lastName = b.lastName;
        this.login = b.login;
        this.age = b.age;
        this.password = b.password;
        this.streetAddress = b.streetAddress;
    }


}
