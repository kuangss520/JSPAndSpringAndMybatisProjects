package mapper;

import model.TApplication;
import model.TClassroom;

import java.util.List;

public interface TClassroomMapper {
    int deleteByPrimaryKey(Integer classroomId);

    int insert(TClassroom record);

    int insertSelective(TClassroom record);

    TClassroom selectByPrimaryKey(Integer classroomId);

    int updateByPrimaryKeySelective(TClassroom record);

    int updateByPrimaryKeyWithBLOBs(TClassroom record);

    int updateByPrimaryKey(TClassroom record);

    List<TClassroom> selectSelective(TClassroom record);
}