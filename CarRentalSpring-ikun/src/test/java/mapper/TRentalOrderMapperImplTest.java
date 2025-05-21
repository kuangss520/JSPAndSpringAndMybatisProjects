package mapper;

import model.TRentalOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * TRentalOrderMapperImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的Spring配置文件路径
@Transactional // 开启事务，测试后可以回滚
@Rollback(true) // 测试后回滚数据库修改
public class TRentalOrderMapperImplTest {

    @Autowired
    private TRentalOrderMapper tRentalOrderMapper;

    /**
     * 测试根据主键删除租赁订单
     */
    @Test
    public void testDeleteByPrimaryKey() {
        System.out.println("--- 测试 deleteByPrimaryKey ---");
        // TODO: 替换为实际存在的订单ID进行测试
        String orderIdToDelete = "1"; // 示例ID，请根据你的数据库实际情况修改
        int result = tRentalOrderMapper.deleteByPrimaryKey(orderIdToDelete);
        System.out.println("删除结果 (影响行数): " + result);

    }

    /**
     * 测试插入租赁订单（所有字段）
     */
    @Test
    public void testInsert() {
        System.out.println("--- 测试 insert ---");
        TRentalOrder order = new TRentalOrder();
        // TODO: 填充订单信息，确保OrderId唯一
        order.setOrderid("ORD_NEW_" + System.currentTimeMillis());
        order.setVehicleid("V001"); // 确保车辆ID存在
        order.setUserid("U001"); // 确保用户ID存在
        order.setStartTime(new Date());
        order.setEndTime(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)); // 假设租赁一天
        order.setVehiclestatus("已出库");
        order.setRemarks("测试订单");
        order.setOrderStatus("已下单");
        order.setOrderprice(new BigDecimal("200.00").longValue()); // 注意类型转换

        int result = tRentalOrderMapper.insert(order);
        System.out.println("插入结果 (影响行数): " + result);

    }

    /**
     * 测试选择性插入租赁订单
     */
    @Test
    public void testInsertSelective() {
        System.out.println("--- 测试 insertSelective ---");
        TRentalOrder order = new TRentalOrder();
        // TODO: 填充部分订单信息，确保OrderId唯一
        order.setOrderid("ORD_SELECTIVE_" + System.currentTimeMillis());
        order.setVehicleid("V002"); // 确保车辆ID存在
        order.setUserid("U002"); // 确保用户ID存在
        order.setStartTime(new Date());
        order.setOrderStatus("处理中");
        order.setEndTime(new Date(System.currentTimeMillis() + 48 * 60 * 60 * 1000));

        int result = tRentalOrderMapper.insertSelective(order);
        System.out.println("选择性插入结果 (影响行数): " + result);

    }

    /**
     * 测试根据主键查询租赁订单
     */
    @Test
    public void testSelectByPrimaryKey() {
        System.out.println("--- 测试 selectByPrimaryKey ---");
        // TODO: 替换为实际存在的订单ID进行测试
        String orderIdToSelect = "1"; // 示例ID，请根据你的数据库实际情况修改
        TRentalOrder order = tRentalOrderMapper.selectByPrimaryKey(orderIdToSelect);
        System.out.println("查询结果: " + order);

    }

    /**
     * 测试根据主键选择性更新租赁订单信息
     */
    @Test
    public void testUpdateByPrimaryKeySelective() {
        System.out.println("--- 测试 updateByPrimaryKeySelective ---");
        TRentalOrder order = new TRentalOrder();
        // TODO: 替换为实际存在的订单ID进行测试
        String orderIdToUpdate = "1"; // 示例ID，请根据你的数据库实际情况修改
        order.setOrderid(orderIdToUpdate);
        // TODO: 填充需要更新的字段
        order.setOrderStatus("已完成"); // 更新订单状态
        order.setRemarks("订单已完成"); // 更新备注

        int result = tRentalOrderMapper.updateByPrimaryKeySelective(order);
        System.out.println("选择性更新结果 (影响行数): " + result);

    }

    /**
     * 测试根据主键更新租赁订单信息（所有字段）
     */
    @Test
    public void testUpdateByPrimaryKey() {
        System.out.println("--- 测试 updateByPrimaryKey ---");
        TRentalOrder order = new TRentalOrder();
        // TODO: 替换为实际存在的订单ID进行测试
        String orderIdToUpdate = "1"; // 示例ID，请根据你的数据库实际情况修改
        order.setOrderid(orderIdToUpdate);
        // TODO: 填充所有字段（即使有些字段值不变）
        order.setVehicleid("V001"); // 确保车辆ID存在
        order.setUserid("U001"); // 确保用户ID存在
        order.setStartTime(new Date());
        order.setEndTime(new Date(System.currentTimeMillis() + 48 * 60 * 60 * 1000)); // 假设租赁两天
        order.setVehiclestatus("已入库");
        order.setRemarks("更新后的备注");
        order.setOrderStatus("已取消");
        order.setOrderprice(new BigDecimal("400.00").longValue()); // 注意类型转换

        int result = tRentalOrderMapper.updateByPrimaryKey(order);
        System.out.println("更新结果 (影响行数): " + result);

    }

    /**
     * 测试根据订单信息进行动态查询（租赁人ID、订单日期等）
     */
    @Test
    public void testSelectByOrderLikeSelective() {
        System.out.println("--- 测试 selectByOrderLikeSelective ---");
        TRentalOrder query = new TRentalOrder();

        // TODO: 设置查询条件，例如根据租赁人ID查询
        query.setUserid("U001");


        List<TRentalOrder> orderList = tRentalOrderMapper.selectByOrderLikeSelective(query);
        System.out.println("查询结果数量: " + orderList.size());

    }

    /**
     * 测试查询所有订单信息
     */
    @Test
    public void testSelectAllOrders() {
        System.out.println("--- 测试 selectAllOrders ---");
        List<TRentalOrder> orderList = tRentalOrderMapper.selectAllOrders();
        System.out.println("所有订单数量: " + orderList.size());

    }
}
