package mapper;

import model.THealth_check;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * THealth_checkMapperImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class THealth_checkMapperImplTest {

    @Autowired
    private THealth_checkMapper healthCheckMapper;

    @Test
    public void deleteByPrimaryKey() {
        System.out.println("--- 测试 THealth_checkMapper.deleteByPrimaryKey ---");
        // TODO: 使用一个存在的健康检查ID进行删除测试
        // 如果你想测试删除，可以先insert一个新健康检查记录，然后删除它。
        Integer checkIdToDelete = 4; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("尝试删除健康检查ID: " + checkIdToDelete);
        int result = healthCheckMapper.deleteByPrimaryKey(checkIdToDelete);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void insert() {
        System.out.println("--- 测试 THealth_checkMapper.insert ---");
        THealth_check healthCheck = new THealth_check();
        // checkId 是自增主键，不需要手动设置
        // TODO: 填充健康检查信息，确保 animalId 和 checkerAccount 存在
        healthCheck.setAnimalId("A001"); // 关联存在的动物
        healthCheck.setCheckItem("体检");
        healthCheck.setCheckResult("健康");
        healthCheck.setTreatmentDesc("无");
        healthCheck.setCheckerAccount("worker002"); // 关联存在的工作人员
        healthCheck.setCheckDate(new Date()); // 当前时间

        int result = healthCheckMapper.insert(healthCheck);
        System.out.println("结果 (影响行数): " + result);
        System.out.println("插入的健康检查ID (如果支持主键回填): " + healthCheck.getCheckId());
    }

    @Test
    public void insertSelective() {
        System.out.println("--- 测试 THealth_checkMapper.insertSelective ---");
        THealth_check healthCheck = new THealth_check();
        // checkId 是自增主键
        // TODO: 填充健康检查信息，确保 animalId 和 checkerAccount 存在
        healthCheck.setAnimalId("A002"); // 关联存在的动物
        healthCheck.setCheckItem("疫苗接种");
        healthCheck.setCheckResult("已接种");
        healthCheck.setCheckerAccount("worker001"); // 关联存在的工作人员
        healthCheck.setCheckDate(new Date()); // 当前时间
        // treatmentDesc 不设置

        int result = healthCheckMapper.insertSelective(healthCheck);
        System.out.println("结果 (影响行数): " + result);
        System.out.println("插入的健康检查ID (如果支持主键回填): " + healthCheck.getCheckId());
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println("--- 测试 THealth_checkMapper.selectByPrimaryKey ---");
        // TODO: 使用一个存在的健康检查ID进行查询测试
        Integer checkIdToSelect = 1; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("查询健康检查ID: " + checkIdToSelect);
        THealth_check healthCheck = healthCheckMapper.selectByPrimaryKey(checkIdToSelect);
        System.out.println("结果: " + healthCheck);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        System.out.println("--- 测试 THealth_checkMapper.updateByPrimaryKeySelective ---");
        THealth_check healthCheck = new THealth_check();
        // TODO: 使用一个存在的健康检查ID进行更新测试
        Integer checkIdToUpdate = 1; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("尝试更新健康检查ID: " + checkIdToUpdate);
        healthCheck.setCheckId(checkIdToUpdate);
        // TODO: 填充需要更新的字段
        healthCheck.setCheckResult("疫苗已接种完成"); // 更新检查结果
        healthCheck.setTreatmentDesc("无后续治疗"); // 更新治疗描述

        int result = healthCheckMapper.updateByPrimaryKeySelective(healthCheck);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void updateByPrimaryKey() {
        System.out.println("--- 测试 THealth_checkMapper.updateByPrimaryKey ---");
        THealth_check healthCheck = new THealth_check();
        // TODO: 使用一个存在的健康检查ID进行完全更新测试
        Integer checkIdToUpdate = 2; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("尝试完全更新健康检查ID: " + checkIdToUpdate);
        healthCheck.setCheckId(checkIdToUpdate);
        // TODO: 填充所有字段
        healthCheck.setAnimalId("A003"); // 更改关联动物
        healthCheck.setCheckItem("年度体检"); // 更新检查项目
        healthCheck.setCheckResult("良好"); // 更新检查结果
        healthCheck.setTreatmentDesc("定期复查"); // 更新治疗描述
        healthCheck.setCheckerAccount("worker001"); // 更改关联检查人
        healthCheck.setCheckDate(new Date()); // 更新检查日期

        int result = healthCheckMapper.updateByPrimaryKey(healthCheck);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void selectSelective() {
        System.out.println("--- 测试 THealth_checkMapper.selectSelective ---");
        THealth_check query = new THealth_check();
        // TODO: 设置查询条件，例如根据动物编号和检查人查询
        query.setAnimalId("A001");
        // query.setCheckedAccount("worker001");

        List<THealth_check> checkList = healthCheckMapper.selectSelective(query);
        System.out.println("查询结果列表: " + checkList);
        System.out.println("找到 " + (checkList != null ? checkList.size() : 0) + " 条记录.");
    }
}