package service.impl;

import mapper.TClassroomMapper;
import model.TClassroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ClassroomService;
import java.util.List;

@Service("classroomService")
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private TClassroomMapper classroomMapper;

    @Override
    public int addClassroom(TClassroom record) {
        // 使用insertSelective实现选择性插入，返回影响行数（主键自增时需配合主键回填）
        return classroomMapper.insertSelective(record);
    }

    @Override
    public boolean modifyClassroom(TClassroom record) {
        // 要求必须包含classroomId才能修改
        if (record.getClassroomId() == null) return false;
        return classroomMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean removeClassroom(Integer classroomId) {
        return classroomMapper.deleteByPrimaryKey(classroomId) > 0;
    }

    @Override
    public TClassroom getClassroomById(Integer classroomId) {
        return classroomMapper.selectByPrimaryKey(classroomId);
    }

    @Override
    public List<TClassroom> getClassroomsByType(String classroomType) {
        TClassroom query = new TClassroom();
        query.setClassroomType(classroomType); // 假设实体类包含classroomType字段
        return classroomMapper.selectSelective(query);
    }
}