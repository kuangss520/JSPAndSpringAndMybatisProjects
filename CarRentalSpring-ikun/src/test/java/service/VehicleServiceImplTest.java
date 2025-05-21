package service;

import model.TVehicleInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * VehicleServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的Spring配置文件路径
@Transactional // 开启事务，测试后可以回滚
@Rollback(true) // 测试后回滚数据库修改
public class VehicleServiceImplTest {

    @Autowired
    private VehicleService vehicleService;

    /**
     * 测试添加车辆
     */
    @Test
    public void testAddVehicle() {
        System.out.println("--- 测试 addVehicle ---");
        TVehicleInformation vehicle = new TVehicleInformation();
        // TODO: 填充车辆信息，确保VehicleID唯一
        vehicle.setVehicleid("V_SERVICE_NEW_" + System.currentTimeMillis()%10000);
        vehicle.setVehicletype("轿车");
        vehicle.setVehiclebrand("测试品牌");
        vehicle.setDailyrental(new BigDecimal("180.00").longValue()); // 注意类型转换
        vehicle.setState("可用状态");
        vehicle.setVehiclegrade("A级车");
        vehicle.setRidenum(5);
        boolean result = vehicleService.addVehicle(vehicle);
        System.out.println("添加结果: " + result);

    }

    /**
     * 测试修改车辆信息
     */
    @Test
    public void testModifyVehicle() {
        System.out.println("--- 测试 modifyVehicle ---");
        TVehicleInformation vehicle = new TVehicleInformation();
        // TODO: 替换为实际存在的车辆ID进行测试
        vehicle.setVehicleid("V001"); // 示例ID，请根据你的数据库实际情况修改
        // TODO: 填充需要更新的字段
        vehicle.setDailyrental(new BigDecimal("260.00").longValue()); // 更新日租费用
        vehicle.setState("保养中"); // 更新状态

        boolean result = vehicleService.modifyVehicle(vehicle);
        System.out.println("修改结果: " + result);

    }

    /**
     * 测试删除车辆
     */
    @Test
    public void testRemoveVehicle() {
        System.out.println("--- 测试 removeVehicle ---");
        // TODO: 替换为实际存在的车辆ID进行测试
        String vehicleIdToDelete = "V003"; // 示例ID，请根据你的数据库实际情况修改
        boolean result = vehicleService.removeVehicle(vehicleIdToDelete);
        System.out.println("删除结果: " + result);

    }

    /**
     * 测试根据车辆ID（车牌号）查询租赁车辆
     */
    @Test
    public void testGetVehicleById() {
        System.out.println("--- 测试 getVehicleById ---");
        // TODO: 替换为实际存在的车辆ID进行测试
        String vehicleIdToSelect = "V001"; // 示例ID，请根据你的数据库实际情况修改
        TVehicleInformation vehicle = vehicleService.getVehicleById(vehicleIdToSelect);
        System.out.println("查询结果: " + vehicle);

    }

    /**
     * 测试根据租赁车辆类型查询租赁车辆
     */
    @Test
    public void testGetVehiclesByType() {
        System.out.println("--- 测试 getVehiclesByType ---");
        // TODO: 替换为实际存在的车辆类型进行测试
        String vehicleTypeToSelect = "轿车";
        List<TVehicleInformation> vehicleList = vehicleService.getVehiclesByType(vehicleTypeToSelect);
        System.out.println("查询结果数量: " + vehicleList.size());

    }

    /**
     * 测试查询所有租赁车辆
     */
    @Test
    public void testGetAllVehicles() {
        System.out.println("--- 测试 getAllVehicles ---");
        List<TVehicleInformation> vehicleList = vehicleService.getAllVehicles();
        System.out.println("所有车辆数量: " + vehicleList.size());

    }
}
