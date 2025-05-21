package service;

import model.TTicket;
import java.util.List;

/**
 * 机票订购业务接口
 */
public interface TTicketService {

    /**
     * 订购机票
     * @param record 机票信息对象
     * @return 成功返回新机票的主键值，失败返回 0
     */
    int orderTicket(TTicket record);

    /**
     * 修改机票信息
     * @param record 机票信息对象（需包含主键 ID）
     * @return 成功返回 true，失败返回 false
     */
    boolean modifyTicket(TTicket record);

    /**
     * 取消机票（删除）
     * @param ticketId 机票 ID
     * @return 成功返回 true，失败返回 false
     */
    boolean cancelTicket(Integer ticketId);

    /**
     * 查询某航班所有机票
     * @param flightId 航班 ID
     * @return 机票列表
     */
    List<TTicket> getTicketsByFlightId(Integer flightId);

    /**
     * 查询某旅客所有机票
     * @param idCard 旅客身份证号
     * @return 机票列表
     */
    List<TTicket> getTicketsByPassengerId(String idCard);

    /**
     * 查询指定机票信息
     * @param ticketId 机票 ID
     * @return 机票信息对象，不存在返回 null
     */
    TTicket getTicketById(Integer ticketId);
}