package spring.demo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.demo.business.abstracts.UserService;
import spring.demo.core.dataAccess.UserDao;
import spring.demo.core.entities.User;
import spring.demo.core.utilities.results.DataResult;
import spring.demo.core.utilities.results.Result;
import spring.demo.core.utilities.results.SuccessDataResult;
import spring.demo.core.utilities.results.SuccessResult;


@Service
public class UserManager implements UserService{

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email)
                ,"Kullanıcı bulundu");
    }

}