package mapper;

import model.TUssrer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * TUssrerMapperImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class TUssrerMapperImplTest {

    @Autowired
    private TUssrerMapper ussrerMapper;

    @Test
    public void deleteByPrimaryKey() {
        System.out.println("--- 测试 TUssrerMapper.deleteByPrimaryKey ---");
        // TODO: 使用一个存在的账号进行删除测试
        // 注意：删除有外键关联（如 t_adoption, t_health_check）的记录可能会失败
        // 如果你想测试删除，可以先insert一个新用户，然后删除它。
        String userAccountToDelete = "adopter002"; // 示例账号，请根据你的数据库实际情况修改
        System.out.println("尝试删除账号: " + userAccountToDelete);
        int result = ussrerMapper.deleteByPrimaryKey(userAccountToDelete);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void insert() {
        System.out.println("--- 测试 TUssrerMapper.insert ---");
        TUssrer user = new TUssrer();
        // TODO: 填充用户信息，确保 user_account 唯一
        user.setUserAccount("mapper_insert_" + System.currentTimeMillis());
        user.setPassword("insert_pass");
        user.setName("Mapper Insert 用户");
        user.setUserType("领养人");
        user.setPhone("13100000000");
        user.setRegisterTime((new Date())); // 当前时间

        int result = ussrerMapper.insert(user);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void insertSelective() {
        System.out.println("--- 测试 TUssrerMapper.insertSelective ---");
        TUssrer user = new TUssrer();
        // TODO: 填充用户信息，确保 user_account 唯一
        user.setUserAccount("mapper_selective_" + System.currentTimeMillis()%100);
        user.setPassword("selective_pass");
        user.setName("Mapper Selective 用户");
        user.setUserType("工作人员");
        user.setPhone("13200000000");
        // registerTime 不设置，测试选择性插入

        int result = ussrerMapper.insertSelective(user);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println("--- 测试 TUssrerMapper.selectByPrimaryKey ---");
        // TODO: 使用一个存在的账号进行查询测试
        String userAccountToSelect = "worker001"; // 示例账号，请根据你的数据库实际情况修改
        System.out.println("查询账号: " + userAccountToSelect);
        TUssrer user = ussrerMapper.selectByPrimaryKey(userAccountToSelect);
        System.out.println("结果: " + user);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        System.out.println("--- 测试 TUssrerMapper.updateByPrimaryKeySelective ---");
        TUssrer user = new TUssrer();
        // TODO: 使用一个存在的账号进行更新测试
        String userAccountToUpdate = "worker001"; // 示例账号，请根据你的数据库实际情况修改
        System.out.println("尝试更新账号: " + userAccountToUpdate);
        user.setUserAccount(userAccountToUpdate);
        // TODO: 填充需要更新的字段
        user.setPhone("13812345678"); // 更新手机号
        user.setName("张医生 Updated"); // 更新姓名

        int result = ussrerMapper.updateByPrimaryKeySelective(user);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void updateByPrimaryKey() {
        System.out.println("--- 测试 TUssrerMapper.updateByPrimaryKey ---");
        TUssrer user = new TUssrer();
        // TODO: 使用一个存在的账号进行完全更新测试
        String userAccountToUpdate = "adopter001"; // 示例账号，请根据你的数据库实际情况修改
        System.out.println("尝试完全更新账号: " + userAccountToUpdate);
        user.setUserAccount(userAccountToUpdate);
        // TODO: 填充所有字段
        user.setPassword("full_update_pass");
        user.setName("王女士 Revised");
        user.setUserType("领养人");
        user.setPhone("13787654321");
        user.setRegisterTime((new Date())); // 更新注册时间

        int result = ussrerMapper.updateByPrimaryKey(user);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void selectSelective() {
        System.out.println("--- 测试 TUssrerMapper.selectSelective ---");
        TUssrer query = new TUssrer();
        // TODO: 设置查询条件，例如根据用户类型和姓名查询
        query.setUserType("工作人员");
        // query.setName("张医生");

        List<TUssrer> userList = ussrerMapper.selectSelective(query);
        System.out.println("查询结果列表: " + userList);
        System.out.println("找到 " + (userList != null ? userList.size() : 0) + " 条记录.");
    }
}