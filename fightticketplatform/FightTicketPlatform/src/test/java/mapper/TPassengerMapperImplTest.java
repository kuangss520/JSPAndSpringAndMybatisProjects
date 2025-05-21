package mapper;

import model.TPassenger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional // 开启事务
@Rollback(true) // 测试后回滚事务
public class TPassengerMapperImplTest {

    @Autowired
    private TPassengerMapper passengerMapper; // Assuming you have a TPassengerMapper interface

    @Test
    public void testInsertSelective() {
        System.out.println("--- 测试 insertSelective ---");
        TPassenger newPassenger = new TPassenger();
        newPassenger.setIdCard("999999199912319999"); // 使用一个唯一的身份证号
        newPassenger.setName("测试乘客");
        newPassenger.setPassword("testpass");
        newPassenger.setGender("男");
        newPassenger.setBirthDate(new Date()); // 可以使用当前日期或指定日期
        newPassenger.setPhone("19988887777");
        newPassenger.setContactName("测试联系人");
        newPassenger.setContactPhone("19988886666");

        int result = passengerMapper.insertSelective(newPassenger);
        System.out.println("插入结果 (影响行数): " + result);
        assertTrue("插入操作应该影响一行", result > 0);

        // 可以选择查询回来验证插入是否成功
        TPassenger insertedPassenger = passengerMapper.selectByPrimaryKey(newPassenger.getIdCard());
        assertNotNull("插入的乘客记录应该存在", insertedPassenger);
        assertEquals("插入的乘客姓名应该一致", "测试乘客", insertedPassenger.getName());
        // 验证其他字段...
    }

    @Test
    public void testDeleteByPrimaryKey() {
        System.out.println("--- 测试 deleteByPrimaryKey ---");
        // 使用一个存在的乘客身份证号码进行删除测试，根据初始数据修改
        // 注意：删除有外键关联（如 t_ticket）的乘客记录可能会失败，除非先删除关联的机票
        String passengerIdCardToDelete = "130101199203031236"; // 孙七的身份证，他有购买机票的记录
        System.out.println("删除乘客身份证: " + passengerIdCardToDelete);

        // 为了避免外键约束问题，可以先删除关联的机票记录（如果mapper提供了相应方法）
        // 或者在测试数据中选择一个没有关联机票的乘客进行删除，或者修改关联机票的id_card为null
        // 这里我们假设测试环境允许删除或已处理外键问题，直接尝试删除乘客
        // 在实际应用中，通常不直接删除有外键关联的数据，而是逻辑删除或解除关联

        // 先查询确保记录存在
        TPassenger existingPassenger = passengerMapper.selectByPrimaryKey(passengerIdCardToDelete);
        assertNotNull("待删除的乘客记录应该存在", existingPassenger);


        int result = passengerMapper.deleteByPrimaryKey(passengerIdCardToDelete);
        System.out.println("删除结果 (影响行数): " + result);
        // 注意：如果存在外键约束并且没有级联删除，这里可能会返回0或抛异常
        // 如果已处理外键问题（例如手动删除关联机票或选择无关联乘客），则期望 result > 0
        assertTrue("删除操作应该影响一行", result > 0); // 根据实际情况调整断言

        // 再次查询确保记录已被删除
        TPassenger deletedPassenger = passengerMapper.selectByPrimaryKey(passengerIdCardToDelete);
        assertNull("乘客记录应该已被删除", deletedPassenger);
    }

    @Test
    public void testSelectByPrimaryKey() {
        System.out.println("--- 测试 selectByPrimaryKey ---");
        // 使用一个存在的乘客身份证号码进行查询测试，根据初始数据修改
        String passengerIdCardToSelect = "110101199001011234"; // 张三的身份证
        System.out.println("查询乘客身份证: " + passengerIdCardToSelect);
        TPassenger passenger = passengerMapper.selectByPrimaryKey(passengerIdCardToSelect);
        System.out.println("查询结果: " + passenger);

        assertNotNull("查询结果不应为 null", passenger);
        assertEquals("查询到的身份证号码应该与查询条件一致", passengerIdCardToSelect, passenger.getIdCard());
        // 可以根据初始数据进一步断言其他字段的值
        assertEquals("姓名应该为张三", "张三", passenger.getName());
        assertEquals("手机号码应该为13800138001", "13800138001", passenger.getPhone());
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        System.out.println("--- 测试 updateByPrimaryKeySelective ---");
        TPassenger passenger = new TPassenger();
        // 使用一个存在的乘客身份证号码进行更新测试，根据初始数据修改
        String passengerIdCardToUpdate = "120101199102021235"; // 王五的身份证
        passenger.setIdCard(passengerIdCardToUpdate);
        passenger.setPhone("13911112222"); // 修改手机号码
        passenger.setContactName("新的联系人"); // 修改联系人姓名

        // 先查询确保记录存在
        TPassenger existingPassenger = passengerMapper.selectByPrimaryKey(passengerIdCardToUpdate);
        assertNotNull("待更新的乘客记录应该存在", existingPassenger);


        int result = passengerMapper.updateByPrimaryKeySelective(passenger);
        System.out.println("更新结果 (影响行数): " + result);
        assertTrue("更新操作应该影响一行", result > 0);

        // 查询回来验证更新是否成功
        TPassenger updatedPassenger = passengerMapper.selectByPrimaryKey(passengerIdCardToUpdate);
        assertNotNull("更新后的乘客记录应该存在", updatedPassenger);
        assertEquals("更新后的手机号码应该正确", "13911112222", updatedPassenger.getPhone());
        assertEquals("更新后的联系人姓名应该正确", "新的联系人", updatedPassenger.getContactName());
        // 验证其他字段未被改变
        assertEquals("姓名不应改变", existingPassenger.getName(), updatedPassenger.getName());
        assertEquals("密码不应改变", existingPassenger.getPassword(), updatedPassenger.getPassword());
    }

    @Test
    public void testSelectBySelective() {
        System.out.println("--- 测试 selectBySelective ---");
        // 测试根据性别查询乘客
        TPassenger query = new TPassenger();
        query.setGender("男");

        List<TPassenger> passengerList = passengerMapper.selectSelective(query);
        System.out.println("查询结果列表大小: " + passengerList.size());

        assertNotNull("查询结果列表不应为 null", passengerList);
        assertTrue("查询结果列表应该包含至少一个男性乘客", passengerList.size() > 0);

        // 验证查询结果中的乘客性别是否为男
        for (TPassenger passenger : passengerList) {
            assertEquals("查询到的乘客性别应该为男", "男", passenger.getGender());
        }

        // 测试根据姓名模糊查询乘客
        query = new TPassenger();
        query.setName("张"); // 查询姓名包含"张"的乘客

        passengerList = passengerMapper.selectSelective(query);
        System.out.println("根据姓名模糊查询结果列表大小: " + passengerList.size());

        assertNotNull("模糊查询结果列表不应为 null", passengerList);
        assertTrue("模糊查询结果列表应该包含姓名包含'张'的乘客", passengerList.size() > 0);

        // 验证查询结果中的乘客姓名是否包含"张"
        for (TPassenger passenger : passengerList) {
            assertTrue("查询到的乘客姓名应该包含'张'", passenger.getName().contains("张"));
        }
    }
}