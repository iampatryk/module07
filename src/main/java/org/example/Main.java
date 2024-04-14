package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        User firstUser = new User();
        firstUser.setName("Jan");
        firstUser.setLastName("Kowalski");
        firstUser.setEmail("jan.kowalski@gmail.com");
        firstUser.setAge(34);
        Address address = new Address();
        address.setCity("Warszawa");
        address.setStreet("1234");
        firstUser.setAddress(address);

        List<License> licenseList = new ArrayList<>();
        License l = new License();
        l.setUser(firstUser);
        l.setKey("123");
        licenseList.add(l);

        dao.saveUser(firstUser,address, licenseList);
        dao.changeUserAge("jan.kowalski@gmail.com", 35);
        dao.deleteUser("jan.kowalski@gmail.com");

//        System.out.println(dao.findUserByEmail("jan.kowalski@gmail.com"));
    }
}

