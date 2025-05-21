package mapper;

import model.TUsersss;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * TUsersssMapperImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class TUsersssMapperImplTest {

    @Autowired
    private TUsersssMapper usersssMapper;

    @Test
    public void deleteByPrimaryKey() {
        System.out.println("--- 测试 TUsersssMapper.deleteByPrimaryKey ---");
        // TODO: 使用一个存在的 account 进行删除测试
        // 注意：删除有外键关联（如 t_application）的记录可能会失败
        // 如果你想测试删除，可以先insert一个新用户，然后删除它。
        String accountToDelete = "some_account_to_delete"; // 示例 account，请根据你的数据库实际情况修改
        System.out.println("尝试删除 account: " + accountToDelete);
        int result = usersssMapper.deleteByPrimaryKey(accountToDelete);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void insert() {
        System.out.println("--- 测试 TUsersssMapper.insert ---");
        TUsersss user = new TUsersss();
        // TODO: 填充用户信息，确保 account 唯一
        user.setStaffId("mapper_insert_" + System.currentTimeMillis() % 1000);
        user.setPassword("insert_pass");
        user.setName("Mapper Insert 用户");
        user.setPhone("12345678901");
        user.setUserType("教师");

        int result = usersssMapper.insert(user);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void insertSelective() {
        System.out.println("--- 测试 TUsersssMapper.insertSelective ---");
        TUsersss user = new TUsersss();
        // TODO: 填充用户信息，确保 account 唯一
        user.setStaffId("mapper_selective_" + System.currentTimeMillis() % 1000);
        user.setPassword("selective_pass");
        user.setName("Mapper Selective 用户");
        user.setUserType("教师");
        // phone 不设置，测试选择性插入
        user.setPhone("12345678901");
        int result = usersssMapper.insertSelective(user);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println("--- 测试 TUsersssMapper.selectByPrimaryKey ---");
        // TODO: 使用一个存在的 account 进行查询测试
        String accountToSelect = "author1"; // 示例 account，请根据你的数据库实际情况修改
        System.out.println("查询 account: " + accountToSelect);
        TUsersss user = usersssMapper.selectByPrimaryKey(accountToSelect);
        System.out.println("结果: " + user);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        System.out.println("--- 测试 TUsersssMapper.updateByPrimaryKeySelective ---");
        TUsersss user = new TUsersss();
        // TODO: 使用一个存在的 account 进行更新测试
        String accountToUpdate = "author1"; // 示例 account，请根据你的数据库实际情况修改
        System.out.println("尝试更新 account: " + accountToUpdate);
        user.setStaffId(accountToUpdate);
        // TODO: 填充需要更新的字段
        user.setPhone("13812345678"); // 更新手机号
        user.setName("更新后的作者1"); // 更新姓名

        int result = usersssMapper.updateByPrimaryKeySelective(user);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void updateByPrimaryKey() {
        System.out.println("--- 测试 TUsersssMapper.updateByPrimaryKey ---");
        TUsersss user = new TUsersss();
        // TODO: 使用一个存在的 account 进行完全更新测试
        String accountToUpdate = "reader1"; // 示例 account，请根据你的数据库实际情况修改
        System.out.println("尝试完全更新 account: " + accountToUpdate);
        user.setStaffId(accountToUpdate);
        // TODO: 填充所有字段
        user.setPassword("full_update_pass_reader");
        user.setName("Reader 1 Updated");
        user.setPhone("13987654321");
        user.setUserType("reader");

        int result = usersssMapper.updateByPrimaryKey(user);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void selectSelective() {
        System.out.println("--- 测试 TUsersssMapper.selectSelective ---");
        TUsersss query = new TUsersss();
        // TODO: 设置查询条件，例如根据用户类型查询
        query.setUserType("reader");

        List<TUsersss> userList = usersssMapper.selectSelective(query);
        System.out.println("查询结果列表: " + userList);
        System.out.println("找到 " + (userList != null ? userList.size() : 0) + " 条记录.");
    }
}