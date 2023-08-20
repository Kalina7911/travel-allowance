package pl.wszib.travelallowance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wszib.travelallowance.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
    public interface EmployeePreferencesDao extends JpaRepository<EmployeePreferences,Long>, JpaSpecificationExecutor<EmployeePreferences> {



    @Query("select distinct e from EmployeePreferences e where e.user.index = ?1 and e.month.monthName = ?2")
    public List<EmployeePreferences> findByUserAndMonth(Integer index, MonthName month);


    @Query("select distinct e from EmployeePreferences e where e.user.index = ?1 and e.localDate = ?2")
    Optional<EmployeePreferences> findByIndexAndLocalDate(LocalDate localDate);


    // EmployeePreferences findByEmployeeIdAndMonth(String employeeId, Month month);

    // Pobieranie preferencji pracownika na podstawie daty
        //EmployeePreferences findByDate(LocalDate date);

        // Pobieranie wszystkich preferencji pracownika dla danego miesiąca i roku
        //List<EmployeePreferences> findByDateBetween(LocalDate startDate, LocalDate endDate);

        // Pobieranie wszystkich preferencji pracownika o zadanym numerze identyfikacyjnym
      //List<EmployeePreferences> findByEmployeeId(String employeeId);

}

