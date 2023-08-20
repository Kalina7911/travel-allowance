package pl.wszib.travelallowance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wszib.travelallowance.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByName(String name);

    User findByIndex(Integer index);


    @Query("select (count(u) > 0) from User u where u.index = ?1")
    boolean existsByIndex(Integer index);
}
