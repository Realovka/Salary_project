package by.realovka.service;

import by.realovka.model.User;

import java.util.List;

public class UserService {

    public static  double calcAverageSalary(User user) {
        List<Double> list = user.getSalary();
        double allSalary = list.stream().mapToInt(Double::intValue).sum();
        return allSalary / list.size();
    }
}
