package mapper;

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
 * TVehicleInformationMapperImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的Spring配置文件路径
@Transactional // 开启事务，测试后可以回滚
@Rollback(true) // 测试后回滚数据库修改
public class TVehicleInformationMapperImplTest {

    @Autowired
    private TVehicleInformationMapper tVehicleInformationMapper;

    /**
     * 测试根据主键删除车辆信息
     */
    @Test
    public void testDeleteByPrimaryKey() {
        System.out.println("--- 测试 deleteByPrimaryKey ---");
        // TODO: 替换为实际存在的车辆ID进行测试
        String vehicleIdToDelete = "V001";
        int result = tVehicleInformationMapper.deleteByPrimaryKey(vehicleIdToDelete);
        System.out.println("删除结果 (影响行数): " + result);

    }

    /**
     * 测试插入车辆信息（所有字段）
     */
    @Test
    public void testInsert() {
        System.out.println("--- 测试 insert ---");
        TVehicleInformation vehicle = new TVehicleInformation();
        // TODO: 填充车辆信息，确保VehicleID唯一
        vehicle.setVehicleid("V_NEW_" + System.currentTimeMillis());
        vehicle.setVehicletype("轿车");
        vehicle.setVehiclegrade("紧凑型");
        vehicle.setRidenum(5);
        vehicle.setVehiclebrand("大众");
        vehicle.setVehiclename("速腾");
        vehicle.setVehiclepic("test.jpg");
        vehicle.setVehicledis("1.4T");
        vehicle.setDailyrental(new BigDecimal("250.00").longValue()); // 注意类型转换
        vehicle.setState("可用状态");

        int result = tVehicleInformationMapper.insert(vehicle);
        System.out.println("插入结果 (影响行数): " + result);

    }

    /**
     * 测试选择性插入车辆信息
     */
    @Test
    public void testInsertSelective() {
        System.out.println("--- 测试 insertSelective ---");
        TVehicleInformation vehicle = new TVehicleInformation();
        // TODO: 填充部分车辆信息，确保VehicleID唯一
        vehicle.setVehicleid("V_SELECTIVE_" + System.currentTimeMillis());
        vehicle.setVehicletype("SUV");
        vehicle.setVehiclebrand("丰田");
        vehicle.setDailyrental(new BigDecimal("350.00").longValue()); // 注意类型转换

        int result = tVehicleInformationMapper.insertSelective(vehicle);
        System.out.println("选择性插入结果 (影响行数): " + result);

    }

    /**
     * 测试根据主键查询车辆信息
     */
    @Test
    public void testSelectByPrimaryKey() {
        System.out.println("--- 测试 selectByPrimaryKey ---");
        // TODO: 替换为实际存在的车辆ID进行测试
        String vehicleIdToSelect = "V001";
        TVehicleInformation vehicle = tVehicleInformationMapper.selectByPrimaryKey(vehicleIdToSelect);
        System.out.println("查询结果: " + vehicle);

    }

    /**
     * 测试根据主键选择性更新车辆信息
     */
    @Test
    public void testUpdateByPrimaryKeySelective() {
        System.out.println("--- 测试 updateByPrimaryKeySelective ---");
        TVehicleInformation vehicle = new TVehicleInformation();
        // TODO: 替换为实际存在的车辆ID进行测试
        vehicle.setVehicleid("V001");
        // TODO: 填充需要更新的字段
        vehicle.setDailyrental(new BigDecimal("220.00").longValue()); // 更新日租费用
        vehicle.setState("维修中"); // 更新状态

        int result = tVehicleInformationMapper.updateByPrimaryKeySelective(vehicle);
        System.out.println("选择性更新结果 (影响行数): " + result);
    }

    /**
     * 测试根据主键更新车辆信息（所有字段）
     */
    @Test
    public void testUpdateByPrimaryKey() {
        System.out.println("--- 测试 updateByPrimaryKey ---");
        TVehicleInformation vehicle = new TVehicleInformation();
        // TODO: 替换为实际存在的车辆ID进行测试
        vehicle.setVehicleid("V001");
        // TODO: 填充所有字段（即使有些字段值不变）
        vehicle.setVehicletype("轿车");
        vehicle.setVehiclegrade("紧凑型");
        vehicle.setRidenum(5);
        vehicle.setVehiclebrand("丰田");
        vehicle.setVehiclename("卡罗拉");
        vehicle.setVehiclepic("car001.jpg");
        vehicle.setVehicledis("1.2L");
        vehicle.setDailyrental(new BigDecimal("230.00").longValue()); // 更新日租费用
        vehicle.setState("可用状态"); // 更新状态

        int result = tVehicleInformationMapper.updateByPrimaryKey(vehicle);
        System.out.println("更新结果 (影响行数): " + result);

    }

    /**
     * 测试根据车辆ID或类型进行动态查询
     */
    @Test
    public void testSelectByVehicleLikeSelective() {
        System.out.println("--- 测试 selectByVehicleLikeSelective ---");
        TVehicleInformation query = new TVehicleInformation();

        // TODO: 设置查询条件，例如根据车辆类型查询
        query.setVehicletype("轿车");
        // TODO: 或者根据车辆ID模糊查询
        // query.setVehicleid("V00");

        List<TVehicleInformation> vehicleList = tVehicleInformationMapper.selectByVehicleLikeSelective(query);
        System.out.println("查询结果数量: " + vehicleList.size());
    }

    /**
     * 测试查询所有车辆
     */
    @Test
    public void testSelectAllVehicles() {
        System.out.println("--- 测试 selectAllVehicles ---");
        List<TVehicleInformation> vehicleList = tVehicleInformationMapper.selectAllVehicles();
        System.out.println("所有车辆数量: " + vehicleList.size());

    }
}
