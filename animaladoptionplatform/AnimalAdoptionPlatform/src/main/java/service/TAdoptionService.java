package service;

import model.TAdoption;
import java.util.List;

public interface TAdoptionService {
    int addAdoption(TAdoption record);
    boolean modifyAdoption(TAdoption record);
    boolean removeAdoption(String adoptionId);
    TAdoption getAdoptionByAnimalId(String animalId); // 按动物编号查询
    List<TAdoption> getAdoptionsByPetName(String petName); // 按宠物名称查询
    List<TAdoption> getAdoptionsByAdopterAccount(String adopterAccount); // 按领养人账号查询
}