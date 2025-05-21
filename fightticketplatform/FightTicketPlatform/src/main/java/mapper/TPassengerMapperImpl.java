package mapper;

import model.TPassenger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("passengerMapper")
public class TPassengerMapperImpl implements TPassengerMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(String idCard) {
        return session.delete("mapper.TPassengerMapper.deleteByPrimaryKey", idCard);
    }

    @Override
    public int insert(TPassenger record) {
        return session.insert("mapper.TPassengerMapper.insert", record);
    }

    @Override
    public int insertSelective(TPassenger record) {
        return session.insert("mapper.TPassengerMapper.insertSelective", record);
    }

    @Override
    public TPassenger selectByPrimaryKey(String idCard) {
        return session.selectOne("mapper.TPassengerMapper.selectByPrimaryKey", idCard);
    }

    @Override
    public int updateByPrimaryKeySelective(TPassenger record) {
        return session.update("mapper.TPassengerMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(TPassenger record) {
        return session.update("mapper.TPassengerMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TPassenger> selectSelective(TPassenger record) {
        return session.selectList("mapper.TPassengerMapper.selectSelective", record);
    }
}