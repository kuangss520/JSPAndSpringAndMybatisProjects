package mapper;

import model.TAdoption;
import model.TAnimal;

import java.util.List;

public interface TAnimalMapper {
    int deleteByPrimaryKey(String animalId);

    int insert(TAnimal record);

    int insertSelective(TAnimal record);

    TAnimal selectByPrimaryKey(String animalId);

    int updateByPrimaryKeySelective(TAnimal record);

    int updateByPrimaryKey(TAnimal record);

    List<TAnimal> selectSelective(TAnimal record);
}