package mapper;

import model.TAdoption;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("adoptionMapper")
public class TAdoptionMapperImpl implements TAdoptionMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(String adoptionId) {
        return session.delete("mapper.TAdoptionMapper.deleteByPrimaryKey", adoptionId);
    }

    @Override
    public int insert(TAdoption record) {
        return session.insert("mapper.TAdoptionMapper.insert", record);
    }

    @Override
    public int insertSelective(TAdoption record) {
        return session.insert("mapper.TAdoptionMapper.insertSelective", record);
    }

    @Override
    public TAdoption selectByPrimaryKey(String adoptionId) {
        return session.selectOne("mapper.TAdoptionMapper.selectByPrimaryKey", adoptionId);
    }

    @Override
    public int updateByPrimaryKeySelective(TAdoption record) {
        return session.update("mapper.TAdoptionMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(TAdoption record) {
        return session.update("mapper.TAdoptionMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TAdoption> selectSelective(TAdoption record) {
        return session.selectList("mapper.TAdoptionMapper.selectSelective", record);
    }
}