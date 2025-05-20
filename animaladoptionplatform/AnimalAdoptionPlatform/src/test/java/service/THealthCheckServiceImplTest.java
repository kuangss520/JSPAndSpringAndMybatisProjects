package service;

import model.THealth_check;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * THealthCheckServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class THealthCheckServiceImplTest {

    @Autowired
    private THealthCheckService healthCheckService; // 假设Service接口名称是THealthCheckService

    @Test
    public void addHealthCheck() {
        System.out.println("--- 测试 THealthCheckServiceImpl.addHealthCheck ---");
        THealth_check healthCheck = new THealth_check();
        // checkId 是自增主键，不需要手动设置
        // TODO: 填充健康检查信息，确保 animalId 和 checkerAccount 存在
        healthCheck.setAnimalId("A001"); // 关联存在的动物
        healthCheck.setCheckItem("Service 添加检查项目");
        healthCheck.setCheckResult("正常");
        healthCheck.setTreatmentDesc("无需治疗");
        healthCheck.setCheckerAccount("worker001"); // 关联存在的工作人员
        healthCheck.setCheckDate(new Date()); // 当前时间

        int result = healthCheckService.addHealthCheck(healthCheck);
        System.out.println("添加健康检查结果 (影响行数): " + result);
        System.out.println("插入的健康检查ID (如果Service返回对象或支持主键回填): " + healthCheck.getCheckId()); // 可能需要修改Service方法返回类型
    }

    @Test
    public void modifyHealthCheck() {
        System.out.println("--- 测试 THealthCheckServiceImpl.modifyHealthCheck ---");
        THealth_check healthCheck = new THealth_check();
        // TODO: 使用一个存在的健康检查ID进行更新测试
        Integer checkIdToUpdate = 1; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("尝试修改健康检查ID: " + checkIdToUpdate);
        healthCheck.setCheckId(checkIdToUpdate);
        // TODO: 填充需要更新的字段
        healthCheck.setCheckResult("已完成"); // 更新检查结果
        healthCheck.setTreatmentDesc("已按医嘱处理"); // 更新治疗描述

        boolean result = healthCheckService.modifyHealthCheck(healthCheck);
        System.out.println("修改健康检查结果 (true表示成功): " + result);
    }

    @Test
    public void removeHealthCheck() {
        System.out.println("--- 测试 THealthCheckServiceImpl.removeHealthCheck ---");
         // TODO: 替换为实际存在的健康检查ID进行删除测试
        // 如果你想测试删除，可以先addHealthCheck一个新记录，然后删除它。
        Integer checkIdToDelete = 4; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("尝试删除健康检查ID: " + checkIdToDelete);

        boolean result = healthCheckService.removeHealthCheck(checkIdToDelete);
        System.out.println("删除健康检查结果 (true表示成功): " + result);
    }

    @Test
    public void getChecksByAnimalId() {
        System.out.println("--- 测试 THealthCheckServiceImpl.getChecksByAnimalId ---");
        // TODO: 使用一个存在且有健康检查记录的动物编号进行查询测试
        String animalIdToFind = "A001"; // 示例动物编号
        System.out.println("尝试根据动物编号查询健康检查记录: " + animalIdToFind);

        List<THealth_check> healthChecks = healthCheckService.getChecksByAnimalId(animalIdToFind);
        System.out.println("查询结果列表: " + healthChecks);
        System.out.println("找到 " + (healthChecks != null ? healthChecks.size() : 0) + " 条记录.");
    }

    @Test
    public void getCheckById() {
        System.out.println("--- 测试 THealthCheckServiceImpl.getCheckById ---");
        // TODO: 使用一个存在的健康检查ID进行查询测试
        Integer checkIdToSelect = 2; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("查询健康检查ID: " + checkIdToSelect);

        THealth_check healthCheck = healthCheckService.getCheckById(checkIdToSelect);
        System.out.println("查询结果: " + healthCheck);
    }
}