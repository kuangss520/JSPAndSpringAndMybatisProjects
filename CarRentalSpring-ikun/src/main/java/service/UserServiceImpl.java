package service.impl;

import mapper.TUserInformationMapper;
import model.TUserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

/**
 * 用户管理业务实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserInformationMapper tUserInformationMapper;

    /**
     * 用户注册
     * @param user 用户信息
     * @return 注册成功返回true，失败返回false
     */
    @Override
    public boolean registerUser(TUserInformation user) {
        // 业务逻辑：检查用户ID是否已存在
        if (tUserInformationMapper.selectByPrimaryKey(user.getUserid()) != null) {
            return false; // 用户ID已存在
        }
        return tUserInformationMapper.insertSelective(user) > 0;
    }

    /**
     * 用户登录
     * @param userId 用户ID
     * @param password 密码
     * @return 登录成功返回用户信息，失败返回null
     */
    @Override
    public TUserInformation login(String userId, String password) {
        TUserInformation user = tUserInformationMapper.selectByPrimaryKey(userId);
        if (user != null && user.getPwd().equals(password)) {
            return user; // 用户存在且密码匹配
        }
        return null; // 登录失败
    }

    /**
     * 修改用户信息
     * @param user 用户信息
     * @return 修改成功返回true，失败返回false
     */
    @Override
    public boolean modifyUser(TUserInformation user) {
        // 业务逻辑：确保用户存在
        if (tUserInformationMapper.selectByPrimaryKey(user.getUserid()) == null) {
            return false; // 用户不存在
        }
        return tUserInformationMapper.updateByPrimaryKeySelective(user) > 0;
    }

    /**
     * 删除用户
     * @param userId 用户ID
     * @return 删除成功返回true，失败返回false
     */
    @Override
    public boolean removeUser(String userId) {
        // 业务逻辑：确保用户存在，可以检查是否有相关的订单等
        if (tUserInformationMapper.selectByPrimaryKey(userId) == null) {
            return false; // 用户不存在
        }
        return tUserInformationMapper.deleteByPrimaryKey(userId) > 0;
    }

    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return 匹配的用户信息，如果不存在则返回null
     */
    @Override
    public TUserInformation getUserById(String userId) {
        return tUserInformationMapper.selectByPrimaryKey(userId);
    }

    /**
     * 根据条件查询用户信息（支持用户ID、用户名等模糊查询）
     * @param queryUser 包含查询条件的用户对象
     * @return 匹配的用户信息列表
     */
    @Override
    public List<TUserInformation> searchUsers(TUserInformation queryUser) {
        return tUserInformationMapper.selectAllUserSelective(queryUser);
    }

    /**
     * 查询所有用户信息
     * @return 所有用户信息列表
     */
    @Override
    public List<TUserInformation> getAllUsers() {
        return tUserInformationMapper.selectAllUserSelective(new TUserInformation());
    }
}
