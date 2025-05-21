package service;

import model.TUsersss;

public interface TUsersssService {
    /**
     * 用户注册（添加管理员）
     * @param record 管理员信息
     * @return 成功返回1（影响行数），失败返回0
     */
    int registerUser(TUsersss record);

    /**
     * 用户登录
     * @param staffId 管理员账号（主键）
     * @param password 密码
     * @return 登录成功返回用户对象，失败返回null
     */
    TUsersss login(String staffId, String password);

    /**
     * 修改用户信息
     * @param record 管理员信息（需包含主键staffId）
     * @return 成功返回true，失败返回false
     */
    boolean modifyUser(TUsersss record);

    /**
     * 删除用户
     * @param staffId 管理员账号（主键）
     * @return 成功返回true，失败返回false
     */
    boolean removeUser(String staffId);
}