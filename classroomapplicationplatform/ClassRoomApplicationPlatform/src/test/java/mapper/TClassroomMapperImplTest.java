package mapper;

import model.TClassroom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * TClassroomMapperImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class TClassroomMapperImplTest {

    @Autowired
    private TClassroomMapper classroomMapper;

    @Test
    public void deleteByPrimaryKey() {
        System.out.println("--- 测试 TClassroomMapper.deleteByPrimaryKey ---");
        // TODO: 使用一个存在的教室ID进行删除测试
        // 注意：删除有外键关联（如 t_application）的记录可能会失败
        // 如果你想测试删除，可以先insert一个新教室，然后删除它。
        Integer classroomIdToDelete = 4; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("尝试删除教室ID: " + classroomIdToDelete);
        int result = classroomMapper.deleteByPrimaryKey(classroomIdToDelete);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void insert() {
        System.out.println("--- 测试 TClassroomMapper.insert ---");
        TClassroom classroom = new TClassroom();
        // classroomId 是自增主键，不需要手动设置
        classroom.setClassroomType("多媒体");
        classroom.setClassroomName("测试教室 Insert " + System.currentTimeMillis());
        classroom.setBuildingName("测试教学楼");
        classroom.setImageUrl("http://example.com/insert_classroom.jpg");
        classroom.setEquipmentDesc("插入测试设备");
        classroom.setCapacity(80);
        classroom.setAdministrator("测试管理员 Insert");
        classroom.setAdminPhone("11111111111");

        int result = classroomMapper.insert(classroom);
        System.out.println("结果 (影响行数): " + result);
        System.out.println("插入的教室ID (如果支持主键回填): " + classroom.getClassroomId());
    }

    @Test
    public void insertSelective() {
        System.out.println("--- 测试 TClassroomMapper.insertSelective ---");
        TClassroom classroom = new TClassroom();
        // classroomId 是自增主键
        classroom.setClassroomType("机房");
        classroom.setClassroomName("测试教室 Selective " + System.currentTimeMillis());
        classroom.setBuildingName("新教学楼");
        classroom.setCapacity(40);
        classroom.setAdministrator("测试管理员 Selective");
        classroom.setAdminPhone("22222222222");
        // imageUrl, equipmentDesc 不设置

        int result = classroomMapper.insertSelective(classroom);
        System.out.println("结果 (影响行数): " + result);
        System.out.println("插入的教室ID (如果支持主键回填): " + classroom.getClassroomId());
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println("--- 测试 TClassroomMapper.selectByPrimaryKey ---");
        // TODO: 使用一个存在的教室ID进行查询测试
        Integer classroomIdToSelect = 1; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("查询教室ID: " + classroomIdToSelect);
        TClassroom classroom = classroomMapper.selectByPrimaryKey(classroomIdToSelect);
        System.out.println("结果: " + classroom);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        System.out.println("--- 测试 TClassroomMapper.updateByPrimaryKeySelective ---");
        TClassroom classroom = new TClassroom();
        // TODO: 使用一个存在的教室ID进行更新测试
        Integer classroomIdToUpdate = 1; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("尝试更新教室ID: " + classroomIdToUpdate);
        classroom.setClassroomId(classroomIdToUpdate);
        // TODO: 填充需要更新的字段
        classroom.setCapacity(150); // 更新容量
        classroom.setAdminPhone("13800138002"); // 更新电话

        int result = classroomMapper.updateByPrimaryKeySelective(classroom);
        System.out.println("结果 (影响行数): " + result);
    }


    @Test
    public void updateByPrimaryKey() {
        System.out.println("--- 测试 TClassroomMapper.updateByPrimaryKey ---");
        TClassroom classroom = new TClassroom();
        // TODO: 使用一个存在的教室ID进行完全更新测试
        Integer classroomIdToUpdate = 3; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("尝试完全更新教室ID: " + classroomIdToUpdate);
        classroom.setClassroomId(classroomIdToUpdate);
        // TODO: 填充所有字段 (不包括 equipmentDesc, updateByPrimaryKeyWithBLOBs 用于带BLOBs的更新)
        classroom.setClassroomType("阶梯教室");
        classroom.setClassroomName("阶梯教室 301 Updated");
        classroom.setBuildingName("第三教学楼");
        classroom.setImageUrl("http://example.com/full_update_classroom3.jpg");
        classroom.setCapacity(220);
        classroom.setAdministrator("李老师 Updated");
        classroom.setAdminPhone("13700137004");
        // equipmentDesc 不在此方法中更新

        int result = classroomMapper.updateByPrimaryKey(classroom);
        System.out.println("结果 (影响行数): " + result);
    }


    @Test
    public void selectSelective() {
        System.out.println("--- 测试 TClassroomMapper.selectSelective ---");
        TClassroom query = new TClassroom();
        // TODO: 设置查询条件，例如根据教室类型和教学楼查询
        query.setClassroomType("多媒体");
        query.setBuildingName("第一教学楼");

        List<TClassroom> classroomList = classroomMapper.selectSelective(query);
        System.out.println("查询结果列表: " + classroomList);
        System.out.println("找到 " + (classroomList != null ? classroomList.size() : 0) + " 条记录.");
    }
}