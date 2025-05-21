package service;

import model.TAdmin;

/**
 * 管理员业务接口
 */
public interface TAdminService {

    /**
     * 管理员登录
     * @param adminAccount 管理员账号
     * @param password 密码
     * @return 登录成功返回管理员对象，失败返回 null
     */
    TAdmin adminLogin(String adminAccount, String password);
}