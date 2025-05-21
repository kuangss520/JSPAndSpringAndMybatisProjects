package service;

import model.TRentalOrder;

import java.util.Date;
import java.util.List;

/**
 * 租赁订单管理业务接口
 */
public interface RentalOrderService {

    /**
     * 创建租赁订单
     * @param order 租赁订单信息
     * @return 创建成功返回true，失败返回false
     */
    boolean createOrder(TRentalOrder order);

    /**
     * 修改订单状态
     * @param orderId 订单ID
     * @param orderStatus 新的订单状态
     * @return 修改成功返回true，失败返回false
     */
    boolean updateOrderStatus(String orderId, String orderStatus);

    /**
     * 根据租赁人ID查询订单信息
     * @param userId 租赁人用户ID
     * @return 匹配的订单信息列表
     */
    List<TRentalOrder> getOrdersByUserId(String userId);

    /**
     * 根据订单日期范围查询订单
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 匹配的订单信息列表
     */
    List<TRentalOrder> getOrdersByDateRange(Date startDate, Date endDate);

    /**
     * 查询所有订单信息
     * @return 所有订单信息列表
     */
    List<TRentalOrder> getAllOrders();

    /**
     * 根据订单ID查询订单信息
     * @param orderId 订单ID
     * @return 匹配的订单信息，如果不存在则返回null
     */
    TRentalOrder getOrderById(String orderId);
}
