package service;

import model.TClassroom;
import java.util.List;

public interface ClassroomService {
    /**
     * 添加教室
     * @param record 教室信息
     * @return 成功返回新教室的主键值，失败返回0
     */
    int addClassroom(TClassroom record);

    /**
     * 修改教室信息
     * @param record 教室信息（需包含主键ID）
     * @return 成功返回true，失败返回false
     */
    boolean modifyClassroom(TClassroom record);

    /**
     * 删除教室
     * @param classroomId 教室ID
     * @return 成功返回true，失败返回false
     */
    boolean removeClassroom(Integer classroomId);

    /**
     * 根据ID查询教室
     * @param classroomId 教室ID
     * @return 教室信息（不存在返回null）
     */
    TClassroom getClassroomById(Integer classroomId);

    /**
     * 根据教室类型查询教室
     * @param classroomType 教室类型（如"多媒体教室"）
     * @return 教室列表（无结果返回空列表）
     */
    List<TClassroom> getClassroomsByType(String classroomType);
}