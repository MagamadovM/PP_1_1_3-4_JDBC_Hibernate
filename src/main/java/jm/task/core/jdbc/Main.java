package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();


        userService.createUsersTable();
        userService.saveUser("Александр", "Павлов", (byte) 20);
        userService.saveUser("Иван", "Павлов", (byte) 23);
        userService.saveUser("Семен", "Иванов", (byte) 39);
        userService.saveUser("Алексей", "Смирнов", (byte) 45);

        userService.removeUserById(3);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        userService.dropUsersTable();

        Util.closeConnection();
    }
}


