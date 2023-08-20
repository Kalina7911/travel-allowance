package pl.wszib.travelallowance.controller;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wszib.travelallowance.model.EmployeePreferencesModel;
import pl.wszib.travelallowance.model.Shift;
import pl.wszib.travelallowance.services.EmployeePreferencesService;

import java.time.LocalDate;

@Controller
public class EmployeePreferencesController {

    private final EmployeePreferencesService employeePreferencesService;

    public EmployeePreferencesController(EmployeePreferencesService employeePreferencesService) {
        this.employeePreferencesService = employeePreferencesService;
    }

   /* @PostMapping("/preferences")
    public void savePreferences (@ModelAttribute ("employeePreferencesModel") EmployeePreferencesModel employeePreferencesModel){
        employeePreferencesService.savePreferences(employeePreferencesModel);
    }*/

   /*@GetMapping("/preferences/{month}")
    public String findAllPreferences (@PathVariable ("month") String month, Model model){
        model.addAttribute("month", month);
        model.addAttribute("preferences", employeePreferencesService.findAllPreferences(month));
        return "preferencesPage";

    }*/


  //@PatchMapping("/preferneces/{date}")
   //public void editShift(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate localDate, Shift shift){
     //  employeePreferencesService.editShift();
  // }
}
