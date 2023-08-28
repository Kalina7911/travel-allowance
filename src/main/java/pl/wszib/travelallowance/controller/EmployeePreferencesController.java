package pl.wszib.travelallowance.controller;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wszib.travelallowance.model.EmployeePreferencesModel;
import pl.wszib.travelallowance.services.EmployeePreferencesService;

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
    public String savePreferences(@ModelAttribute @Valid EmployeePreferencesModel employeePreferencesModel, RedirectAttributes redirectAttributes, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "preferencesPage";
        }

        redirectAttributes.addFlashAttribute("successMessage", "Preference added");

        String message = employeePreferencesService.savePreferences(employeePreferencesModel);// save preferencji
        redirectAttributes.addFlashAttribute("generalMessage", message);


        return "redirect:/preferences";
    }

    /*@GetMapping("/preferences-list")   ///{month}, (@PathVariable ("month") String month,
    public String findAllPreferences(@RequestParam("index") String index, Model model) {
        String month = LocalDate.now().plusMonths(1).getMonth().toString();
        model.addAttribute("month", month);
        model.addAttribute("index", index);
        model.addAttribute("employeePreferencesModel", new EmployeePreferencesModel());
        model.addAttribute("preferences", employeePreferencesService.findAllPreferences(month, index));

        return "preferencesPage";

    }*/


}