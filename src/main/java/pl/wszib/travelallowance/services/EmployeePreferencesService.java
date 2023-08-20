package pl.wszib.travelallowance.services;

import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;
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


    public EmployeePreferencesService(EmployeePreferencesDao employeePreferencesDao, UserDao userDao, MonthDao monthDao) {
        this.employeePreferencesDao = employeePreferencesDao;
        this.userDao = userDao;
        this.monthDao = monthDao;
    }


    public void savePreferences(EmployeePreferencesModel employeePreferencesModel) {
        EmployeePreferences preferences = new EmployeePreferences();

        User user = userDao.findByIndex(employeePreferencesModel.getIndex());

        preferences.setUser(user);

        String monthFromLocalDate = employeePreferencesModel.getLocalDate().getMonth().toString();
        Month month = monthDao.findByMonthName(MonthName.valueOf(monthFromLocalDate)).orElse(null);
        preferences.setMonth(month);
        preferences.setLocalDate(employeePreferencesModel.getLocalDate());
        preferences.setShift(employeePreferencesModel.getShift());


        employeePreferencesDao.save(preferences);
    }

    public List<EmployeePreferencesModel> findAllPreferences(String month) {
        return employeePreferencesDao.findByUserAndMonth(111, MonthName.valueOf(month))
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



    /*public List<EmployeePreferences> getEmployeeShiftsByUserAndMonth(User user, Month month) {
        return employeePreferencesRepository.findByUserAndMonth(user, month);
    }
}*/

}
