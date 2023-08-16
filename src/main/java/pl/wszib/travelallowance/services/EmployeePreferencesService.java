package pl.wszib.travelallowance.services;

import org.springframework.stereotype.Service;
import pl.wszib.travelallowance.dao.EmployeePreferencesDao;
import pl.wszib.travelallowance.dao.MonthDao;
import pl.wszib.travelallowance.dao.UserDao;
import pl.wszib.travelallowance.model.EmployeePreferences;
import pl.wszib.travelallowance.model.EmployeePreferencesModel;
import pl.wszib.travelallowance.model.Month;
import pl.wszib.travelallowance.model.User;

@Service
public class EmployeePreferencesService {


    private  final  UserDao userDao;
    private final MonthDao monthDao;



    private final EmployeePreferencesDao employeePreferencesDao;

    public EmployeePreferencesService(EmployeePreferencesDao employeePreferencesDao, UserDao userDao, MonthDao monthDao) {
        this.employeePreferencesDao = employeePreferencesDao;
        this.userDao= userDao;
        this.monthDao = monthDao;
    }



        public void savePreferences(EmployeePreferencesModel employeePreferencesModel) {
            EmployeePreferences preferences = new EmployeePreferences();

            User user =userDao.findByIndex(employeePreferencesModel.getIndex());

            preferences.setUser(user);

            Month month= monthDao.findByMonthName(employeePreferencesModel.getMonth()).orElse(null);
            preferences.setMonth(month);
            preferences.setLocalDate(employeePreferencesModel.getLocalDate());
            preferences.setShift(employeePreferencesModel.getShift());

            employeePreferencesDao.save(preferences);
        }



    /*public List<EmployeePreferences> getEmployeeShiftsByUserAndMonth(User user, Month month) {
        return employeePreferencesRepository.findByUserAndMonth(user, month);
    }
}*/

}
