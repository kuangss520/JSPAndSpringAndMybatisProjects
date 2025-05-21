package mapper;

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
 * TUserInformationMapperImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的Spring配置文件路径
@Transactional // 开启事务，测试后可以回滚
@Rollback(true) // 测试后回滚数据库修改
public class TUserInformationMapperImplTest {

    @Autowired
    private TUserInformationMapper tUserInformationMapper;

    /**
     * 测试根据主键删除用户信息
     */
    @Test
    public void testDeleteByPrimaryKey() {
        System.out.println("--- 测试 deleteByPrimaryKey ---");
        // TODO: 替换为实际存在的用户ID进行测试
        String userIdToDelete = "U001"; // 示例ID，请根据你的数据库实际情况修改
        int result = tUserInformationMapper.deleteByPrimaryKey(userIdToDelete);
        System.out.println("删除结果 (影响行数): " + result);

    }

    /**
     * 测试插入用户信息（所有字段）
     */
    @Test
    public void testInsert() {
        System.out.println("--- 测试 insert ---");
        TUserInformation user = new TUserInformation();
        // TODO: 填充用户信息，确保UserId唯一
        user.setUserid("U_NEW_" + System.currentTimeMillis());
        user.setUsername("测试用户");
        user.setPwd("testpwd");
        user.setMail("test@example.com");
        user.setMobile("12345678901");

        int result = tUserInformationMapper.insert(user);
        System.out.println("插入结果 (影响行数): " + result);

    }

    /**
     * 测试选择性插入用户信息
     */
    @Test
    public void testInsertSelective() {
        System.out.println("--- 测试 insertSelective ---");
        TUserInformation user = new TUserInformation();
        // TODO: 填充部分用户信息，确保UserId唯一
        user.setUserid("U_SELECTIVE_" + System.currentTimeMillis());
        user.setUsername("选择性用户");
        user.setPwd("selectivepwd");

        int result = tUserInformationMapper.insertSelective(user);
        System.out.println("选择性插入结果 (影响行数): " + result);

    }

    /**
     * 测试根据主键查询用户信息
     */
    @Test
    public void testSelectByPrimaryKey() {
        System.out.println("--- 测试 selectByPrimaryKey ---");
        // TODO: 替换为实际存在的用户ID进行测试
        String userIdToSelect = "U001"; // 示例ID，请根据你的数据库实际情况修改
        TUserInformation user = tUserInformationMapper.selectByPrimaryKey(userIdToSelect);
        System.out.println("查询结果: " + user);

    }

    /**
     * 测试根据主键选择性更新用户信息
     */
    @Test
    public void testUpdateByPrimaryKeySelective() {
        System.out.println("--- 测试 updateByPrimaryKeySelective ---");
        TUserInformation user = new TUserInformation();
        // TODO: 替换为实际存在的用户ID进行测试
        String userIdToUpdate = "U001"; // 示例ID，请根据你的数据库实际情况修改
        user.setUserid(userIdToUpdate);
        // TODO: 填充需要更新的字段
        user.setMail("updated@example.com"); // 更新邮箱
        user.setMobile("98765432109"); // 更新手机号

        int result = tUserInformationMapper.updateByPrimaryKeySelective(user);
        System.out.println("选择性更新结果 (影响行数): " + result);

    }

    /**
     * 测试根据主键更新用户信息（所有字段）
     */
    @Test
    public void testUpdateByPrimaryKey() {
        System.out.println("--- 测试 updateByPrimaryKey ---");
        TUserInformation user = new TUserInformation();
        // TODO: 替换为实际存在的用户ID进行测试
        String userIdToUpdate = "U001"; // 示例ID，请根据你的数据库实际情况修改
        user.setUserid(userIdToUpdate);
        // TODO: 填充所有字段（即使有些字段值不变）
        user.setUsername("张三更新");
        user.setPwd("newpassword");
        user.setMail("zhangsan_updated@example.com");
        user.setMobile("11111111111");

        int result = tUserInformationMapper.updateByPrimaryKey(user);
        System.out.println("更新结果 (影响行数): " + result);

    }

    /**
     * 测试根据用户信息进行动态查询（用户ID、用户名等）
     */
    @Test
    public void testSelectAllUserSelective() {
        System.out.println("--- 测试 selectAllUserSelective ---");
        TUserInformation query = new TUserInformation();

        // TODO: 设置查询条件，例如根据用户名模糊查询
        query.setUsername("张");
        // TODO: 或者根据用户ID查询
        // query.setUserid("U001");

        List<TUserInformation> userList = tUserInformationMapper.selectAllUserSelective(query);
        System.out.println("查询结果数量: " + userList.size());

    }
}
