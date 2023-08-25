package pl.wszib.travelallowance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.travelallowance.model.EmployeePreferencesModel;
import pl.wszib.travelallowance.services.EmployeePreferencesService;

@Controller
public class HomeController {


    private final EmployeePreferencesService employeePreferencesService;

    public HomeController(EmployeePreferencesService employeePreferencesService) {
        this.employeePreferencesService = employeePreferencesService;
    }


    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("employeePreferencesModel", new EmployeePreferencesModel());
        model.addAttribute("firstName", "Adam");//co tu sie pisze
        return "homePage";
    }


}
