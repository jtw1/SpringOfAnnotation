package exercise.service;

import exercise.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @date 2021/3/8 0008-19:52
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    // 使用事务控制，方法出现异常时，所有操作都回滚
    @Transactional
    public void insertUser(){
        userDao.insert();
        System.out.println("插入完成");
        int i=10/0;
    }
}
