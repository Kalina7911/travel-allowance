package pl.wszib.travelallowance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wszib.travelallowance.model.MonthName;
import pl.wszib.travelallowance.services.EmployeePreferencesService;

@Controller
public class BonusController {


    private final EmployeePreferencesService employeePreferencesService;

    @Autowired
    public BonusController(EmployeePreferencesService employeePreferencesService) {
        this.employeePreferencesService = employeePreferencesService;
    }


    @GetMapping("/bonus")
    public String showBonusPage( Model model) {

        return "bonusPage";
    }



    @GetMapping("/calculate-bonus")
    public String calculateBonus(@RequestParam("index") Integer index, @RequestParam("month") MonthName month, Model model) {
        int numberOfPMShifts = employeePreferencesService.calculateNumberOfPMShifts(index, month);
        Double travelAllowance = employeePreferencesService.calculateTravelAllowance(index.toString(), month);

        model.addAttribute("numberOfPMShifts", numberOfPMShifts);
        model.addAttribute("travelAllowance", travelAllowance);

        return "bonusPage";
    }
}

