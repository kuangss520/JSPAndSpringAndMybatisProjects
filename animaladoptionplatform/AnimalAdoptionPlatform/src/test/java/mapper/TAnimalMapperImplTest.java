package mapper;

import model.TAnimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * TAnimalMapperImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TAnimalMapperImplTest {

    @Autowired
    private TAnimalMapper animalMapper;

    @Test
    public void deleteByPrimaryKey() {
        System.out.println("--- 测试 TAnimalMapper.deleteByPrimaryKey ---");

        String animalIdToDelete = "A004"; // 示例动物编号，请根据你的数据库实际情况修改
        System.out.println("尝试删除动物编号: " + animalIdToDelete);
        int result = animalMapper.deleteByPrimaryKey(animalIdToDelete);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void insert() {
        System.out.println("--- 测试 TAnimalMapper.insert ---");
        TAnimal animal = new TAnimal();
        // TODO: 填充动物信息，确保 animal_id 唯一
        animal.setAnimalId("ANIMAL_INSERT_" + System.currentTimeMillis() % 10000);
        animal.setAnimalType("狗");
        animal.setBreed("哈士奇");
        animal.setAppearance("黑白相间，眼睛蓝色");
        animal.setPetName("二哈");
        animal.setPhotoUrl("http://example.com/husky.jpg");
        animal.setRemarks("很活泼");
        animal.setPublishTime(new Date()); // 当前时间

        int result = animalMapper.insert(animal);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void insertSelective() {
        System.out.println("--- 测试 TAnimalMapper.insertSelective ---");
        TAnimal animal = new TAnimal();
        // TODO: 填充动物信息，确保 animal_id 唯一
        animal.setAnimalId("ANIMAL_SELECTIVE_" + System.currentTimeMillis() % 100);
        animal.setAnimalType("猫");
        animal.setAppearance("橘黄色");
        animal.setPublishTime(new Date()); // 当前时间
        int result = animalMapper.insertSelective(animal);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println("--- 测试 TAnimalMapper.selectByPrimaryKey ---");
        // TODO: 使用一个存在的动物编号进行查询测试
        String animalIdToSelect = "A001";
        System.out.println("查询动物编号: " + animalIdToSelect);
        TAnimal animal = animalMapper.selectByPrimaryKey(animalIdToSelect);
        System.out.println("结果: " + animal);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        System.out.println("--- 测试 TAnimalMapper.updateByPrimaryKeySelective ---");
        TAnimal animal = new TAnimal();
        // TODO: 使用一个存在的动物编号进行更新测试
        String animalIdToUpdate = "A001";
        System.out.println("尝试更新动物编号: " + animalIdToUpdate);
        animal.setAnimalId(animalIdToUpdate);
        // TODO: 填充需要更新的字段
        animal.setPetName("花花 Updated"); // 更新宠物名称
        animal.setRemarks("性格非常温顺，已绝育"); // 更新备注

        int result = animalMapper.updateByPrimaryKeySelective(animal);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void updateByPrimaryKey() {
        System.out.println("--- 测试 TAnimalMapper.updateByPrimaryKey ---");
        TAnimal animal = new TAnimal();
        // TODO: 使用一个存在的动物编号进行完全更新测试
        String animalIdToUpdate = "A002";
        System.out.println("尝试完全更新动物编号: " + animalIdToUpdate);
        animal.setAnimalId(animalIdToUpdate);
        // TODO: 填充所有字段
        animal.setAnimalType("狗");
        animal.setBreed("金毛巡回猎犬"); // 更新品种
        animal.setAppearance("金黄色长毛，体型较大"); // 更新外形
        animal.setPetName("大黄 Revised"); // 更新名称
        animal.setPhotoUrl("http://example.com/golden_retriever_updated.jpg"); // 更新照片
        animal.setRemarks("非常友好，喜欢玩耍"); // 更新备注
        animal.setPublishTime(new Date()); // 更新发布时间

        int result = animalMapper.updateByPrimaryKey(animal);
        System.out.println("结果 (影响行数): " + result);
    }

    @Test
    public void selectSelective() {
        System.out.println("--- 测试 TAnimalMapper.selectSelective ---");
        TAnimal query = new TAnimal();
        // TODO: 设置查询条件，例如根据动物类型和品种查询
        query.setAnimalType("猫");
        List<TAnimal> animalList = animalMapper.selectSelective(query);
        System.out.println("查询结果列表: " + animalList);
        System.out.println("找到 " + (animalList != null ? animalList.size() : 0) + " 条记录.");
    }
}