package mapper;

import model.TUserss;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional // 添加事务管理，测试后自动回滚数据
public class TUserssMapperImplTest {

    @Autowired
    private TUserssMapper userssMapper;

    @Test
    public void deleteByPrimaryKey() {
        System.out.println("--- 测试 deleteByPrimaryKey (TUserss) ---");
        // 插入一个测试用户用于删除
        TUserss userToDelete = new TUserss();
        String accountToDelete = "test_delete_" + System.currentTimeMillis();
        userToDelete.setAccount(accountToDelete);
        userToDelete.setPassword("deletePass");
        userToDelete.setName("待删除用户");
        userToDelete.setUserType("reader");
        int insertResult = userssMapper.insert(userToDelete);
        System.out.println("插入待删除用户结果 (影响行数): " + insertResult);
        System.out.println("插入待删除用户账号: " + accountToDelete);

        int deleteResult = userssMapper.deleteByPrimaryKey(accountToDelete);
        System.out.println("删除结果 (影响行数): " + deleteResult);

        TUserss deletedUser = userssMapper.selectByPrimaryKey(accountToDelete);
        System.out.println("查询删除后的用户: " + deletedUser);
    }

    @Test
    public void insert() {
        System.out.println("--- 测试 insert (TUserss) ---");
        TUserss user = new TUserss();
        user.setAccount("test_insert_" + System.currentTimeMillis());
        user.setPassword("testPass");
        user.setName("测试用户 Insert");
        user.setPhone("11111111111");
        user.setUserType("author");

        int result = userssMapper.insert(user);
        System.out.println("插入结果 (影响行数): " + result);

        TUserss insertedUser = userssMapper.selectByPrimaryKey(user.getAccount());
        System.out.println("查询插入的用户: " + insertedUser);
    }

    @Test
    public void insertSelective() {
        System.out.println("--- 测试 insertSelective (TUserss) ---");
        TUserss user = new TUserss();
        user.setAccount("test_selective_" + System.currentTimeMillis());
        user.setPassword("selectivePass");
        user.setName("测试用户 Selective");
        user.setUserType("reader");
        // phone 不设置

        int result = userssMapper.insertSelective(user);
        System.out.println("选择性插入结果 (影响行数): " + result);

        TUserss insertedUser = userssMapper.selectByPrimaryKey(user.getAccount());
        System.out.println("查询选择性插入的用户: " + insertedUser);
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println("--- 测试 selectByPrimaryKey (TUserss) ---");
        // 使用一个存在的用户账号进行查询测试，根据初始数据修改
        String accountToSelect = "author1";
        System.out.println("查询用户账号: " + accountToSelect);
        TUserss user = userssMapper.selectByPrimaryKey(accountToSelect);
        System.out.println("查询结果: " + user);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        System.out.println("--- 测试 updateByPrimaryKeySelective (TUserss) ---");
        // 使用一个存在的用户账号进行更新测试，根据初始数据修改
        String accountToUpdate = "reader1";
        System.out.println("更新用户账号 (选择性): " + accountToUpdate);

        TUserss user = new TUserss();
        user.setAccount(accountToUpdate);
        user.setPhone("99999999999"); // 更新手机号

        int result = userssMapper.updateByPrimaryKeySelective(user);
        System.out.println("更新结果 (影响行数): " + result);

        TUserss updatedUser = userssMapper.selectByPrimaryKey(accountToUpdate);
        System.out.println("查询更新后的用户: " + updatedUser);
    }

    @Test
    public void updateByPrimaryKey() {
        System.out.println("--- 测试 updateByPrimaryKey (TUserss) ---");
         // 插入一个测试用户用于更新
        TUserss userToUpdate = new TUserss();
        String accountToUpdate = "test_update_" + System.currentTimeMillis();
        userToUpdate.setAccount(accountToUpdate);
        userToUpdate.setPassword("originalPass");
        userToUpdate.setName("原始用户");
        userToUpdate.setPhone("00000000000");
        userToUpdate.setUserType("reader");
        int insertResult = userssMapper.insert(userToUpdate);
        System.out.println("插入待更新用户结果 (影响行数): " + insertResult);
        System.out.println("插入待更新用户账号: " + accountToUpdate);


        TUserss user = new TUserss();
        user.setAccount(accountToUpdate);
        user.setPassword("updatedPass");
        user.setName("更新后用户");
        user.setPhone("88888888888");
        user.setUserType("author"); // 更改用户类型

        int result = userssMapper.updateByPrimaryKey(user);
        System.out.println("完全更新结果 (影响行数): " + result);

        TUserss updatedUser = userssMapper.selectByPrimaryKey(accountToUpdate);
        System.out.println("查询完全更新后的用户: " + updatedUser);
    }

    @Test
    public void selectSelective() {
        System.out.println("--- 测试 selectSelective (TUserss) ---");
        TUserss query = new TUserss();
        query.setUserType("author"); // 根据用户类型查询

        List<TUserss> userList = userssMapper.selectSelective(query);
        System.out.println("查询结果列表: " + userList);
        System.out.println("找到 " + (userList != null ? userList.size() : 0) + " 条记录.");
    }
}