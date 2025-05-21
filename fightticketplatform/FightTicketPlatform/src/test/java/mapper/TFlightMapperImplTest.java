package mapper;

import model.TFlight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional // 开启事务
@Rollback(true) // 测试后回滚事务
public class TFlightMapperImplTest {

    @Autowired
    private TFlightMapper flightMapper; // Assuming you have a TFlightMapper interface

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    @Test
    public void testInsertSelective() throws Exception {
        System.out.println("--- 测试 insertSelective ---");
        TFlight newFlight = new TFlight();
        newFlight.setFlightNumber("TEST100");
        newFlight.setAirline("测试航空");
        newFlight.setAircraftType("测试机型");
        newFlight.setDeparturePort("测试出发港");
        newFlight.setArrivalPort("测试到达港");
        newFlight.setFlightDate(dateFormat.parse("2024-12-31"));
        newFlight.setDepartureTime(timeFormat.parse("10:00:00"));
        newFlight.setArrivalTime(timeFormat.parse("12:00:00"));
        newFlight.setSeatCount(100);

        int result = flightMapper.insertSelective(newFlight);
        System.out.println("插入结果 (影响行数): " + result);
        assertTrue("插入操作应该影响一行", result > 0);

        // 可以选择查询回来验证插入是否成功
        // 注意：如果主键是自增的，这里需要获取自增的主键值进行查询
        // 假设insertSelective返回了影响行数且成功
    }

    @Test
    public void testDeleteByPrimaryKey() {
        System.out.println("--- 测试 deleteByPrimaryKey ---");
        // 使用一个存在的航班ID进行删除测试，根据初始数据修改
        // 注意：删除有外键关联（如 t_ticket）的航班记录可能会失败，除非先删除关联的机票
        Integer flightIdToDelete = 4; // 例如：ZH9876 航班
        System.out.println("删除航班ID: " + flightIdToDelete);

        // 先查询确保记录存在
        TFlight existingFlight = flightMapper.selectByPrimaryKey(flightIdToDelete);
        assertNotNull("待删除的航班记录应该存在", existingFlight);

        int result = flightMapper.deleteByPrimaryKey(flightIdToDelete);
        System.out.println("删除结果 (影响行数): " + result);
        // 注意：如果存在外键约束并且没有级联删除，这里可能会返回0或抛异常
        // 如果已处理外键问题，则期望 result > 0
        assertTrue("删除操作应该影响一行", result > 0); // 根据实际情况调整断言

        // 再次查询确保记录已被删除
        TFlight deletedFlight = flightMapper.selectByPrimaryKey(flightIdToDelete);
        assertNull("航班记录应该已被删除", deletedFlight);
    }

    @Test
    public void testSelectByPrimaryKey() {
        System.out.println("--- 测试 selectByPrimaryKey ---");
        // 使用一个存在的航班ID进行查询测试，根据初始数据修改
        Integer flightIdToSelect = 1; // 例如：CA1234 航班
        System.out.println("查询航班ID: " + flightIdToSelect);
        TFlight flight = flightMapper.selectByPrimaryKey(flightIdToSelect);
        System.out.println("查询结果: " + flight);

        assertNotNull("查询结果不应为 null", flight);
        assertEquals("查询到的航班ID应该与查询条件一致", flightIdToSelect, flight.getFlightId());
        // 可以根据初始数据进一步断言其他字段的值
        assertEquals("航班编号应该为CA1234", "CA1234", flight.getFlightNumber());
        assertEquals("航空公司应该为中国国际航空", "中国国际航空", flight.getAirline());
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {
        System.out.println("--- 测试 updateByPrimaryKeySelective ---");
        TFlight flight = new TFlight();
        // 使用一个存在的航班ID进行更新测试，根据初始数据修改
        Integer flightIdToUpdate = 2; // 例如：MU2567 航班
        flight.setFlightId(flightIdToUpdate);
        flight.setAircraftType("新的飞机机型"); // 修改飞机机型
        flight.setSeatCount(160); // 修改座位数

        // 先查询确保记录存在
        TFlight existingFlight = flightMapper.selectByPrimaryKey(flightIdToUpdate);
        assertNotNull("待更新的航班记录应该存在", existingFlight);

        int result = flightMapper.updateByPrimaryKeySelective(flight);
        System.out.println("更新结果 (影响行数): " + result);
        assertTrue("更新操作应该影响一行", result > 0);

        // 查询回来验证更新是否成功
        TFlight updatedFlight = flightMapper.selectByPrimaryKey(flightIdToUpdate);
        assertNotNull("更新后的航班记录应该存在", updatedFlight);
        assertEquals("更新后的飞机机型应该正确", "新的飞机机型", updatedFlight.getAircraftType());
        assertEquals("更新后的座位数应该正确", Integer.valueOf(160), updatedFlight.getSeatCount());
        // 验证其他字段未被改变
        assertEquals("航班编号不应改变", existingFlight.getFlightNumber(), updatedFlight.getFlightNumber());
        assertEquals("航空公司不应改变", existingFlight.getAirline(), updatedFlight.getAirline());
    }

    @Test
    public void testSelectBySelective() throws Exception {
        System.out.println("--- 测试 selectBySelective ---");
        // 测试根据出发港和到达港查询航班
        TFlight query = new TFlight();
        query.setDeparturePort("北京首都国际机场");
        query.setArrivalPort("上海浦东国际机场");
        query.setFlightDate(dateFormat.parse("2023-10-15")); // 添加日期条件

        List<TFlight> flightList = flightMapper.selectSelective(query);
        System.out.println("查询结果列表大小: " + flightList.size());

        assertNotNull("查询结果列表不应为 null", flightList);
        assertTrue("查询结果列表应该包含至少一个符合条件的航班", flightList.size() > 0);

        // 验证查询结果中的航班是否符合条件
        for (TFlight flight : flightList) {
            assertEquals("查询到的航班出发港应该正确", "北京首都国际机场", flight.getDeparturePort());
            assertEquals("查询到的航班到达港应该正确", "上海浦东国际机场", flight.getArrivalPort());
            // 根据需要验证日期等其他字段
        }
    }

    // 添加其他可能的查询方法的测试，例如根据航班日期查询等
    @Test
    public void testSelectByFlightDate() throws Exception {
        System.out.println("--- 测试 selectByFlightDate ---");
        // 使用一个存在的航班日期进行查询测试
        Date flightDateToSearch = dateFormat.parse("2023-10-15");
        System.out.println("根据航班日期查询航班: " + dateFormat.format(flightDateToSearch));

        TFlight query = new TFlight();
        query.setFlightDate(flightDateToSearch);

        List<TFlight> flightList = flightMapper.selectSelective(query);
        System.out.println("查询结果列表大小: " + flightList.size());

        assertNotNull("查询结果列表不应为 null", flightList);
        assertTrue("查询结果列表应该包含该日期的航班", flightList.size() > 0);

        // 验证查询结果中的航班日期是否正确
        for (TFlight flight : flightList) {
            assertEquals("查询到的航班日期应该与查询条件一致", flightDateToSearch, flight.getFlightDate());
        }
    }
}