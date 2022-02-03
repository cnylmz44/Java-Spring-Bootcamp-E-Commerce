package spring.demo.business.abstracts;

import spring.demo.core.entities.User;
import spring.demo.core.utilities.results.DataResult;
import spring.demo.core.utilities.results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}