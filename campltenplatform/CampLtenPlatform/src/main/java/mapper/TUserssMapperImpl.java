package mapper;

import model.TUserss;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("userssMapper")
public class TUserssMapperImpl implements TUserssMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(String account) {
        return session.delete("mapper.TUserssMapper.deleteByPrimaryKey", account);
    }

    @Override
    public int insert(TUserss record) {
        return session.insert("mapper.TUserssMapper.insert", record);
    }

    @Override
    public int insertSelective(TUserss record) {
        return session.insert("mapper.TUserssMapper.insertSelective", record);
    }

    @Override
    public TUserss selectByPrimaryKey(String account) {
        return session.selectOne("mapper.TUserssMapper.selectByPrimaryKey", account);
    }

    @Override
    public int updateByPrimaryKeySelective(TUserss record) {
        return session.update("mapper.TUserssMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(TUserss record) {
        return session.update("mapper.TUserssMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TUserss> selectSelective(TUserss record) {
        return session.selectList("mapper.TUserssMapper.selectSelective", record);
    }
}
