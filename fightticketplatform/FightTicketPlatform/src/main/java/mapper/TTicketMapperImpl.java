package mapper;

import model.TTicket;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("ticketMapper")
public class TTicketMapperImpl implements TTicketMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(Integer ticketId) {
        return session.delete("mapper.TTicketMapper.deleteByPrimaryKey", ticketId);
    }

    @Override
    public int insert(TTicket record) {
        return session.insert("mapper.TTicketMapper.insert", record);
    }

    @Override
    public int insertSelective(TTicket record) {
        return session.insert("mapper.TTicketMapper.insertSelective", record);
    }

    @Override
    public TTicket selectByPrimaryKey(Integer ticketId) {
        return session.selectOne("mapper.TTicketMapper.selectByPrimaryKey", ticketId);
    }

    @Override
    public int updateByPrimaryKeySelective(TTicket record) {
        return session.update("mapper.TTicketMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(TTicket record) {
        return session.update("mapper.TTicketMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TTicket> selectSelective(TTicket record) {
        return session.selectList("mapper.TTicketMapper.selectSelective", record);
    }
}