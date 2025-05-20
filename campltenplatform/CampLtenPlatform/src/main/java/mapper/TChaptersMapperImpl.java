package mapper;

import model.TChapters;
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


@Repository("chaptersMapper")
public class TChaptersMapperImpl implements TChaptersMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;


    @Override
    public int deleteByPrimaryKey(Integer chapterId) {
        return session.delete("mapper.TChaptersMapper.deleteByPrimaryKey", chapterId);
    }

    @Override
    public int insert(TChapters record) {
        return session.insert("mapper.TChaptersMapper.insert", record);
    }

    @Override
    public int insertSelective(TChapters record) {
        return session.insert("mapper.TChaptersMapper.insertSelective", record);
    }

    @Override
    public TChapters selectByPrimaryKey(Integer chapterId) {
        return session.selectOne("mapper.TChaptersMapper.selectByPrimaryKey", chapterId);
    }

    @Override
    public int updateByPrimaryKeySelective(TChapters record) {
        return session.update("mapper.TChaptersMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(TChapters record) {
        return session.update("mapper.TChaptersMapper.updateByPrimaryKeyWithBLOBs", record);
    }

    @Override
    public int updateByPrimaryKey(TChapters record) {
        return session.update("mapper.TChaptersMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TChapters> selectSelective(TChapters record) {
        return session.selectList("mapper.TChaptersMapper.selectSelective", record);
    }
}
