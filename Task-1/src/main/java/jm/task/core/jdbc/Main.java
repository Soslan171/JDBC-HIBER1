package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        System.out.println();

        Thread.sleep(1000);

        User user1 = new User("user1", "userov1", (byte) 30);
        User user2 = new User("user2", "userov2", (byte) 25);
        User user3 = new User("user3", "userov3", (byte) 20);
        User user4 = new User("user4", "userov4", (byte) 15);

        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        System.out.println();

        Thread.sleep(500);

        List<User> list = userService.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println();

        Thread.sleep(500);

        userService.cleanUsersTable();
        System.out.println();

        Thread.sleep(500);

        if (userService.getAllUsers().isEmpty())
            System.out.println("В таблице пусто.");
        System.out.println();

        Thread.sleep(500);

        userService.dropUsersTable();
    }
}



