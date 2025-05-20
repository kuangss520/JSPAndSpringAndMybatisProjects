package mapper;

import model.TAdoption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * TAdoptionMapperImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class TAdoptionMapperImplTest {

    @Autowired
    private TAdoptionMapper adoptionMapper;

    @Test
    public void deleteByPrimaryKey() {
        System.out.println("--- 测试 TAdoptionMapper.deleteByPrimaryKey ---");
        // TODO: 使用一个存在的领养编号进行删除测试
        // 如果你想测试删除，可以先insert一个新领养记录，然后删除它。
        String adoptionIdToDelete = "AD003"; // 示例领养编号，请根据你的数据库实际情况修改
        System.out.println("尝试删除领养编号: " + adoptionIdToDelete);
        int result = adoptionMapper.deleteByPrimaryKey(adoptionIdToDelete);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void insert() {
        System.out.println("--- 测试 TAdoptionMapper.insert ---");
        TAdoption adoption = new TAdoption();
        // TODO: 填充领养信息，确保 adoption_id 唯一，并关联存在的 animal_id 和 adopter_account
        adoption.setAdoptionId("ADOPTION_INSERT_" + System.currentTimeMillis() % 10000);
        adoption.setAnimalId("A004"); // 关联存在的动物
        adoption.setAdopterAccount("adopter002"); // 关联存在的领养人
        adoption.setAdoptionDate((new Date())); // 当前时间

        int result = adoptionMapper.insert(adoption);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void insertSelective() {
        System.out.println("--- 测试 TAdoptionMapper.insertSelective ---");
        TAdoption adoption = new TAdoption();
        // TODO: 填充领养信息，确保 adoption_id 唯一，并关联存在的 animal_id 和 adopter_account
        adoption.setAdoptionId("ADOPTION_SELECTIVE_" + System.currentTimeMillis() % 100);
        adoption.setAnimalId("A003"); // 关联存在的动物
        adoption.setAdopterAccount("adopter002"); // 关联存在的领养人
        // adoptionDate 不设置，测试选择性插入（如果数据库允许默认值）

        int result = adoptionMapper.insertSelective(adoption);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println("--- 测试 TAdoptionMapper.selectByPrimaryKey ---");
        // TODO: 使用一个存在的领养编号进行查询测试
        String adoptionIdToSelect = "AD001"; // 示例领养编号，请根据你的数据库实际情况修改
        System.out.println("查询领养编号: " + adoptionIdToSelect);
        TAdoption adoption = adoptionMapper.selectByPrimaryKey(adoptionIdToSelect);
        System.out.println("结果: " + adoption);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        System.out.println("--- 测试 TAdoptionMapper.updateByPrimaryKeySelective ---");
        TAdoption adoption = new TAdoption();
        // TODO: 使用一个存在的领养编号进行更新测试
        String adoptionIdToUpdate = "AD001"; // 示例领养编号，请根据你的数据库实际情况修改
        System.out.println("尝试更新领养编号: " + adoptionIdToUpdate);
        adoption.setAdoptionId(adoptionIdToUpdate);
        // TODO: 填充需要更新的字段
        adoption.setAdoptionDate((new Date())); // 更新领养日期

        int result = adoptionMapper.updateByPrimaryKeySelective(adoption);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void updateByPrimaryKey() {
        System.out.println("--- 测试 TAdoptionMapper.updateByPrimaryKey ---");
        TAdoption adoption = new TAdoption();
        // TODO: 使用一个存在的领养编号进行完全更新测试
        String adoptionIdToUpdate = "AD002"; // 示例领养编号，请根据你的数据库实际情况修改
        System.out.println("尝试完全更新领养编号: " + adoptionIdToUpdate);
        adoption.setAdoptionId(adoptionIdToUpdate);
        // TODO: 填充所有字段
        adoption.setAnimalId("A004"); // 更改关联动物
        adoption.setAdopterAccount("adopter001"); // 更改关联领养人
        adoption.setAdoptionDate((new Date())); // 更新日期

        int result = adoptionMapper.updateByPrimaryKey(adoption);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void selectSelective() {
        System.out.println("--- 测试 TAdoptionMapper.selectSelective ---");
        TAdoption query = new TAdoption();
        // TODO: 设置查询条件，例如根据动物编号和领养人账号查询
        query.setAnimalId("A001");
        // query.setAdopterAccount("adopter001");

        List<TAdoption> adoptionList = adoptionMapper.selectSelective(query);
        System.out.println("查询结果列表: " + adoptionList);
        System.out.println("找到 " + (adoptionList != null ? adoptionList.size() : 0) + " 条记录.");
    }
}