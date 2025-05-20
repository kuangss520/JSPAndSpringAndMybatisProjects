







package service;

import mapper.TAnimalMapper;
import model.TAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TAnimalService;
import java.util.List;

@Service("animalService")
public class TAnimalServiceImpl implements TAnimalService {

    @Autowired
    private TAnimalMapper animalMapper;

    @Override
    public int addAnimal(TAnimal record) {
        return animalMapper.insertSelective(record);
    }

    @Override
    public boolean modifyAnimal(TAnimal record) {
        return animalMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean removeAnimal(String animalId) {
        return animalMapper.deleteByPrimaryKey(animalId) > 0;
    }

    @Override
    public TAnimal getAnimalById(String animalId) {
        return animalMapper.selectByPrimaryKey(animalId);
    }

    @Override
    public List<TAnimal> getAnimalsByBreed(String breed) {
        TAnimal query = new TAnimal();
        query.setBreed(breed); // 假设实体类字段为animalBreed
        return animalMapper.selectSelective(query);
    }

    @Override
    public List<TAnimal> getAllAnimals() {
        return animalMapper.selectSelective(new TAnimal());
    }
}