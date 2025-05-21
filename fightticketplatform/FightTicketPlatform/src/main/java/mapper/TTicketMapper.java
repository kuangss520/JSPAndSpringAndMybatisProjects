package mapper;

import model.TFlight;
import model.TTicket;

import java.util.List;

public interface TTicketMapper {
    int deleteByPrimaryKey(Integer ticketId);

    int insert(TTicket record);

    int insertSelective(TTicket record);

    TTicket selectByPrimaryKey(Integer ticketId);

    int updateByPrimaryKeySelective(TTicket record);

    int updateByPrimaryKey(TTicket record);

    List<TTicket> selectSelective(TTicket record);
}