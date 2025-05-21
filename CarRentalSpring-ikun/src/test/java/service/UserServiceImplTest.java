package service;

import model.TUserInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.Assert.*;

/**
 * UserServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的Spring配置文件路径
@Transactional // 开启事务，测试后可以回滚
@Rollback(true) // 测试后回滚数据库修改
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    /**
     * 测试用户注册
     */
    @Test
    public void testRegisterUser() {
        System.out.println("--- 测试 registerUser ---");
        TUserInformation user = new TUserInformation();
        // TODO: 填充用户信息，确保UserId唯一
        user.setUserid("U_SERVICE_NEW_" + System.currentTimeMillis());
        user.setUsername("测试用户");
        user.setPwd("testpwd");
        user.setMail("test_service@example.com");
        user.setMobile("12312312312");

        boolean result = userService.registerUser(user);
        System.out.println("注册结果: " + result);

    }

    /**
     * 测试用户登录
     */
    @Test
    public void testLogin() {
        System.out.println("--- 测试 login ---");
        // TODO: 替换为实际存在的用户ID和密码进行测试
        String userIdToLogin = "U001"; // 示例ID，请根据你的数据库实际情况修改
        String passwordToLogin = "password123"; // 示例密码，请根据你的数据库实际情况修改

        TUserInformation loggedInUser = userService.login(userIdToLogin, passwordToLogin);
        System.out.println("登录结果: " + loggedInUser);

    }

    /**
     * 测试修改用户信息
     */
    @Test
    public void testModifyUser() {
        System.out.println("--- 测试 modifyUser ---");
        TUserInformation user = new TUserInformation();
        // TODO: 替换为实际存在的用户ID进行测试
        user.setUserid("U001"); // 示例ID，请根据你的数据库实际情况修改
        // TODO: 填充需要更新的字段
        user.setMail("updated_service@example.com"); // 更新邮箱
        user.setMobile("99999999999"); // 更新手机号

        boolean result = userService.modifyUser(user);
        System.out.println("修改结果: " + result);

    }

    /**
     * 测试删除用户
     */
    @Test
    public void testRemoveUser() {
        System.out.println("--- 测试 removeUser ---");
        // TODO: 替换为实际存在的用户ID进行测试
        String userIdToDelete = "U002"; // 示例ID，请根据你的数据库实际情况修改
        boolean result = userService.removeUser(userIdToDelete);
        System.out.println("删除结果: " + result);

    }

    /**
     * 测试根据用户ID查询用户信息
     */
    @Test
    public void testGetUserById() {
        System.out.println("--- 测试 getUserById ---");
        // TODO: 替换为实际存在的用户ID进行测试
        String userIdToSelect = "U001"; // 示例ID，请根据你的数据库实际情况修改
        TUserInformation user = userService.getUserById(userIdToSelect);
        System.out.println("查询结果: " + user);

    }

    /**
     * 测试根据条件查询用户信息（支持用户ID、用户名等模糊查询）
     */
    @Test
    public void testSearchUsers() {
        System.out.println("--- 测试 searchUsers ---");
        TUserInformation query = new TUserInformation();

        // TODO: 设置查询条件，例如根据用户名模糊查询
        query.setUsername("张");
        // TODO: 或者根据用户ID查询
        // query.setUserid("U001");

        List<TUserInformation> userList = userService.searchUsers(query);
        System.out.println("查询结果数量: " + userList.size());

    }

    /**
     * 测试查询所有用户信息
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("--- 测试 getAllUsers ---");
        List<TUserInformation> userList = userService.getAllUsers();
        System.out.println("所有用户数量: " + userList.size());

    }
}
