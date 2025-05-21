package service;

import model.TPassenger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * TPassengerServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class TPassengerServiceImplTest {

    @Autowired
    private TPassengerService tPassengerService;

    @Test
    public void addPassenger() {
        System.out.println("--- 测试 addPassenger (TPassengerService) ---");
        TPassenger passenger = new TPassenger();
        // TODO: 填充乘客信息，确保 idCard 唯一
        passenger.setIdCard("TEST_ID_" + System.currentTimeMillis());
        passenger.setName("测试乘客");
        passenger.setPassword("passenger_pass");
        passenger.setPassword("13800000000");

        int result = tPassengerService.addPassenger(passenger);
        System.out.println("添加乘客结果 (影响行数): " + result);
    }

    @Test
    public void modifyPassenger() {
        System.out.println("--- 测试 modifyPassenger (TPassengerService) ---");
        TPassenger passenger = new TPassenger();
        // TODO: 使用一个存在的乘客身份证号进行更新测试
        String idCardToUpdate = "existing_id_card"; // 示例身份证号，请根据你的数据库实际情况修改
        System.out.println("尝试修改乘客身份证号: " + idCardToUpdate);
        passenger.setIdCard(idCardToUpdate);
        // TODO: 填充需要更新的字段
        passenger.setPhone("13911111111"); // 更新手机号
        passenger.setPassword("updated_pass"); // 更新密码

        boolean result = tPassengerService.modifyPassenger(passenger);
        System.out.println("修改乘客结果 (true表示成功): " + result);
    }

    @Test
    public void removePassenger() {
        System.out.println("--- 测试 removePassenger (TPassengerService) ---");
         // TODO: 替换为实际存在的乘客身份证号进行删除测试
        // 注意：删除有外键关联（如 tickets）的记录可能会失败，除非设置了级联删除
        // 如果你想测试删除，可以先addPassenger一个新乘客，然后删除它。
        String idCardToDelete = "id_card_to_delete"; // 示例身份证号，请根据你的数据库实际情况修改
        System.out.println("尝试删除乘客身份证号: " + idCardToDelete);

        boolean result = tPassengerService.removePassenger(idCardToDelete);
        System.out.println("删除乘客结果 (true表示成功): " + result);
    }

    @Test
    public void getPassengerByIdCard() {
        System.out.println("--- 测试 getPassengerByIdCard (TPassengerService) ---");
        // TODO: 使用一个存在的乘客身份证号进行查询测试
        String idCardToSelect = "existing_id_card"; // 示例身份证号，请根据你的数据库实际情况修改
        System.out.println("查询乘客身份证号: " + idCardToSelect);

        TPassenger passenger = tPassengerService.getPassengerByIdCard(idCardToSelect);
        System.out.println("查询结果: " + passenger);
    }

    @Test
    public void passengerLogin() {
        System.out.println("--- 测试 passengerLogin (TPassengerService) ---");
        // TODO: 使用存在的乘客身份证号和密码进行登录测试
        String idCardToLogin = "existing_id_card"; // 示例身份证号
        String passwordToLogin = "passenger_pass"; // 示例密码
        System.out.println("尝试乘客登录 身份证号: " + idCardToLogin + ", 密码: " + passwordToLogin);

        TPassenger loggedInPassenger = tPassengerService.passengerLogin(idCardToLogin, passwordToLogin);
        System.out.println("登录结果 (乘客对象或null): " + loggedInPassenger);

        // TODO: 测试登录失败场景
        String wrongPassword = "wrong_password";
        System.out.println("尝试使用错误密码登录 身份证号: " + idCardToLogin + ", 密码: " + wrongPassword);
        TPassenger failedLoginPassenger = tPassengerService.passengerLogin(idCardToLogin, wrongPassword);
        System.out.println("登录结果 (乘客对象或null): " + failedLoginPassenger);

        // 测试不存在的乘客
        String nonexistentIdCard = "nonexistent_id_card";
        System.out.println("尝试登录 不存在的乘客身份证号: " + nonexistentIdCard);
        TPassenger nonexistentPassenger = tPassengerService.passengerLogin(nonexistentIdCard, "some_password");
        System.out.println("登录结果 (乘客对象或null): " + nonexistentPassenger);
    }
}