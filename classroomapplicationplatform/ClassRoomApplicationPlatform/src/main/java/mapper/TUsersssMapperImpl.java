package mapper;

import model.TUsersss;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("usersssMapper")
public class TUsersssMapperImpl implements TUsersssMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(String staffId) {
        return session.delete("mapper.TUsersssMapper.deleteByPrimaryKey", staffId);
    }

    @Override
    public int insert(TUsersss record) {
        return session.insert("mapper.TUsersssMapper.insert", record);
    }

    @Override
    public int insertSelective(TUsersss record) {
        return session.insert("mapper.TUsersssMapper.insertSelective", record);
    }

    @Override
    public TUsersss selectByPrimaryKey(String staffId) {
        return session.selectOne("mapper.TUsersssMapper.selectByPrimaryKey", staffId);
    }

    @Override
    public int updateByPrimaryKeySelective(TUsersss record) {
        return session.update("mapper.TUsersssMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(TUsersss record) {
        return session.update("mapper.TUsersssMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TUsersss> selectSelective(TUsersss record) {
        return session.selectList("mapper.TUsersssMapper.selectSelective", record);
    }
}