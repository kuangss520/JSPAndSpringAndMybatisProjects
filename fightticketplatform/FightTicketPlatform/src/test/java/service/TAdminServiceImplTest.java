package service;

import model.TAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * TAdminServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class TAdminServiceImplTest {

    @Autowired
    private TAdminService tAdminService;

    @Test
    public void adminLogin() {
        System.out.println("--- 测试 adminLogin (TAdminService) ---");
        // TODO: 使用存在的管理员账号和密码进行登录测试，根据你的数据库实际情况修改
        String adminAccountToLogin = "admin1"; // 示例账号
        String passwordToLogin = "admin_pass1"; // 示例密码
        System.out.println("尝试登录 管理员账号: " + adminAccountToLogin + ", 密码: " + passwordToLogin);

        TAdmin loggedInAdmin = tAdminService.adminLogin(adminAccountToLogin, passwordToLogin);
        System.out.println("登录结果 (管理员对象或null): " + loggedInAdmin);

        // TODO: 测试登录失败场景
        String wrongPassword = "wrong_password";
        System.out.println("尝试使用错误密码登录 管理员账号: " + adminAccountToLogin + ", 密码: " + wrongPassword);
        TAdmin failedLoginAdmin = tAdminService.adminLogin(adminAccountToLogin, wrongPassword);
        System.out.println("登录结果 (管理员对象或null): " + failedLoginAdmin);

        // 测试不存在的管理员
        String nonexistentAccount = "nonexistent_admin";
        System.out.println("尝试登录 不存在的管理员账号: " + nonexistentAccount);
        TAdmin nonexistentAdmin = tAdminService.adminLogin(nonexistentAccount, "some_password");
        System.out.println("登录结果 (管理员对象或null): " + nonexistentAdmin);
    }

    // TAdminService 接口根据你提供的实现类，目前只有 login 方法，没有增删改查方法。
    // 如果你后续在 Service 中添加了这些方法，可以参照其他 Service Test 添加相应的测试方法。
}