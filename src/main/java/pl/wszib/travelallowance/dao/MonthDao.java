package pl.wszib.travelallowance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wszib.travelallowance.model.Month;
import pl.wszib.travelallowance.model.MonthName;

import java.util.Optional;

@Repository
public interface MonthDao extends JpaRepository<Month, Long> {

   @Query("select m from Month m where m.monthName = ?1")     //tylko dla repository
   Optional<Month>findByMonthName(MonthName monthName); //serwis

}
