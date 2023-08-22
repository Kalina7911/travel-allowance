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



}

