package mapper;

import model.TAdmin;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("adminMapper")
public class TAdminMapperImpl implements TAdminMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(String adminAccount) {
        return session.delete("mapper.TAdminMapper.deleteByPrimaryKey", adminAccount);
    }

    @Override
    public int insert(TAdmin record) {
        return session.insert("mapper.TAdminMapper.insert", record);
    }

    @Override
    public int insertSelective(TAdmin record) {
        return session.insert("mapper.TAdminMapper.insertSelective", record);
    }

    @Override
    public TAdmin selectByPrimaryKey(String adminAccount) {
        return session.selectOne("mapper.TAdminMapper.selectByPrimaryKey", adminAccount);
    }

    @Override
    public int updateByPrimaryKeySelective(TAdmin record) {
        return session.update("mapper.TAdminMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(TAdmin record) {
        return session.update("mapper.TAdminMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TAdmin> selectSelective(TAdmin record) {
        return session.selectList("mapper.TAdminMapper.selectSelective", record);
    }
}