package pl.wszib.travelallowance.services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pl.wszib.travelallowance.dao.MonthDao;
import pl.wszib.travelallowance.dao.UserDao;
import pl.wszib.travelallowance.model.Month;
import pl.wszib.travelallowance.model.MonthEditModel;
import pl.wszib.travelallowance.model.MonthName;
import pl.wszib.travelallowance.model.User;

import java.util.Optional;

@Service
public class MonthService {


    private final UserDao userDao;
    private final MonthDao monthDao;
    private boolean dataInitialized = false; // W ten sposób dane zostaną zainicjowane tylko raz.

    public MonthService(UserDao userDao, MonthDao monthDao) {
        this.userDao = userDao;
        this.monthDao = monthDao;
    }


    @PostConstruct
    public void init() {
        if (!dataInitialized) {
            monthDao.save(new Month(1L, MonthName.JANUARY, 21));
            monthDao.save(new Month(2L, MonthName.FEBRUARY, 20));
            monthDao.save(new Month(3L, MonthName.MARCH, 23));
            monthDao.save(new Month(4L, MonthName.APRIL, 20));
            monthDao.save(new Month(5L, MonthName.MAY, 22));
            monthDao.save(new Month(6L, MonthName.JUNE, 22));
            monthDao.save(new Month(7L, MonthName.JULY, 21));
            monthDao.save(new Month(8L, MonthName.AUGUST, 21));
            monthDao.save(new Month(9L, MonthName.SEPTEMBER, 2));
            monthDao.save(new Month(10L, MonthName.OCTOBER, 21));
            monthDao.save(new Month(11L, MonthName.NOVEMBER, 22));
            monthDao.save(new Month(12L, MonthName.DECEMBER, 23));
            userDao.save(new User("admin", 111, "admin", 1L));

            dataInitialized = true;
        }
    }


    public void editWorkingDays(MonthName monthName, MonthEditModel monthEditModel) {

        Optional<Month> byMonthName = monthDao.findByMonthName(monthName);

        if (byMonthName.isPresent()) {
            byMonthName.get().setWorkingDays(monthEditModel.getWorkingDays());
            monthDao.save(byMonthName.get());
        }


    }


}



