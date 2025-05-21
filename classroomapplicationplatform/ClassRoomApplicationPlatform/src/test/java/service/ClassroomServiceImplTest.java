package service;

import model.TClassroom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * ClassroomServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class ClassroomServiceImplTest {

    @Autowired
    private ClassroomService classroomService; // 假设Service接口名称是ClassroomService

    @Test
    public void addClassroom() {
        System.out.println("--- 测试 ClassroomServiceImpl.addClassroom ---");
        TClassroom classroom = new TClassroom();
        // classroomId 是自增主键，不需要手动设置
        classroom.setClassroomType("专业专用教室");
        classroom.setClassroomName("测试Service添加教室 " + System.currentTimeMillis());
        classroom.setBuildingName("第五教学楼");
        classroom.setImageUrl("http://example.com/service_add_classroom.jpg");
        classroom.setEquipmentDesc("Service添加测试设备");
        classroom.setCapacity(25);
        classroom.setAdministrator("Service 管理员");
        classroom.setAdminPhone("18000000000");

        int result = classroomService.addClassroom(classroom);
        System.out.println("添加教室结果 (影响行数): " + result);
        System.out.println("插入的教室ID (如果Service返回对象或支持主键回填): " + classroom.getClassroomId()); // 可能需要修改Service方法返回类型
    }

    @Test
    public void modifyClassroom() {
        System.out.println("--- 测试 ClassroomServiceImpl.modifyClassroom ---");
        TClassroom classroom = new TClassroom();
        // TODO: 使用一个存在的教室ID进行更新测试
        Integer classroomIdToUpdate = 1; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("尝试修改教室ID: " + classroomIdToUpdate);
        classroom.setClassroomId(classroomIdToUpdate);
        // TODO: 填充需要更新的字段
        classroom.setCapacity(130); // 更新容量
        classroom.setAdministrator("张老师 Updated by Service"); // 更新管理员

        boolean result = classroomService.modifyClassroom(classroom);
        System.out.println("修改教室结果 (true表示成功): " + result);
    }

    @Test
    public void removeClassroom() {
        System.out.println("--- 测试 ClassroomServiceImpl.removeClassroom ---");
         // TODO: 替换为实际存在的教室ID进行删除测试
        // 注意：删除有外键关联（如 t_application）的记录可能会失败
        // 如果你想测试删除，可以先addClassroom一个新教室，然后删除它。
        Integer classroomIdToDelete = 4; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("尝试删除教室ID: " + classroomIdToDelete);

        boolean result = classroomService.removeClassroom(classroomIdToDelete);
        System.out.println("删除教室结果 (true表示成功): " + result);
    }

    @Test
    public void getClassroomById() {
        System.out.println("--- 测试 ClassroomServiceImpl.getClassroomById ---");
        // TODO: 使用一个存在的教室ID进行查询测试
        Integer classroomIdToSelect = 1; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("查询教室ID: " + classroomIdToSelect);

        TClassroom classroom = classroomService.getClassroomById(classroomIdToSelect);
        System.out.println("查询结果: " + classroom);
    }

    @Test
    public void getClassroomsByType() {
        System.out.println("--- 测试 ClassroomServiceImpl.getClassroomsByType ---");
        // TODO: 使用实际存在的教室类型进行查询测试
        String classroomTypeToFind = "多媒体"; // 示例教室类型
        System.out.println("尝试根据教室类型查询: " + classroomTypeToFind);

        List<TClassroom> classrooms = classroomService.getClassroomsByType(classroomTypeToFind);
        System.out.println("查询结果列表: " + classrooms);
        System.out.println("找到 " + (classrooms != null ? classrooms.size() : 0) + " 条记录.");
    }
}