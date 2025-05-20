package service;

import model.TUserss;

/**
 * 用户管理业务接口
 */
public interface TUserssService {

    /**
     * 添加用户
     * @param record 用户信息对象
     * @return 成功返回新用户的主键值（或影响行数），失败返回 0
     */
    int addUser(TUserss record);

    /**
     * 修改用户信息
     * @param record 用户信息对象（需包含主键 account）
     * @return 成功返回 true，失败返回 false
     */
    boolean modifyUser(TUserss record);

    /**
     * 删除用户
     * @param account 用户账号（主键）
     * @return 成功返回 true，失败返回 false
     */
    boolean removeUser(String account);

    /**
     * 根据账号查询用户
     * @param account 用户账号
     * @return 用户信息对象，不存在返回 null
     */
    TUserss getUserByAccount(String account);

    /**
     * 用户登录
     * @param account 账号
     * @param password 密码
     * @return 登录成功返回用户对象，失败返回 null
     */
    TUserss userLogin(String account, String password);
}