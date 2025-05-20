package service;

import model.TUserss;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@Rollback(true) // 测试完成后回滚事务
public class TUserssServiceImplTest {

    @Autowired
    private TUserssService tUserssService;

    @Test
    public void testAddUser() {
        System.out.println("--- 测试 addUser (TUserssService) ---");
        TUserss user = new TUserss();
        user.setAccount("test_service_add_" + System.currentTimeMillis());
        user.setPassword("service_pass");
        user.setName("Service测试用户");
        user.setPhone("12345678901");
        user.setUserType("reader");

        int result = tUserssService.addUser(user);
        System.out.println("添加用户结果 (影响行数): " + result);
    }

    @Test
    public void testModifyUser() {
        System.out.println("--- 测试 modifyUser (TUserssService) ---");
        TUserss user = new TUserss();
        // 使用一个存在的用户账号进行更新测试，根据初始数据修改
        String accountToUpdate = "author1"; // 假设 'author1' 存在
        System.out.println("尝试修改用户账号: " + accountToUpdate);
        user.setAccount(accountToUpdate);
        user.setPhone("98765432109"); // 更新手机号
        user.setName("更新后的张三"); // 更新姓名

        boolean result = tUserssService.modifyUser(user);
        System.out.println("修改用户结果 (true表示成功): " + result);
    }

    @Test
    public void testRemoveUser() {
        System.out.println("--- 测试 removeUser (TUserssService) ---");
        // 插入一个测试用户用于删除
        TUserss userToDelete = new TUserss();
        String accountToDelete = "test_service_delete_" + System.currentTimeMillis();
        userToDelete.setAccount(accountToDelete);
        userToDelete.setPassword("delete_pass");
        userToDelete.setName("待删除用户");
        userToDelete.setUserType("reader");
        tUserssService.addUser(userToDelete); // 先添加用户
        System.out.println("插入待删除用户账号: " + accountToDelete);

        System.out.println("尝试删除用户账号: " + accountToDelete);
        boolean result = tUserssService.removeUser(accountToDelete);
        System.out.println("删除用户结果 (true表示成功): " + result);
    }

    @Test
    public void testGetUserByAccount() {
        System.out.println("--- 测试 getUserByAccount (TUserssService) ---");
        // 使用一个存在的用户账号进行查询测试，根据初始数据修改
        String accountToSelect = "reader1";
        System.out.println("查询用户账号: " + accountToSelect);

        TUserss user = tUserssService.getUserByAccount(accountToSelect);
        System.out.println("查询结果: " + user);
    }

    @Test
    public void testUserLogin_success() {
        System.out.println("--- 测试 userLogin (成功) (TUserssService) ---");
        // 使用存在的用户账号和密码进行登录测试，根据初始数据修改
        String accountToLogin = "author2";
        String passwordToLogin = "pass456";
        System.out.println("尝试登录 用户账号: " + accountToLogin + ", 密码: " + passwordToLogin);

        TUserss loggedInUser = tUserssService.userLogin(accountToLogin, passwordToLogin);
        System.out.println("登录结果 (用户对象或null): " + loggedInUser);
    }

    @Test
    public void testUserLogin_failure() {
        System.out.println("--- 测试 userLogin (失败) (TUserssService) ---");
        // 使用不存在的用户账号或错误的密码进行登录测试
        String accountToLogin = "nonexistent_user";
        String passwordToLogin = "wrong_password";
        System.out.println("尝试登录 用户账号: " + accountToLogin + ", 密码: " + passwordToLogin);

        TUserss loggedInUser = tUserssService.userLogin(accountToLogin, passwordToLogin);
        System.out.println("登录结果 (用户对象或null): " + loggedInUser);

        // 尝试使用存在的账号但错误密码
        accountToLogin = "reader2";
        passwordToLogin = "wrong_password";
        System.out.println("尝试登录 用户账号: " + accountToLogin + ", 密码: " + passwordToLogin);

        loggedInUser = tUserssService.userLogin(accountToLogin, passwordToLogin);
        System.out.println("登录结果 (用户对象或null): " + loggedInUser);
    }
}