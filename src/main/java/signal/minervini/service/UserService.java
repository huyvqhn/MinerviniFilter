package signal.minervini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import signal.minervini.entity.UserEntity;
import signal.minervini.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean addUser(String userName, String password, String role, boolean active) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setPassword(password);
        userEntity.setRole(role);
        userEntity.setActive(active);

        try {
            userRepository.saveAndFlush(userEntity);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteUser(String userName) {
        try {
            userRepository.deleteByUserName(userName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}


