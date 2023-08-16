package pl.wszib.travelallowance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wszib.travelallowance.model.EmployeePreferences;
import pl.wszib.travelallowance.model.Month;
import pl.wszib.travelallowance.model.User;

import java.util.List;

@Repository
    public interface EmployeePreferencesDao extends JpaRepository<EmployeePreferences,Long> {

    List<EmployeePreferences> findByUserAndMonth(User user, Month month);




    // EmployeePreferences findByEmployeeIdAndMonth(String employeeId, Month month);

    // Pobieranie preferencji pracownika na podstawie daty
        //EmployeePreferences findByDate(LocalDate date);

        // Pobieranie wszystkich preferencji pracownika dla danego miesiąca i roku
        //List<EmployeePreferences> findByDateBetween(LocalDate startDate, LocalDate endDate);

        // Pobieranie wszystkich preferencji pracownika o zadanym numerze identyfikacyjnym
      //List<EmployeePreferences> findByEmployeeId(String employeeId);

}

