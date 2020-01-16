package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        //根据用户名查询对象
        User user1 = userDao.findByUsername(user.getUsername());
        //判断是否为null
        if (user1 != null){
            return false;
        }
        //保存用户信息
        userDao.save(user);
        return true;
    }
}
