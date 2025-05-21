package service;

import model.TUsersss;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * TUsersssServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class TUsersssServiceImplTest {

    @Autowired
    private TUsersssService usersssService; // 假设Service接口名称是TUsersssService

    @Test
    public void registerUser() {
        System.out.println("--- 测试 TUsersssServiceImpl.registerUser ---");
        TUsersss user = new TUsersss();
        // TODO: 填充用户信息，确保 staffId 唯一
        user.setStaffId("service_register_" + System.currentTimeMillis()%1000); // 根据TUsersssServiceImple.login方法，属性名是staffId
        user.setPassword("service_reg_pass");
        user.setName("Service 注册用户");
        user.setGender("男"); // 根据TUserss实体类，没有gender字段
        user.setPhone("17000000000");
        user.setUserType("教师");
        user.setCollege("测试学院"); // 根据TUserss实体类，没有college字段
        user.setJobType("专职"); // 根据TUserss实体类，没有job_type字段

        // 调用的是 registerUser 方法
        int result = usersssService.registerUser(user);
        System.out.println("注册用户结果 (影响行数): " + result);
    }

    @Test
    public void login() {
        System.out.println("--- 测试 TUsersssServiceImpl.login ---");
        // TODO: 使用存在的用户 staffId 和密码进行登录测试，根据你的数据库实际情况修改
        String staffIdToLogin = "teacher001"; // 示例 staffId (对应t_uusers表的staff_id)
        String passwordToLogin = "teacher123"; // 示例密码
        System.out.println("尝试登录 用户 staffId: " + staffIdToLogin + ", 密码: " + passwordToLogin);

        TUsersss loggedInUser = usersssService.login(staffIdToLogin, passwordToLogin);
        System.out.println("登录结果 (用户对象或null): " + loggedInUser);

        // TODO: 测试登录失败场景
        String wrongPassword = "wrong_password";
        System.out.println("尝试使用错误密码登录 用户 staffId: " + staffIdToLogin + ", 密码: " + wrongPassword);
        TUsersss failedLoginUser = usersssService.login(staffIdToLogin, wrongPassword);
        System.out.println("登录结果 (用户对象或null): " + failedLoginUser);

        // 测试不存在的用户
        String nonexistentStaffId = "nonexistent_user";
        System.out.println("尝试登录 不存在的用户 staffId: " + nonexistentStaffId);
        TUsersss nonexistentUser = usersssService.login(nonexistentStaffId, "some_password");
        System.out.println("登录结果 (用户对象或null): " + nonexistentUser);
    }

    @Test
    public void modifyUser() {
        System.out.println("--- 测试 TUsersssServiceImpl.modifyUser ---");
        TUsersss user = new TUsersss();
        // TODO: 使用一个存在的 account 进行更新测试
        String accountToUpdate = "teacher001"; // 示例 account，请根据你的数据库实际情况修改
        System.out.println("尝试修改用户 account: " + accountToUpdate);
        user.setStaffId(accountToUpdate); // 根据 TUsersssServiceImpl 的 modifyUser 方法，使用 staffId 作为主键
        // TODO: 填充需要更新的字段
        user.setPhone("13888888888"); // 更新手机号
        user.setName("张教授 Updated by Service"); // 更新姓名

        boolean result = usersssService.modifyUser(user);
        System.out.println("修改用户结果 (true表示成功): " + result);
    }

    @Test
    public void removeUser() {
        System.out.println("--- 测试 TUsersssServiceImpl.removeUser ---");
        // TODO: 替换为实际存在的 account 进行删除测试
        // 注意：删除有外键关联（如 t_application）的记录可能会失败
        // 如果你想测试删除，可以先registerUser一个新用户，然后删除它。
        String accountToDelete = "teacher003"; // 示例 account，请根据你的数据库实际情况修改
        System.out.println("尝试删除用户 account: " + accountToDelete);

        boolean result = usersssService.removeUser(accountToDelete);
        System.out.println("删除用户结果 (true表示成功): " + result);
    }

    // Service 接口中没有 getUser 或 getUserByAccount 方法，删除对应的测试方法
    // 如果你的 Service 接口/实现中实际上有这个方法，请根据需要自行添加测试

    // Service 接口中没有 getUsersByType 或 selectSelective 相关方法，删除对应的测试方法
    // 如果你的 Service 接口/实现中实际上有这些方法，请根据需要自行添加测试
}