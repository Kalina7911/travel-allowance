package pl.wszib.travelallowance.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wszib.travelallowance.model.MonthEditModel;
import pl.wszib.travelallowance.services.MonthService;

@RestController
public class MonthController {

   final
   MonthService monthService;

    public MonthController(MonthService monthService) {
        this.monthService = monthService; // ==@autowired
    }


    @PatchMapping("/month/{monthName}")

    public void editWorkingDays (@PathVariable ("monthName") String monthName, @RequestBody MonthEditModel monthEditModel){

        monthService.editWorkingDays(monthName, monthEditModel);

    }



}
