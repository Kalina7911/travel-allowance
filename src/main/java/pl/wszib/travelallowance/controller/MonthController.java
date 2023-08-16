package pl.wszib.travelallowance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.wszib.travelallowance.model.MonthEditModel;
import pl.wszib.travelallowance.model.MonthName;
import pl.wszib.travelallowance.services.MonthService;

@Controller

public class MonthController {

   final
   MonthService monthService;

    public MonthController(MonthService monthService) {

        this.monthService = monthService; // ==@autowired
    }


    @PatchMapping("/month/{monthName}") //MonthName= enum

    public String editWorkingDays (@PathVariable ("monthName") MonthName monthName, @ModelAttribute("monthEditModel") MonthEditModel monthEditModel){

        monthService.editWorkingDays(monthName, monthEditModel);
        return "bonusPage";

    }

}
