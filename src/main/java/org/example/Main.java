package org.example;

public class Main {
    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        User firstUser = new User();
        firstUser.setName("Jan");
        firstUser.setLastName("Kowalski");
        firstUser.setEmail("jan.kowalski@gmail.com");
        firstUser.setAge(34);

        dao.saveUser(firstUser);
    }
}

