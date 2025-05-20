package mapper;

import model.TAnimal;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("animalMapper")
public class TAnimalMapperImpl implements TAnimalMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(String animalId) {
        return session.delete("mapper.TAnimalMapper.deleteByPrimaryKey", animalId);
    }

    @Override
    public int insert(TAnimal record) {
        return session.insert("mapper.TAnimalMapper.insert", record);
    }

    @Override
    public int insertSelective(TAnimal record) {
        return session.insert("mapper.TAnimalMapper.insertSelective", record);
    }

    @Override
    public TAnimal selectByPrimaryKey(String animalId) {
        return session.selectOne("mapper.TAnimalMapper.selectByPrimaryKey", animalId);
    }

    @Override
    public int updateByPrimaryKeySelective(TAnimal record) {
        return session.update("mapper.TAnimalMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(TAnimal record) {
        return session.update("mapper.TAnimalMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TAnimal> selectSelective(TAnimal record) {
        return session.selectList("mapper.TAnimalMapper.selectSelective", record);
    }
}