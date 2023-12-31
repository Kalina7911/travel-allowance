package pl.wszib.travelallowance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wszib.travelallowance.model.EmployeePreferencesModel;

@Controller
public class HomeController {


    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("employeePreferencesModel", new EmployeePreferencesModel());
        model.addAttribute("firstName", "Adam");
        return "homePage";
    }

}
