package mapper;

import model.TRentalOrder;

import java.sql.SQLException;
import java.util.List;

public interface TRentalOrderMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(TRentalOrder record);

    /**
     * 创建租赁订单
     *
     * @param record 包含租赁订单信息的TRentalOrder对象
     * @return 影响的行数
     */
    int insertSelective(TRentalOrder record); // 使用insertSelective更灵活

    TRentalOrder selectByPrimaryKey(String orderid);

    /**
     * 修改租赁订单（包括状态或其他字段）
     *
     * @param record 包含更新信息的TRentalOrder对象
     * @return 影响的行数
     */
    int updateByPrimaryKeySelective(TRentalOrder record); // 使用updateByPrimaryKeySelective更灵活


    int updateByPrimaryKey(TRentalOrder record);


    /**
     * 根据订单信息进行动态查询（租赁人ID、订单日期等）
     *
     * @param record 包含查询条件的TRentalOrder对象
     * @return 匹配的订单信息列表
     */
    List<TRentalOrder> selectByOrderLikeSelective(TRentalOrder record);

    /**
     * 查询所有订单信息
     *
     * @return 返回包含所有订单信息的列表
     */
    List<TRentalOrder> selectAllOrders();

}
