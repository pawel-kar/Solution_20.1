package pl.bootcamp.ex20;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
class UserRepository {
    private final List<User> userList = new ArrayList<>();

    UserRepository() {
        userList.add(new User("Anastazja", "Samolot", 29));
        userList.add(new User("Mariusz", "Garnek", 20));
        userList.add(new User("Stefan", "Batory", 63));
    }

    void addUser(User user) {
        userList.add(user);
    }

    List<User> getUserList() {
        return userList;
    }
}
