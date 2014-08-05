package service;

import model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUserById(Long id);
    User getUserByName(String name);

}
