package pl.wszib.travelallowance.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.wszib.travelallowance.dao.EmployeePreferencesDao;
import pl.wszib.travelallowance.dao.MonthDao;
import pl.wszib.travelallowance.dao.UserDao;
import pl.wszib.travelallowance.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service

public class EmployeePreferencesService {


    private final UserDao userDao;
    private final MonthDao monthDao;
    private final EmployeePreferencesDao employeePreferencesDao;
    private final ValidationService validationService;


    public EmployeePreferencesService(EmployeePreferencesDao employeePreferencesDao, UserDao userDao, MonthDao monthDao, ValidationService validationService) {
        this.employeePreferencesDao = employeePreferencesDao;
        this.userDao = userDao;
        this.monthDao = monthDao;

        this.validationService = validationService;
    }

    @Transactional
    public String savePreferences(EmployeePreferencesModel employeePreferencesModel) {
        validationService.validateDayShift(employeePreferencesModel);
        String monthFromLocalDate = employeePreferencesModel.getLocalDate().getMonth().toString();
        Month month = monthDao.findByMonthName(MonthName.valueOf(monthFromLocalDate)).orElse(null);
        String successMessage = validationService.compareWorkingDays(month, employeePreferencesModel.getIndex().toString());
        EmployeePreferences preferences = new EmployeePreferences();

        User user = userDao.findByIndex(employeePreferencesModel.getIndex());

        preferences.setUser(user);

        preferences.setMonth(month);
        preferences.setLocalDate(employeePreferencesModel.getLocalDate());
        preferences.setShift(employeePreferencesModel.getShift());


        employeePreferencesDao.save(preferences);

        return successMessage;
    }

    public List<EmployeePreferencesModel> findAllPreferences(String month, String index) {
        return employeePreferencesDao.findByUserAndMonth(Integer.valueOf(index), MonthName.valueOf(month))
                .stream().map(preference -> {
                    EmployeePreferencesModel employeePreferencesModel = new EmployeePreferencesModel();
                    employeePreferencesModel.setIndex(preference.getUser().getIndex());
                    employeePreferencesModel.setLocalDate(preference.getLocalDate());
                    employeePreferencesModel.setMonth(preference.getMonth().getMonthName().toString());
                    employeePreferencesModel.setShift(preference.getShift());

                    return employeePreferencesModel;
                }).toList();
    }

    public void editShift(LocalDate localDate, Shift shift) {

        Optional<EmployeePreferences> dailyShift = employeePreferencesDao.findByIndexAndLocalDate(localDate);

        if (dailyShift.isPresent()) {
            dailyShift.get().setShift(shift);
            employeePreferencesDao.save(dailyShift.get());
        }


    }

    public Double calculateTravelAllowance(String indexStr, MonthName month) {
        List<EmployeePreferencesModel> preferencesList = findAllPreferences(month.toString(), indexStr);
        int pmShiftDays = 0;

        for (EmployeePreferencesModel preference : preferencesList) {
            if (preference.getShift() == Shift.PM) {
                pmShiftDays++;
            }
        }

        Double travelAllowance = pmShiftDays * 60.0;

        return travelAllowance;
    }



    public Optional<Month> findByMonthName(MonthName monthName) {
        return monthDao.findByMonthName(monthName);
    }

    public int calculateNumberOfPMShifts(Integer index, MonthName month) {
        List<EmployeePreferences> preferences = employeePreferencesDao.findByUserAndMonth(index, month);

        int numberOfPMShifts = 0;

        for (EmployeePreferences preference : preferences) {
            if (preference.getShift() == Shift.PM) {
                numberOfPMShifts++;
            }
        }

        return numberOfPMShifts;
    }


}


