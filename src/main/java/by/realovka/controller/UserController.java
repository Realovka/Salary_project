package by.realovka.controller;

import by.realovka.model.User;
import by.realovka.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user")
public class UserController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Double firstSalary = Double.parseDouble(req.getParameter("firstSalary"));
        Double secondSalary = Double.parseDouble(req.getParameter("secondSalary"));
        Double thirdSalary = Double.parseDouble(req.getParameter("thirdSalary"));
        List <Double> salary = List.of(firstSalary,secondSalary,thirdSalary);
        User user = new User(name,salary);
        double averageSalary = UserService.calcAverageSalary(user);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        session.setAttribute("averageSalary", averageSalary);
        req.getRequestDispatcher("/result.jsp").forward(req,resp);
    }

}
