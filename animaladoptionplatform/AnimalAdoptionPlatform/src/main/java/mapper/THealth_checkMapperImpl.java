package mapper;

import model.THealth_check;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("healthCheckMapper")
public class THealth_checkMapperImpl implements THealth_checkMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(Integer checkId) {
        return session.delete("mapper.THealth_checkMapper.deleteByPrimaryKey", checkId);
    }

    @Override
    public int insert(THealth_check record) {
        return session.insert("mapper.THealth_checkMapper.insert", record);
    }

    @Override
    public int insertSelective(THealth_check record) {
        return session.insert("mapper.THealth_checkMapper.insertSelective", record);
    }

    @Override
    public THealth_check selectByPrimaryKey(Integer checkId) {
        return session.selectOne("mapper.THealth_checkMapper.selectByPrimaryKey", checkId);
    }

    @Override
    public int updateByPrimaryKeySelective(THealth_check record) {
        return session.update("mapper.THealth_checkMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(THealth_check record) {
        return session.update("mapper.THealth_checkMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<THealth_check> selectSelective(THealth_check record) {
        return session.selectList("mapper.THealth_checkMapper.selectSelective", record);
    }
}