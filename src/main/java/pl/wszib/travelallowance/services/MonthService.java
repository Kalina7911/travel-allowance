package pl.wszib.travelallowance.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wszib.travelallowance.dao.MonthDao;
import pl.wszib.travelallowance.model.Month;
import pl.wszib.travelallowance.model.MonthEditModel;
import pl.wszib.travelallowance.model.MonthName;

import java.util.Optional;

@Service
public class MonthService {

    private final MonthDao monthDao;
    private boolean dataInitialized = false; // W ten sposób dane zostaną zainicjowane tylko raz.

    @Autowired
    public MonthService(MonthDao monthDao) {

        this.monthDao = monthDao; //inicjalizacja
    }

    @PostConstruct
    public void init() {
        if (!dataInitialized) {
            monthDao.save(new Month(MonthName.JANUARY, 21));
            monthDao.save(new Month(MonthName.FEBRUARY, 20));
            monthDao.save(new Month(MonthName.MARCH, 23));
            monthDao.save(new Month(MonthName.MAY, 20));
            monthDao.save(new Month(MonthName.JUNE, 22));
            monthDao.save(new Month(MonthName.JULY, 22));
            monthDao.save(new Month(MonthName.JULY, 21));
            monthDao.save(new Month(MonthName.AUGUST, 23));
            monthDao.save(new Month(MonthName.SEPTEMBER, 20));
            monthDao.save(new Month(MonthName.OCTOBER, 21));
            monthDao.save(new Month(MonthName.NOVEMBER, 22));
            monthDao.save(new Month(MonthName.DECEMBER, 23));

            dataInitialized = true;
        }
    }

    public void editWorkingDays(String monthName, MonthEditModel monthEditModel) {

        Optional<Month> byMonthName = monthDao.findByMonthName(monthName);

        if (byMonthName.isPresent()) {
            byMonthName.get().setWorkingDays(monthEditModel.getWorkingDays());
        }


    }
}



