package pl.wszib.travelallowance.controller;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wszib.travelallowance.exceptions.WorkingDaysException;
import pl.wszib.travelallowance.model.EmployeePreferencesModel;
import pl.wszib.travelallowance.model.Month;
import pl.wszib.travelallowance.model.MonthName;
import pl.wszib.travelallowance.model.Shift;
import pl.wszib.travelallowance.services.EmployeePreferencesService;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class EmployeePreferencesController {

    private final EmployeePreferencesService employeePreferencesService;

    public EmployeePreferencesController(EmployeePreferencesService employeePreferencesService) {
        this.employeePreferencesService = employeePreferencesService;
    }


    @GetMapping("/preferences")
    public String preferencesPage(Model model) {
        model.addAttribute("employeePreferencesModel", new EmployeePreferencesModel()); // dodanie pustego obiektu do modelu
        return "preferencesPage";
    }

    @PostMapping("/preferences")
    public String savePreferences(@ModelAttribute EmployeePreferencesModel employeePreferencesModel, RedirectAttributes redirectAttributes, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "preferencesPage";
        }

        redirectAttributes.addFlashAttribute("successMessage", "Preferences added successfully!");

            employeePreferencesService.savePreferences(employeePreferencesModel); // save preferencji


        return "redirect:/preferences";
    }

    @GetMapping("/preferences-list")   ///{month}, (@PathVariable ("month") String month,
    public String findAllPreferences(@RequestParam("index") String index, Model model) {
        String month = LocalDate.now().plusMonths(1).getMonth().toString();
        model.addAttribute("month", month);
        model.addAttribute("index", index);
        model.addAttribute("employeePreferencesModel", new EmployeePreferencesModel());
        model.addAttribute("preferences", employeePreferencesService.findAllPreferences(month, index));

        return "preferencesPage";

    }

    @GetMapping("/preferences-month")
    public String findNextMonth(Model model) {
        model.addAttribute("nextMonth", employeePreferencesService.findNextMonth());

        return "preferencesPage";
    }




}