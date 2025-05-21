package service;

import model.TUserInformation;

import java.util.List;

/**
 * 用户管理业务接口
 */
public interface UserService {

    /**
     * 用户注册
     * @param user 用户信息
     * @return 注册成功返回true，失败返回false
     */
    boolean registerUser(TUserInformation user);

    /**
     * 用户登录
     * @param userId 用户ID
     * @param password 密码
     * @return 登录成功返回用户信息，失败返回null
     */
    TUserInformation login(String userId, String password);

    /**
     * 修改用户信息
     * @param user 用户信息
     * @return 修改成功返回true，失败返回false
     */
    boolean modifyUser(TUserInformation user);

    /**
     * 删除用户
     * @param userId 用户ID
     * @return 删除成功返回true，失败返回false
     */
    boolean removeUser(String userId);

    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return 匹配的用户信息，如果不存在则返回null
     */
    TUserInformation getUserById(String userId);

    /**
     * 根据条件查询用户信息（支持用户ID、用户名等模糊查询）
     * @param queryUser 包含查询条件的用户对象
     * @return 匹配的用户信息列表
     */
    List<TUserInformation> searchUsers(TUserInformation queryUser);

    /**
     * 查询所有用户信息
     * @return 所有用户信息列表
     */
    List<TUserInformation> getAllUsers();
}
