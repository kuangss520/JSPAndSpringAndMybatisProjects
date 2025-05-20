package service;

import model.TAdoption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * TAdoptionServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
public class TAdoptionServiceImplTest {

    @Autowired
    private TAdoptionService adoptionService; // 假设Service接口名称是TAdoptionService

    @Test
    public void addAdoption() {
        System.out.println("--- 测试 TAdoptionServiceImpl.addAdoption ---");
        TAdoption adoption = new TAdoption();
        // TODO: 填充领养信息，确保 adoptionId 唯一，并关联存在的 animalId 和 adopterAccount
        adoption.setAdoptionId("ADOPTION_SERVICE_INSERT_" + System.currentTimeMillis() % 10);
        adoption.setAnimalId("A004"); // 关联存在的动物
        adoption.setAdopterAccount("adopter002"); // 关联存在的领养人
        adoption.setAdoptionDate(new Date()); // 当前时间

        int result = adoptionService.addAdoption(adoption);
        System.out.println("添加领养记录结果 (影响行数): " + result);
    }

    @Test
    public void modifyAdoption() {
        System.out.println("--- 测试 TAdoptionServiceImpl.modifyAdoption ---");
        TAdoption adoption = new TAdoption();
        // TODO: 使用一个存在的领养编号进行更新测试
        String adoptionIdToUpdate = "AD001"; // 示例领养编号，请根据你的数据库实际情况修改
        System.out.println("尝试修改领养编号: " + adoptionIdToUpdate);
        adoption.setAdoptionId(adoptionIdToUpdate);
        // TODO: 填充需要更新的字段
        // 注意：animalId 和 adopterAccount 是外键，修改时需确保关联的记录存在
        // adoption.setAnimalId("A003"); // 更改关联动物（示例）
        // adoption.setAdopterAccount("adopter002"); // 更改关联领养人（示例）
        adoption.setAdoptionDate(new Date()); // 更新领养日期

        boolean result = adoptionService.modifyAdoption(adoption);
        System.out.println("修改领养记录结果 (true表示成功): " + result);
    }

    @Test
    public void removeAdoption() {
        System.out.println("--- 测试 TAdoptionServiceImpl.removeAdoption ---");
         // TODO: 替换为实际存在的领养编号进行删除测试
        // 如果你想测试删除，可以先addAdoption一个新领养记录，然后删除它。
        String adoptionIdToDelete = "AD003"; // 示例领养编号，请根据你的数据库实际情况修改
        System.out.println("尝试删除领养编号: " + adoptionIdToDelete);

        boolean result = adoptionService.removeAdoption(adoptionIdToDelete);
        System.out.println("删除领养记录结果 (true表示成功): " + result);
    }

    @Test
    public void getAdoptionByAnimalId() {
        System.out.println("--- 测试 TAdoptionServiceImpl.getAdoptionByAnimalId ---");
        // TODO: 使用一个存在且有领养记录的动物编号进行查询测试
        String animalIdToSelect = "A001"; // 示例动物编号，请根据你的数据库实际情况修改
        System.out.println("查询动物编号对应的领养记录: " + animalIdToSelect);

        TAdoption adoption = adoptionService.getAdoptionByAnimalId(animalIdToSelect);
        System.out.println("查询结果: " + adoption);
    }

    @Test
    public void getAdoptionsByPetName() {
        System.out.println("--- 测试 TAdoptionServiceImpl.getAdoptionsByPetName ---");
        // **注意:** 你提供的 TAdoptionServiceImpl 中 getAdoptionsByPetName 方法实际是根据 adopterAccount 查询，
        // 且查询条件设置的是 adopterAccount 字段，传入的参数 petName 被用作了 account。
        // 如果这个方法应该根据动物的 petName 查询，你需要修改 Service 实现和可能的 Mapper 方法。
        // 这里的测试按照当前 Service 实现来写。
        String adopterAccountToFind = "adopter001"; // 示例领养人账号
        System.out.println("尝试根据 '领养人账号' 查询领养记录 (Service 方法名是 getAdoptionsByPetName): " + adopterAccountToFind);
        System.out.println("注意：Service 方法 getAdoptionsByPetName 实际是根据 adopter_account 查询。");

        List<TAdoption> adoptions = adoptionService.getAdoptionsByPetName(adopterAccountToFind); // 调用 Service 方法
        System.out.println("查询结果列表: " + adoptions);
        System.out.println("找到 " + (adoptions != null ? adoptions.size() : 0) + " 条记录.");

        // 如果 Service 方法 getAdoptionsByPetName 应该根据动物的 petName 查询，且 Service 接口和实现已修改，
        // 请修改此测试为：
        // String petNameToFind = "花花"; // 示例宠物名称
        // System.out.println("尝试根据宠物名称查询领养记录: " + petNameToFind);
        // List<TAdoption> adoptions = adoptionService.getAdoptionsByPetName(petNameToFind);
        // System.out.println("查询结果列表: " + adoptions);
        // System.out.println("找到 " + (adoptions != null ? adoptions.size() : 0) + " 条记录.");
    }

    @Test
    public void getAdoptionsByAdopterAccount() {
        System.out.println("--- 测试 TAdoptionServiceImpl.getAdoptionsByAdopterAccount ---");
         // TODO: 使用一个存在且有领养记录的领养人账号进行查询测试
        String adopterAccountToFind = "adopter001"; // 示例领养人账号
        System.out.println("尝试根据领养人账号查询领养记录: " + adopterAccountToFind);

        List<TAdoption> adoptions = adoptionService.getAdoptionsByAdopterAccount(adopterAccountToFind);
        System.out.println("查询结果列表: " + adoptions);
        System.out.println("找到 " + (adoptions != null ? adoptions.size() : 0) + " 条记录.");
    }
}