package service.impl;

import mapper.TRentalOrderMapper;
import model.TRentalOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.RentalOrderService;

import java.util.Date;
import java.util.List;

/**
 * 租赁订单管理业务实现类
 */
@Service("rentalOrderService")
public class RentalOrderServiceImpl implements RentalOrderService {

    @Autowired
    private TRentalOrderMapper tRentalOrderMapper;

    /**
     * 创建租赁订单
     * @param order 租赁订单信息
     * @return 创建成功返回true，失败返回false
     */
    @Override
    public boolean createOrder(TRentalOrder order) {
        // 业务逻辑：可以生成订单ID，检查车辆和用户是否存在等
        if (order.getOrderid() == null || order.getOrderid().isEmpty()) {
            // TODO: 实现订单ID生成逻辑
            order.setOrderid("ORD_" + System.currentTimeMillis());
        }
        return tRentalOrderMapper.insertSelective(order) > 0;
    }

    /**
     * 修改订单状态
     * @param orderId 订单ID
     * @param orderStatus 新的订单状态
     * @return 修改成功返回true，失败返回false
     */
    @Override
    public boolean updateOrderStatus(String orderId, String orderStatus) {
        // 业务逻辑：确保订单存在，检查状态是否合法等
        TRentalOrder existingOrder = tRentalOrderMapper.selectByPrimaryKey(orderId);
        if (existingOrder == null) {
            return false; // 订单不存在
        }
        TRentalOrder updateOrder = new TRentalOrder();
        updateOrder.setOrderid(orderId);
        updateOrder.setOrderStatus(orderStatus);
        return tRentalOrderMapper.updateByPrimaryKeySelective(updateOrder) > 0;
    }

    /**
     * 根据租赁人ID查询订单信息
     * @param userId 租赁人用户ID
     * @return 匹配的订单信息列表
     */
    @Override
    public List<TRentalOrder> getOrdersByUserId(String userId) {
        TRentalOrder query = new TRentalOrder();
        query.setUserid(userId);
        return tRentalOrderMapper.selectByOrderLikeSelective(query);
    }

    /**
     * 根据订单日期范围查询订单
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 匹配的订单信息列表
     */
    @Override
    public List<TRentalOrder> getOrdersByDateRange(Date startDate, Date endDate) {
        TRentalOrder query = new TRentalOrder();
        query.setStartTime(startDate);
        query.setEndTime(endDate);
        return tRentalOrderMapper.selectByOrderLikeSelective(query);
    }

    /**
     * 查询所有订单信息
     * @return 所有订单信息列表
     */
    @Override
    public List<TRentalOrder> getAllOrders() {
        return tRentalOrderMapper.selectAllOrders();
    }

    /**
     * 根据订单ID查询订单信息
     * @param orderId 订单ID
     * @return 匹配的订单信息，如果不存在则返回null
     */
    @Override
    public TRentalOrder getOrderById(String orderId) {
        return tRentalOrderMapper.selectByPrimaryKey(orderId);
    }
}
