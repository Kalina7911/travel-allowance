package pl.wszib.travelallowance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

   /* @PostMapping("/preferences")
    public void savePreferences (@ModelAttribute("employeePreferencesModel") EmployeePreferencesModel employeePreferencesModel){
        employeePreferencesService.savePreferences(employeePreferencesModel);
    }*/


}
