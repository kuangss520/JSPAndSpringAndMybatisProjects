package mapper;

import model.TAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional // 开启事务
@Rollback(true) // 测试后回滚事务
public class TAdminMapperImplTest {

    @Autowired
    private TAdminMapper adminMapper; // Assuming you have a TAdminMapper interface

    @Test
    public void testInsertSelective() {
        System.out.println("--- 测试 insertSelective ---");
        TAdmin newAdmin = new TAdmin();
        newAdmin.setAdminAccount("testadmin" + System.currentTimeMillis()%1000); // 使用时间戳确保唯一性
        newAdmin.setPassword("testpass");
        newAdmin.setNickname("测试管理员");
        newAdmin.setPhone("18812345678");

        int result = adminMapper.insertSelective(newAdmin);
        System.out.println("插入结果 (影响行数): " + result);
        assertTrue("插入操作应该影响一行", result > 0);

        // 可以选择查询回来验证插入是否成功
        TAdmin insertedAdmin = adminMapper.selectByPrimaryKey(newAdmin.getAdminAccount());
        assertNotNull("插入的管理员记录应该存在", insertedAdmin);
        assertEquals("插入的管理员昵称应该一致", "测试管理员", insertedAdmin.getNickname());
        // 验证其他字段...
    }

    @Test
    public void testDeleteByPrimaryKey() {
        System.out.println("--- 测试 deleteByPrimaryKey ---");
        // 使用一个存在的管理员账号进行删除测试，根据初始数据修改
        String adminAccountToDelete = "admin002"; // 例如：管理员B
        System.out.println("删除管理员账号: " + adminAccountToDelete);

        // 先查询确保记录存在
        TAdmin existingAdmin = adminMapper.selectByPrimaryKey(adminAccountToDelete);
        assertNotNull("待删除的管理员记录应该存在", existingAdmin);

        int result = adminMapper.deleteByPrimaryKey(adminAccountToDelete);
        System.out.println("删除结果 (影响行数): " + result);
        assertTrue("删除操作应该影响一行", result > 0);

        // 再次查询确保记录已被删除
        TAdmin deletedAdmin = adminMapper.selectByPrimaryKey(adminAccountToDelete);
        assertNull("管理员记录应该已被删除", deletedAdmin);
    }

    @Test
    public void testSelectByPrimaryKey() {
        System.out.println("--- 测试 selectByPrimaryKey ---");
        // 使用一个存在的管理员账号进行查询测试，根据初始数据修改
        String adminAccountToSelect = "admin001"; // 例如：管理员A
        System.out.println("查询管理员账号: " + adminAccountToSelect);
        TAdmin admin = adminMapper.selectByPrimaryKey(adminAccountToSelect);
        System.out.println("查询结果: " + admin);

        assertNotNull("查询结果不应为 null", admin);
        assertEquals("查询到的管理员账号应该与查询条件一致", adminAccountToSelect, admin.getAdminAccount());
        // 可以根据初始数据进一步断言其他字段的值
        assertEquals("昵称应该为管理员A", "管理员A", admin.getNickname());
        assertEquals("手机号码应该为13500135001", "13500135001", admin.getPhone());
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        System.out.println("--- 测试 updateByPrimaryKeySelective ---");
        TAdmin admin = new TAdmin();
        // 使用一个存在的管理员账号进行更新测试，根据初始数据修改
        String adminAccountToUpdate = "admin001"; // 例如：管理员A
        admin.setAdminAccount(adminAccountToUpdate);
        admin.setNickname("超级管理员"); // 修改昵称
        admin.setPhone("13599998888"); // 修改手机号码

        // 先查询确保记录存在
        TAdmin existingAdmin = adminMapper.selectByPrimaryKey(adminAccountToUpdate);
        assertNotNull("待更新的管理员记录应该存在", existingAdmin);

        int result = adminMapper.updateByPrimaryKeySelective(admin);
        System.out.println("更新结果 (影响行数): " + result);
        assertTrue("更新操作应该影响一行", result > 0);

        // 查询回来验证更新是否成功
        TAdmin updatedAdmin = adminMapper.selectByPrimaryKey(adminAccountToUpdate);
        assertNotNull("更新后的管理员记录应该存在", updatedAdmin);
        assertEquals("更新后的昵称应该正确", "超级管理员", updatedAdmin.getNickname());
        assertEquals("更新后的手机号码应该正确", "13599998888", updatedAdmin.getPhone());
        // 验证其他字段未被改变
        assertEquals("密码不应改变", existingAdmin.getPassword(), updatedAdmin.getPassword());
    }

    @Test
    public void testSelectBySelective() {
        System.out.println("--- 测试 selectBySelective ---");
        // 测试根据昵称模糊查询管理员
        TAdmin query = new TAdmin();
        query.setNickname("管理"); // 查询昵称包含"管理"的管理员

        List<TAdmin> adminList = adminMapper.selectSelective(query);
        System.out.println("查询结果列表大小: " + adminList.size());

        assertNotNull("查询结果列表不应为 null", adminList);
        assertTrue("查询结果列表应该包含至少一个昵称包含'管理'的管理员", adminList.size() > 0);

        // 验证查询结果中的管理员昵称是否包含"管理"
        for (TAdmin admin : adminList) {
            assertTrue("查询到的管理员昵称应该包含'管理'", admin.getNickname().contains("管理"));
        }
    }
}