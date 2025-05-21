package service;

import model.TFlight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * TFlightServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class TFlightServiceImplTest {

    @Autowired
    private TFlightService tFlightService;

    @Test
    public void addFlight() {
        System.out.println("--- 测试 addFlight (TFlightService) ---");
        TFlight flight = new TFlight();
        // TODO: 填充航班信息，确保 flightId 或其他唯一标识字段合适（如果不是自增主键）
        // 假设 flightId 是自增主键，不需要手动设置
        flight.setFlightNumber("TEST_FLIGHT_" + System.currentTimeMillis() % 100000);
        flight.setDeparturePort("TestDep");
        flight.setArrivalPort("TestArr");
        flight.setDepartureTime(new java.sql.Date(System.currentTimeMillis()));


        int result = tFlightService.addFlight(flight);
        System.out.println("添加航班结果 (影响行数): " + result);
    }

    @Test
    public void modifyFlight() {
        System.out.println("--- 测试 modifyFlight (TFlightService) ---");
        TFlight flight = new TFlight();
        // TODO: 使用一个存在的航班ID进行更新测试
        Integer flightIdToUpdate = 1; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("尝试修改航班ID: " + flightIdToUpdate);
        flight.setFlightId(flightIdToUpdate);

        boolean result = tFlightService.modifyFlight(flight);
        System.out.println("修改航班结果 (true表示成功): " + result);
    }

    @Test
    public void removeFlight() {
        System.out.println("--- 测试 removeFlight (TFlightService) ---");
         // TODO: 替换为实际存在的航班ID进行删除测试
        // 注意：删除有外键关联（如 tickets）的记录可能会失败，除非设置了级联删除
        // 如果你想测试删除，可以先addFlight一个新航班，然后删除它。
        Integer flightIdToDelete = 2; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("尝试删除航班ID: " + flightIdToDelete);

        boolean result = tFlightService.removeFlight(flightIdToDelete);
        System.out.println("删除航班结果 (true表示成功): " + result);
    }

    @Test
    public void getFlightById() {
        System.out.println("--- 测试 getFlightById (TFlightService) ---");
        // TODO: 使用一个存在的航班ID进行查询测试
        Integer flightIdToSelect = 1; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("查询航班ID: " + flightIdToSelect);

        TFlight flight = tFlightService.getFlightById(flightIdToSelect);
        System.out.println("查询结果: " + flight);
    }

    @Test
    public void getFlightsByStation() {
        System.out.println("--- 测试 getFlightsByStation (TFlightService) ---");
        // TODO: 使用实际存在的出发站和到达港进行查询测试
        String departureStation = "北京"; // 示例出发站
        String arrivalPort = "上海"; // 示例到达港
        System.out.println("尝试查询从 " + departureStation + " 到 " + arrivalPort + " 的航班");

        List<TFlight> flights = tFlightService.getFlightsByStation(departureStation, arrivalPort);
        System.out.println("查询结果列表: " + flights);
        System.out.println("找到 " + (flights != null ? flights.size() : 0) + " 条记录.");
    }

    @Test
    public void getAllFlights() {
        System.out.println("--- 测试 getAllFlights (TFlightService) ---");
        System.out.println("尝试查询所有航班");
        List<TFlight> allFlights = tFlightService.getAllFlights();
        System.out.println("查询结果列表: " + allFlights);
        System.out.println("找到 " + (allFlights != null ? allFlights.size() : 0) + " 条记录.");
    }
}