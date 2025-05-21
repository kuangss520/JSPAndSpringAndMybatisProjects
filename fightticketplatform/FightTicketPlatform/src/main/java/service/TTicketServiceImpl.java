package service;

import mapper.TTicketMapper;
import model.TTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TTicketService;
import java.util.List;

@Service("tTicketService")
public class TTicketServiceImpl implements TTicketService {

    @Autowired
    private TTicketMapper ticketMapper;

    @Override
    public int orderTicket(TTicket record) {
        return ticketMapper.insertSelective(record);
    }

    @Override
    public boolean modifyTicket(TTicket record) {
        return ticketMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean cancelTicket(Integer ticketId) {
        return ticketMapper.deleteByPrimaryKey(ticketId) > 0;
    }

    @Override
    public List<TTicket> getTicketsByFlightId(Integer flightId) {
        TTicket query = new TTicket();
        query.setFlightId(flightId);
        return ticketMapper.selectSelective(query);
    }

    @Override
    public List<TTicket> getTicketsByPassengerId(String idCard) {
        TTicket query = new TTicket();
        query.setIdCard(idCard);
        return ticketMapper.selectSelective(query);
    }

    @Override
    public TTicket getTicketById(Integer ticketId) {
        return ticketMapper.selectByPrimaryKey(ticketId);
    }
}