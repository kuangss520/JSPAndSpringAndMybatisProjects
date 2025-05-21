package service;

import model.TRentalOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * RentalOrderServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的Spring配置文件路径
@Transactional // 开启事务，测试后可以回滚
@Rollback(true) // 测试后回滚数据库修改
public class RentalOrderServiceImplTest {

    @Autowired
    private RentalOrderService rentalOrderService;

    /**
     * 测试创建租赁订单
     */
    @Test
    public void testCreateOrder() {
        System.out.println("--- 测试 createOrder ---");
        TRentalOrder order = new TRentalOrder();
        // TODO: 填充订单信息，可以不设置OrderId，Service层会生成
        order.setVehicleid("V001"); // 确保车辆ID存在
        order.setUserid("U001"); // 确保用户ID存在
        order.setStartTime(new Date());
        order.setEndTime(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)); // 假设租赁一天
        order.setVehiclestatus("已出库");
        order.setRemarks("Service测试订单");
        order.setOrderStatus("已下单");
        // order.setOrderprice(new BigDecimal("200.00").longValue()); // 价格可以在Service层计算

        boolean result = rentalOrderService.createOrder(order);
        System.out.println("创建结果: " + result);

    }

    /**
     * 测试修改订单状态
     */
    @Test
    public void testUpdateOrderStatus() {
        System.out.println("--- 测试 updateOrderStatus ---");
        // TODO: 替换为实际存在的订单ID进行测试
        String orderIdToUpdate = "1"; // 示例ID，请根据你的数据库实际情况修改
        String newStatus = "已完成";

        boolean result = rentalOrderService.updateOrderStatus(orderIdToUpdate, newStatus);
        System.out.println("修改状态结果: " + result);

    }

    /**
     * 测试根据租赁人ID查询订单信息
     */
    @Test
    public void testGetOrdersByUserId() {
        System.out.println("--- 测试 getOrdersByUserId ---");
        // TODO: 替换为实际存在的用户ID进行测试
        String userIdToSelect = "U001"; // 示例ID，请根据你的数据库实际情况修改
        List<TRentalOrder> orderList = rentalOrderService.getOrdersByUserId(userIdToSelect);
        System.out.println("查询结果数量: " + orderList.size());

    }

    /**
     * 测试根据订单日期范围查询订单
     */
    @Test
    public void testGetOrdersByDateRange() {
        System.out.println("--- 测试 getOrdersByDateRange ---");
        // TODO: 设置实际的日期范围进行测试
        Date startDate = new Date(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000); // 一周前
        Date endDate = new Date(); // 当前时间

        List<TRentalOrder> orderList = rentalOrderService.getOrdersByDateRange(startDate, endDate);
        System.out.println("查询结果数量: " + orderList.size());

    }

    /**
     * 测试查询所有订单信息
     */
    @Test
    public void testGetAllOrders() {
        System.out.println("--- 测试 getAllOrders ---");
        List<TRentalOrder> orderList = rentalOrderService.getAllOrders();
        System.out.println("所有订单数量: " + orderList.size());

    }

    /**
     * 测试根据订单ID查询订单信息
     */
    @Test
    public void testGetOrderById() {
        System.out.println("--- 测试 getOrderById ---");
        // TODO: 替换为实际存在的订单ID进行测试
        String orderIdToSelect = "1"; // 示例ID，请根据你的数据库实际情况修改
        TRentalOrder order = rentalOrderService.getOrderById(orderIdToSelect);
        System.out.println("查询结果: " + order);

    }
}
