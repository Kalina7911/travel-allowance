package pl.wszib.travelallowance.services;

import org.springframework.stereotype.Service;
import pl.wszib.travelallowance.dao.UserDao;
import pl.wszib.travelallowance.exceptions.UserAlreadyExistException;
import pl.wszib.travelallowance.model.User;
import pl.wszib.travelallowance.model.UserModel;


@Service
public class UserService {

    private final UserDao userDao;


    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public User findByIndex(Integer index) {
        return userDao.findByIndex(index).get();
    }

    public User saveUser(UserModel userModel) {

        if (userDao.existsByIndex(userModel.getIndex())) {
            throw new UserAlreadyExistException("User already exists");

        }

        User user = new User();
        user.setIndex(userModel.getIndex());
        user.setName(userModel.getName());
        user.setPassword(userModel.getPassword());
        return userDao.save(user);
    }


}
