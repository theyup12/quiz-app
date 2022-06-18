package com.example.quizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.sql.SQLException;

@Controller
public class TestDbController {
    @Autowired
    private DataSource dataSource;

    @RequestMapping("/checkConnection")
    public ModelAndView greet() {

        try {
            if (dataSource.getConnection() != null) {
                return new ModelAndView("testDb", "msg", "Database Connection Successfully Established.");
            } else {
                return new ModelAndView("testDb", "msg", "Failed to connect database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ModelAndView("testDb", "msg", "Failed to connect database.");
        }
    }
}
