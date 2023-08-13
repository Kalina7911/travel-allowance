package pl.wszib.travelallowance.dao;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.wszib.travelallowance.model.EmployeePreferences;


@SpringBootTest
@Transactional
class EmployeePreferencesDaoTest {

    @Autowired  //wstrzykujemy dao
    EmployeePreferencesDao employeePreferencesDao;



    @BeforeEach
    void setUp() {

          //  public void testSaveEmployeePreferences() {
                // Test dodawania preferencji pracownika do bazy danych
                EmployeePreferences preferences = new EmployeePreferences();
                // Ustawienie preferencji pracownika
                // ...
                employeePreferencesDao.save(preferences);

                // Sprawdzenie, czy zapis się powiódł (np. poprzez pobranie z bazy danych i porównanie z oczekiwanymi wartościami)
                // ...
            }

          //  @Test
         //   public void testGetEmployeePreferencesByDate() {
                // Test pobierania preferencji pracownika na podstawie daty
                // ...
            }

            // Kontynuuj z pozostałymi testami w zależności od swoich wymagań

