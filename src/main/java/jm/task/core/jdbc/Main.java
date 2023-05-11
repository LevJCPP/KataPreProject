package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser("user1", "last1", (byte) 11);
        service.saveUser("user2", "last2", (byte) 22);
        service.saveUser("user3", "last3", (byte) 33);
        service.saveUser("user4", "last4", (byte) 44);
        service.getAllUsers().forEach(System.out::println);
        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
