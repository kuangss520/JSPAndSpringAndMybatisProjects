package mapper;

import model.TApplication;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("applicationMapper")
public class TApplicationMapperImpl implements TApplicationMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(Integer applicationId) {
        return session.delete("mapper.TApplicationMapper.deleteByPrimaryKey", applicationId);
    }

    @Override
    public int insert(TApplication record) {
        return session.insert("mapper.TApplicationMapper.insert", record);
    }

    @Override
    public int insertSelective(TApplication record) {
        return session.insert("mapper.TApplicationMapper.insertSelective", record);
    }

    @Override
    public TApplication selectByPrimaryKey(Integer applicationId) {
        return session.selectOne("mapper.TApplicationMapper.selectByPrimaryKey", applicationId);
    }

    @Override
    public int updateByPrimaryKeySelective(TApplication record) {
        return session.update("mapper.TApplicationMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(TApplication record) {
        return session.update("mapper.TApplicationMapper.updateByPrimaryKeyWithBLOBs", record);
    }

    @Override
    public int updateByPrimaryKey(TApplication record) {
        return session.update("mapper.TApplicationMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TApplication> selectSelective(TApplication record) {
        return session.selectList("mapper.TApplicationMapper.selectSelective", record);
    }
}