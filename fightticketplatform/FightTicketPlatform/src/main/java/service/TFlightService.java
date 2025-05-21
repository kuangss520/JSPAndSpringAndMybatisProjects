package service;

import model.TFlight;
import java.util.List;

/**
 * 航班业务接口
 */
public interface TFlightService {

    /**
     * 添加航班
     * @param record 航班信息对象
     * @return 成功返回新航班的主键值，失败返回 0
     */
    int addFlight(TFlight record);

    /**
     * 修改航班信息
     * @param record 航班信息对象（需包含主键 ID）
     * @return 成功返回 true，失败返回 false
     */
    boolean modifyFlight(TFlight record);

    /**
     * 删除航班
     * @param flightId 航班 ID
     * @return 成功返回 true，失败返回 false
     */
    boolean removeFlight(Integer flightId);

    /**
     * 根据 ID 查询航班
     * @param flightId 航班 ID
     * @return 航班信息对象，不存在返回 null
     */
    TFlight getFlightById(Integer flightId);

    /**
     * 根据始发站和到达港查询航班
     * @param departureStation 始发站
     * @param arrivalPort 到达港
     * @return 符合条件的航班列表
     */
    List<TFlight> getFlightsByStation(String departureStation, String arrivalPort);

    /**
     * 查询所有航班信息
     * @return 航班列表（空列表表示无数据）
     */
    List<TFlight> getAllFlights();
}