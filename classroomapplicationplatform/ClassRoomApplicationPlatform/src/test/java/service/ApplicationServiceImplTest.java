package service;

import model.TApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.sql.Date;
import java.sql.Time;

/**
 * ApplicationServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class ApplicationServiceImplTest {

    @Autowired
    private ApplicationService applicationService; // 假设Service接口名称是ApplicationService

    @Test
    public void addApplication() {
        System.out.println("--- 测试 ApplicationServiceImpl.addApplication ---");
        TApplication application = new TApplication();
        // applicationId 是自增主键，不需要手动设置
        // TODO: 填充申请信息，确保 classroomId 和 userId 存在
        application.setClassroomId(1); // 关联存在的教室ID
        application.setUserId("teacher001"); // 关联存在的用户ID
        application.setApplyDate(new Date(System.currentTimeMillis())); // 当前日期
        application.setUseDate(Date.valueOf("2025-12-31")); // 示例使用日期
        application.setStartTime(Time.valueOf("10:00:00")); // 示例开始时间
        application.setEndTime(Time.valueOf("12:00:00")); // 示例结束时间
        application.setPurpose("测试Service添加申请用途");
        application.setStatus("待审核"); // 默认状态

        int result = applicationService.addApplication(application);
        System.out.println("添加申请结果 (影响行数): " + result);
         System.out.println("插入的申请ID (如果Service返回对象或支持主键回填): " + application.getApplicationId()); // 可能需要修改Service方法返回类型
    }

    @Test
    public void modifyApplication() {
        System.out.println("--- 测试 ApplicationServiceImpl.modifyApplication ---");
        TApplication application = new TApplication();
        // TODO: 使用一个存在的申请ID进行更新测试
        Integer applicationIdToUpdate = 3; // 示例ID，请根据你的数据库实际情况修改 ('待审核'的申请)
        System.out.println("尝试修改申请ID: " + applicationIdToUpdate);
        application.setApplicationId(applicationIdToUpdate);
        // TODO: 填充需要更新的字段
        application.setStatus("已通过"); // 更新状态
        application.setPurpose("Service 更新后的用途"); // 更新用途

        boolean result = applicationService.modifyApplication(application);
        System.out.println("修改申请结果 (true表示成功): " + result);
    }

    @Test
    public void removeApplication() {
        System.out.println("--- 测试 ApplicationServiceImpl.removeApplication ---");
         // TODO: 替换为实际存在的申请ID进行删除测试
        // 如果你想测试删除，可以先addApplication一个新申请，然后删除它。
        Integer applicationIdToDelete = 4; // 示例ID，请根据你的数据库实际情况修改 ('已拒绝'的申请)
        System.out.println("尝试删除申请ID: " + applicationIdToDelete);

        boolean result = applicationService.removeApplication(applicationIdToDelete);
        System.out.println("删除申请结果 (true表示成功): " + result);
    }

    @Test
    public void getApplicationById() {
        System.out.println("--- 测试 ApplicationServiceImpl.getApplicationById ---");
        // TODO: 使用一个存在的申请ID进行查询测试
        Integer applicationIdToSelect = 1; // 示例ID，请根据你的数据库实际情况修改 ('已通过'的申请)
        System.out.println("查询申请ID: " + applicationIdToSelect);

        TApplication application = applicationService.getApplicationById(applicationIdToSelect);
        System.out.println("查询结果: " + application);
    }

    @Test
    public void getApplicationsByClassroom() {
        System.out.println("--- 测试 ApplicationServiceImpl.getApplicationsByClassroom ---");
        // TODO: 使用一个存在的教室ID进行查询测试
        Integer classroomIdToFind = 1; // 示例教室ID
        System.out.println("尝试根据教室ID查询申请: " + classroomIdToFind);

        List<TApplication> applications = applicationService.getApplicationsByClassroom(classroomIdToFind);
        System.out.println("查询结果列表: " + applications);
        System.out.println("找到 " + (applications != null ? applications.size() : 0) + " 条记录.");
    }

    @Test
    public void getApplicationsByApplicant() {
        System.out.println("--- 测试 ApplicationServiceImpl.getApplicationsByApplicant ---");
        // **注意:** 你提供的 ApplicationServiceImpl 中 getApplicationsByApplicant 方法似乎使用了 applicantId 作为参数，但内部查询是基于 applicationId。
        // 如果 applicantId 应该关联 user_id，你需要修改 Service 实现。这里的测试按照当前实现来写。
        // TODO: 使用一个存在的申请ID进行查询测试 (根据当前的 Service 实现)
        Integer applicationIdToFind = 1; // 示例申请ID
        System.out.println("尝试根据申请ID查询申请 (Service实现): " + applicationIdToFind);
        System.out.println("注意：Service 实现 getApplicationsByApplicant 目前根据 application_id 查询，而非 user_id。");

        List<TApplication> applications = applicationService.getApplicationsByApplicant(applicationIdToFind); // 调用 Service 方法
        System.out.println("查询结果列表: " + applications);
        System.out.println("找到 " + (applications != null ? applications.size() : 0) + " 条记录.");

        // 如果 Service 方法 getApplicationsByApplicant 应该根据 user_id 查询，且 Service 接口和实现已修改，
        // 请修改此测试为：
        // String userIdToFind = "teacher001"; // 示例用户ID
        // System.out.println("尝试根据用户ID查询申请: " + userIdToFind);
        // List<TApplication> applications = applicationService.getApplicationsByApplicant(userIdToFind);
        // System.out.println("查询结果列表: " + applications);
        // System.out.println("找到 " + (applications != null ? applications.size() : 0) + " 条记录.");
    }
}