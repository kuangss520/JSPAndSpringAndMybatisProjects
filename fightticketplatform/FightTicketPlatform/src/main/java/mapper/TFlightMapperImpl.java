package mapper;

import model.TFlight;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("flightMapper")
public class TFlightMapperImpl implements TFlightMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(Integer flightId) {
        return session.delete("mapper.TFlightMapper.deleteByPrimaryKey", flightId);
    }

    @Override
    public int insert(TFlight record) {
        return session.insert("mapper.TFlightMapper.insert", record);
    }

    @Override
    public int insertSelective(TFlight record) {
        return session.insert("mapper.TFlightMapper.insertSelective", record);
    }

    @Override
    public TFlight selectByPrimaryKey(Integer flightId) {
        return session.selectOne("mapper.TFlightMapper.selectByPrimaryKey", flightId);
    }

    @Override
    public int updateByPrimaryKeySelective(TFlight record) {
        return session.update("mapper.TFlightMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(TFlight record) {
        return session.update("mapper.TFlightMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TFlight> selectSelective(TFlight record) {
        return session.selectList("mapper.TFlightMapper.selectSelective", record);
    }
}