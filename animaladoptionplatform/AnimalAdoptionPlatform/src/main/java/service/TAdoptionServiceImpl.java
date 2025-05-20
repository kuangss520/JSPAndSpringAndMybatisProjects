package service;

import mapper.TAdoptionMapper;
import mapper.TAnimalMapper;
import model.TAdoption;
import model.TAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TAdoptionService;
import service.TAnimalService;

import java.util.List;

@Service("adoptionService")
public class TAdoptionServiceImpl implements TAdoptionService {

    @Autowired
    private TAdoptionMapper adoptionMapper;

    @Override
    public int addAdoption(TAdoption record) {
        return adoptionMapper.insertSelective(record);
    }

    @Override
    public boolean modifyAdoption(TAdoption record) {
        return adoptionMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean removeAdoption(String adoptionId) {
        return adoptionMapper.deleteByPrimaryKey(adoptionId) > 0;
    }

    @Override
    public TAdoption getAdoptionByAnimalId(String animalId) {
        TAdoption query = new TAdoption();
        query.setAnimalId(animalId); // 假设实体类包含animalId字段

        // 使用传统方式替代 Stream
        List<TAdoption> adoptions = adoptionMapper.selectSelective(query);
        if (adoptions != null && !adoptions.isEmpty()) {
            return adoptions.get(0);
        }
        return null;
    }

    @Override
    public List<TAdoption> getAdoptionsByPetName(String petName) {
        TAdoption query = new TAdoption();
        query.setAdopterAccount(petName); // 假设实体类包含petName字段
        return adoptionMapper.selectSelective(query);
    }

    @Override
    public List<TAdoption> getAdoptionsByAdopterAccount(String adopterAccount) {
        TAdoption query = new TAdoption();
        query.setAdopterAccount(adopterAccount); // 假设实体类包含adopterAccount字段
        return adoptionMapper.selectSelective(query);
    }
}