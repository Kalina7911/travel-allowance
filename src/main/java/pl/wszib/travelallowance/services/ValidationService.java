package pl.wszib.travelallowance.services;

import org.springframework.stereotype.Service;
import pl.wszib.travelallowance.dao.EmployeePreferencesDao;
import pl.wszib.travelallowance.exceptions.WorkingDaysException;
import pl.wszib.travelallowance.model.EmployeePreferences;
import pl.wszib.travelallowance.model.Month;

import java.util.List;

@Service
public class ValidationService {


    private final EmployeePreferencesDao employeePreferencesDao;

    public ValidationService(EmployeePreferencesDao employeePreferencesDao) {
        this.employeePreferencesDao = employeePreferencesDao;
    }

    public void compareWorkingDays(Month month, String index) {
        List<EmployeePreferences> preferences = employeePreferencesDao.findByUserAndMonth(Integer.valueOf(index), month.getMonthName());
        int employeeWorkingDays = preferences.size() + 1;

        Integer requiredWorkingDays = month.getWorkingDays();
        if (employeeWorkingDays > requiredWorkingDays) {
            int daysToRemove = employeeWorkingDays - requiredWorkingDays;
            throw new WorkingDaysException("You need to de");
        }
    }
}
