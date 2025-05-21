package mapper;

import model.TApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.sql.Date; // 使用 sql.Date 与数据库 DATE 类型对应
import java.sql.Time; // 使用 sql.Time 与数据库 TIME 类型对应

/**
 * TApplicationMapperImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class TApplicationMapperImplTest {

    @Autowired
    private TApplicationMapper applicationMapper;

    @Test
    public void deleteByPrimaryKey() {
        System.out.println("--- 测试 TApplicationMapper.deleteByPrimaryKey ---");
        // TODO: 使用一个存在的申请ID进行删除测试
        // 如果你想测试删除，可以先insert一个新申请，然后删除它。
        Integer applicationIdToDelete = 4; // 示例ID，请根据你的数据库实际情况修改 ('已拒绝'的申请)
        System.out.println("尝试删除申请ID: " + applicationIdToDelete);
        int result = applicationMapper.deleteByPrimaryKey(applicationIdToDelete);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void insert() {
        System.out.println("--- 测试 TApplicationMapper.insert ---");
        TApplication application = new TApplication();
        // applicationId 是自增主键，不需要手动设置
        application.setClassroomId(1); // 关联存在的教室ID
        application.setUserId("teacher001"); // 关联存在的用户ID
        application.setApplyDate(new Date(System.currentTimeMillis())); // 当前日期
        application.setUseDate(Date.valueOf("2025-12-25")); // 示例使用日期
        application.setStartTime(Time.valueOf("18:00:00")); // 示例开始时间
        application.setEndTime(Time.valueOf("20:00:00")); // 示例结束时间
        application.setPurpose("测试插入申请用途");
        application.setStatus("待审核"); // 默认状态

        int result = applicationMapper.insert(application);
        System.out.println("结果 (影响行数): " + result);
        System.out.println("插入的申请ID (如果支持主键回填): " + application.getApplicationId());
    }

    @Test
    public void insertSelective() {
        System.out.println("--- 测试 TApplicationMapper.insertSelective ---");
        TApplication application = new TApplication();
        // applicationId 是自增主键
        application.setClassroomId(2); // 关联存在的教室ID
        application.setUserId("teacher002"); // 关联存在的用户ID
        application.setApplyDate(new Date(System.currentTimeMillis())); // 当前日期
        application.setUseDate(Date.valueOf("2025-11-11")); // 示例使用日期
        application.setStartTime(Time.valueOf("09:30:00")); // 示例开始时间
        application.setEndTime(Time.valueOf("11:00:00")); // 示例结束时间
        application.setPurpose("测试选择性插入申请用途");
        // applyDate, status 不设置

        int result = applicationMapper.insertSelective(application);
        System.out.println("结果 (影响行数): " + result);
        System.out.println("插入的申请ID (如果支持主键回填): " + application.getApplicationId());
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println("--- 测试 TApplicationMapper.selectByPrimaryKey ---");
        // TODO: 使用一个存在的申请ID进行查询测试
        Integer applicationIdToSelect = 1; // 示例ID，请根据你的数据库实际情况修改 ('已通过'的申请)
        System.out.println("查询申请ID: " + applicationIdToSelect);
        TApplication application = applicationMapper.selectByPrimaryKey(applicationIdToSelect);
        System.out.println("结果: " + application);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        System.out.println("--- 测试 TApplicationMapper.updateByPrimaryKeySelective ---");
        TApplication application = new TApplication();
        // TODO: 使用一个存在的申请ID进行更新测试
        Integer applicationIdToUpdate = 3; // 示例ID，请根据你的数据库实际情况修改 ('待审核'的申请)
        System.out.println("尝试更新申请ID: " + applicationIdToUpdate);
        application.setApplicationId(applicationIdToUpdate);
        // TODO: 填充需要更新的字段
        application.setStatus("已通过"); // 更新状态
        application.setUseDate(Date.valueOf("2025-10-30")); // 更新使用日期

        int result = applicationMapper.updateByPrimaryKeySelective(application);
        System.out.println("结果 (影响行数): " + result);
    }


    @Test
    public void updateByPrimaryKey() {
        System.out.println("--- 测试 TApplicationMapper.updateByPrimaryKey ---");
        TApplication application = new TApplication();
        // TODO: 使用一个存在的申请ID进行完全更新测试
        Integer applicationIdToUpdate = 2; // 示例ID，请根据你的数据库实际情况修改 ('已通过'的申请)
        System.out.println("尝试完全更新申请ID: " + applicationIdToUpdate);
        application.setApplicationId(applicationIdToUpdate);
        // TODO: 填充所有字段 (不包括 purpose, updateByPrimaryKeyWithBLOBs 用于带BLOBs的更新)
        application.setClassroomId(1); // 更改教室
        application.setUserId("teacher001"); // 更改用户
        application.setApplyDate(Date.valueOf("2025-10-15"));
        application.setUseDate(Date.valueOf("2025-10-20"));
        application.setStartTime(Time.valueOf("14:00:00"));
        application.setEndTime(Time.valueOf("16:00:00"));
        application.setStatus("已取消"); // 更改状态
        // purpose 不在此方法中更新

        int result = applicationMapper.updateByPrimaryKey(application);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void selectSelective() {
        System.out.println("--- 测试 TApplicationMapper.selectSelective ---");
        TApplication query = new TApplication();
        // TODO: 设置查询条件，例如根据教室ID和状态查询
        query.setClassroomId(1);
        query.setStatus("已通过");

        List<TApplication> applicationList = applicationMapper.selectSelective(query);
        System.out.println("查询结果列表: " + applicationList);
        System.out.println("找到 " + (applicationList != null ? applicationList.size() : 0) + " 条记录.");
    }
}