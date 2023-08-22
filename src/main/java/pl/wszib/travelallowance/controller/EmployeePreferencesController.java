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

  /* @GetMapping("/preferences")   ///{month}, (@PathVariable ("month") String month,
    public String findAllPreferences (Model model){
       // model.addAttribute("month", month);
        //model.addAttribute("preferences", employeePreferencesService.findAllPreferences(month));
        return "preferencesPage";

    }*/

   /* @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("employeePreferencesModel", new EmployeePreferencesModel());
        model.addAttribute("firstName", "Adam");//co tu sie pisze
        return "homePage";
    }*/

/*   @PostMapping("/preferences")
    public void savePreferences (@ModelAttribute EmployeePreferencesModel employeePreferencesModel, Model model){
        employeePreferencesService.savePreferences(employeePreferencesModel);

      model.addAttribute("preferences",employeePreferencesModel );

    }*/


  //@PatchMapping("/preferneces/{date}")
   //public void editShift(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate localDate, Shift shift){
     //  employeePreferencesService.editShift();
  // }




        @GetMapping("/preferences")
        public String preferencesPage(Model model) {
            // Tutaj można dodać logikę lub pobieranie danych, jeśli jest to potrzebne
            model.addAttribute("employeePreferencesModel", new EmployeePreferencesModel()); // Dodanie pustego obiektu do modelu
            return "preferencesPage";
        }

        @PostMapping("/preferences")
        public String savePreferences(@ModelAttribute EmployeePreferencesModel employeePreferencesModel) {
            employeePreferencesService.savePreferences(employeePreferencesModel); // Wywołanie metody serwisu do zapisu preferencji
            return "redirect:/preferences"; // Przekierowanie z powrotem na stronę z formularzem
        }
    }

