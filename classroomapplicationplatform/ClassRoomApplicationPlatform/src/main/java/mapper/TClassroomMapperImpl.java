package mapper;

import model.TClassroom;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("classroomMapper")
public class TClassroomMapperImpl implements TClassroomMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(Integer classroomId) {
        return session.delete("mapper.TClassroomMapper.deleteByPrimaryKey", classroomId);
    }

    @Override
    public int insert(TClassroom record) {
        return session.insert("mapper.TClassroomMapper.insert", record);
    }

    @Override
    public int insertSelective(TClassroom record) {
        return session.insert("mapper.TClassroomMapper.insertSelective", record);
    }

    @Override
    public TClassroom selectByPrimaryKey(Integer classroomId) {
        return session.selectOne("mapper.TClassroomMapper.selectByPrimaryKey", classroomId);
    }

    @Override
    public int updateByPrimaryKeySelective(TClassroom record) {
        return session.update("mapper.TClassroomMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(TClassroom record) {
        return session.update("mapper.TClassroomMapper.updateByPrimaryKeyWithBLOBs", record);
    }

    @Override
    public int updateByPrimaryKey(TClassroom record) {
        return session.update("mapper.TClassroomMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TClassroom> selectSelective(TClassroom record) {
        return session.selectList("mapper.TClassroomMapper.selectSelective", record);
    }
}