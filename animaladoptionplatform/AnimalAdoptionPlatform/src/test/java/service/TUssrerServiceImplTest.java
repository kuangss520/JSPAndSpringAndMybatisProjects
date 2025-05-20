package service;

import model.TUssrer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * TUssrerServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class TUssrerServiceImplTest {

    @Autowired
    private TUssrerService ussrerService; // 假设Service接口名称是TUssrerService

    @Test
    public void addUser() {
        System.out.println("--- 测试 TUssrerServiceImpl.addUser ---");
        TUssrer user = new TUssrer();
        // TODO: 填充用户信息，确保 userAccount 唯一
        user.setUserAccount("service_add_" + System.currentTimeMillis());
        user.setPassword("service_pass");
        user.setName("Service 添加用户");
        user.setUserType("工作人员");
        user.setPhone("16000000000");
        user.setRegisterTime(new Date()); // 当前时间

        int result = ussrerService.addUser(user);
        System.out.println("添加用户结果 (影响行数): " + result);
    }

    @Test
    public void modifyUser() {
        System.out.println("--- 测试 TUssrerServiceImpl.modifyUser ---");
        TUssrer user = new TUssrer();
        // TODO: 使用一个存在的 userAccount 进行更新测试
        String userAccountToUpdate = "worker001"; // 示例账号，请根据你的数据库实际情况修改
        System.out.println("尝试修改用户账号: " + userAccountToUpdate);
        user.setUserAccount(userAccountToUpdate);
        // TODO: 填充需要更新的字段
        user.setPhone("13888888888"); // 更新手机号
        user.setName("张医生 Updated by Service"); // 更新姓名

        boolean result = ussrerService.modifyUser(user);
        System.out.println("修改用户结果 (true表示成功): " + result);
    }

    @Test
    public void removeUser() {
        System.out.println("--- 测试 TUssrerServiceImpl.removeUser ---");
        // TODO: 替换为实际存在的 userAccount 进行删除测试
        // 注意：删除有外键关联（如 t_adoption, t_health_check）的记录可能会失败
        // 如果你想测试删除，可以先addUser一个新用户，然后删除它。
        String userAccountToDelete = "adopter002"; // 示例账号，请根据你的数据库实际情况修改
        System.out.println("尝试删除用户账号: " + userAccountToDelete);

        boolean result = ussrerService.removeUser(userAccountToDelete);
        System.out.println("删除用户结果 (true表示成功): " + result);
    }

    @Test
    public void getUserByAccount() {
        System.out.println("--- 测试 TUssrerServiceImpl.getUserByAccount ---");
        // TODO: 使用一个存在的 userAccount 进行查询测试
        String userAccountToSelect = "adopter001"; // 示例账号，请根据你的数据库实际情况修改
        System.out.println("查询用户账号: " + userAccountToSelect);

        TUssrer user = ussrerService.getUserByAccount(userAccountToSelect);
        System.out.println("查询结果: " + user);
    }

    @Test
    public void login() {
        System.out.println("--- 测试 TUssrerServiceImpl.login ---");
        // TODO: 使用存在的用户 account 和密码进行登录测试，根据你的数据库实际情况修改
        String userAccountToLogin = "worker002"; // 示例账号
        String passwordToLogin = "worker456"; // 示例密码
        System.out.println("尝试登录 用户账号: " + userAccountToLogin + ", 密码: " + passwordToLogin);

        TUssrer loggedInUser = ussrerService.login(userAccountToLogin, passwordToLogin);
        System.out.println("登录结果 (用户对象或null): " + loggedInUser);

        // TODO: 测试登录失败场景
        String wrongPassword = "wrong_password";
        System.out.println("尝试使用错误密码登录 用户账号: " + userAccountToLogin + ", 密码: " + wrongPassword);
        TUssrer failedLoginUser = ussrerService.login(userAccountToLogin, wrongPassword);
        System.out.println("登录结果 (用户对象或null): " + failedLoginUser);

        // 测试不存在的用户
        String nonexistentAccount = "nonexistent_user";
        System.out.println("尝试登录 不存在的用户账号: " + nonexistentAccount);
        TUssrer nonexistentUser = ussrerService.login(nonexistentAccount, "some_password");
        System.out.println("登录结果 (用户对象或null): " + nonexistentUser);
    }
}