package mapper;

import model.TUssrer;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("ussrerMapper")
public class TUssrerMapperImpl implements TUssrerMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(String userAccount) {
        return session.delete("mapper.TUssrerMapper.deleteByPrimaryKey", userAccount);
    }

    @Override
    public int insert(TUssrer record) {
        return session.insert("mapper.TUssrerMapper.insert", record);
    }

    @Override
    public int insertSelective(TUssrer record) {
        return session.insert("mapper.TUssrerMapper.insertSelective", record);
    }

    @Override
    public TUssrer selectByPrimaryKey(String userAccount) {
        return session.selectOne("mapper.TUssrerMapper.selectByPrimaryKey", userAccount);
    }

    @Override
    public int updateByPrimaryKeySelective(TUssrer record) {
        return session.update("mapper.TUssrerMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(TUssrer record) {
        return session.update("mapper.TUssrerMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TUssrer> selectSelective(TUssrer record) {
        return session.selectList("mapper.TUssrerMapper.selectSelective", record);
    }
}