package pl.wszib.travelallowance.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wszib.travelallowance.model.EmployeePreferencesModel;
import pl.wszib.travelallowance.services.EmployeePreferencesService;

@RestController
public class EmployeePreferencesController {

    private final EmployeePreferencesService employeePreferencesService;

    public EmployeePreferencesController(EmployeePreferencesService employeePreferencesService) {
        this.employeePreferencesService = employeePreferencesService;
    }

    @PostMapping("/preferences")
    public void savePreferences (@RequestBody EmployeePreferencesModel employeePreferencesModel){
        employeePreferencesService.savePreferences(employeePreferencesModel);

    }
}
