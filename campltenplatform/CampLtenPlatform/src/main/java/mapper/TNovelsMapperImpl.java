package mapper;

import model.TNovels;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 功能:
 * 作者：
 * 日期:2025/5/17 下午4:24
 */

@Repository("novelsMapper")
public class TNovelsMapperImpl implements TNovelsMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;


    @Override
    public int deleteByPrimaryKey(Integer novelId) {
        return session.delete("TNovelsMapper.deleteByPrimaryKey", novelId);
    }

    @Override
    public int insert(TNovels record) {
        return session.insert("mapper.TNovelsMapper.insert", record);
    }

    @Override
    public int insertSelective(TNovels record) {
        return session.insert("mapper.TNovelsMapper.insertSelective", record);
    }

    @Override
    public TNovels selectByPrimaryKey(Integer novelId) {
        return session.selectOne("mapper.TNovelsMapper.selectByPrimaryKey", novelId);
    }

    @Override
    public int updateByPrimaryKeySelective(TNovels record) {
        return session.update("mapper.TNovelsMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(TNovels record) {
        return session.update("mapper.TNovelsMapper.updateByPrimaryKeyWithBLOBs", record);
    }

    @Override
    public int updateByPrimaryKey(TNovels record) {
        return session.update("mapper.TNovelsMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TNovels> selectSelective(TNovels record) {
        return session.selectList("mapper.TNovelsMapper.selectSelective", record);
    }
}
