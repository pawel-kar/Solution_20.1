package pl.bootcamp.ex20;

class User {
    private String firstName;
    private String lastName;
    private int age;

    User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Imię: %s Nazwisko: %s Wiek: %d", firstName, lastName, age);
    }
}
