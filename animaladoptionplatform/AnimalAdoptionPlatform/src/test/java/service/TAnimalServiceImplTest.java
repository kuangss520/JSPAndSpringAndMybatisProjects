package service;

import model.TAnimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * TAnimalServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class TAnimalServiceImplTest {

    @Autowired
    private TAnimalService animalService; // 假设Service接口名称是TAnimalService

    @Test
    public void addAnimal() {
        System.out.println("--- 测试 TAnimalServiceImpl.addAnimal ---");
        TAnimal animal = new TAnimal();
        // TODO: 填充动物信息，确保 animalId 唯一
        animal.setAnimalId("ANIMAL_SERVICE_INSERT_" + System.currentTimeMillis() % 10000);
        animal.setAnimalType("其他");
        animal.setBreed("兔子");
        animal.setAppearance("白色短毛，红眼睛");
        animal.setPetName("小白");
        animal.setPhotoUrl("http://example.com/rabbit.jpg");
        animal.setRemarks("很可爱，喜欢吃胡萝卜");
        animal.setPublishTime(new Date()); // 当前时间

        int result = animalService.addAnimal(animal);
        System.out.println("添加动物结果 (影响行数): " + result);
    }

    @Test
    public void modifyAnimal() {
        System.out.println("--- 测试 TAnimalServiceImpl.modifyAnimal ---");
        TAnimal animal = new TAnimal();
        // TODO: 使用一个存在的动物编号进行更新测试
        String animalIdToUpdate = "A001"; // 示例动物编号，请根据你的数据库实际情况修改
        System.out.println("尝试修改动物编号: " + animalIdToUpdate);
        animal.setAnimalId(animalIdToUpdate);
        // TODO: 填充需要更新的字段
        animal.setPetName("花花 Revised"); // 更新宠物名称
        animal.setRemarks("性格非常温顺，已绝育并完成疫苗接种"); // 更新备注

        boolean result = animalService.modifyAnimal(animal);
        System.out.println("修改动物结果 (true表示成功): " + result);
    }

    @Test
    public void removeAnimal() {
        System.out.println("--- 测试 TAnimalServiceImpl.removeAnimal ---");
         // TODO: 替换为实际存在的动物编号进行删除测试
        // 注意：删除有外键关联（如 t_adoption, t_health_check）的记录可能会失败
        // 如果你想测试删除，可以先addAnimal一个新动物，然后删除它。
        String animalIdToDelete = "A004"; // 示例动物编号，请根据你的数据库实际情况修改
        System.out.println("尝试删除动物编号: " + animalIdToDelete);

        boolean result = animalService.removeAnimal(animalIdToDelete);
        System.out.println("删除动物结果 (true表示成功): " + result);
    }

    @Test
    public void getAnimalById() {
        System.out.println("--- 测试 TAnimalServiceImpl.getAnimalById ---");
        // TODO: 使用一个存在的动物编号进行查询测试
        String animalIdToSelect = "A002"; // 示例动物编号，请根据你的数据库实际情况修改
        System.out.println("查询动物编号: " + animalIdToSelect);

        TAnimal animal = animalService.getAnimalById(animalIdToSelect);
        System.out.println("查询结果: " + animal);
    }

    @Test
    public void getAnimalsByBreed() {
        System.out.println("--- 测试 TAnimalServiceImpl.getAnimalsByBreed ---");
        // TODO: 使用实际存在的品种进行查询测试
        String breedToFind = "金毛"; // 示例品种
        System.out.println("尝试根据品种查询动物: " + breedToFind);

        List<TAnimal> animals = animalService.getAnimalsByBreed(breedToFind);
        System.out.println("查询结果列表: " + animals);
        System.out.println("找到 " + (animals != null ? animals.size() : 0) + " 条记录.");
    }

    @Test
    public void getAllAnimals() {
        System.out.println("--- 测试 TAnimalServiceImpl.getAllAnimals ---");
        System.out.println("尝试查询所有动物");
        List<TAnimal> allAnimals = animalService.getAllAnimals();
        System.out.println("查询结果列表: " + allAnimals);
        System.out.println("找到 " + (allAnimals != null ? allAnimals.size() : 0) + " 条记录.");
    }
}