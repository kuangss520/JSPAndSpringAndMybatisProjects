package service;

import model.TAnimal;
import java.util.List;

public interface TAnimalService {
    int addAnimal(TAnimal record);
    boolean modifyAnimal(TAnimal record);
    boolean removeAnimal(String animalId);
    TAnimal getAnimalById(String animalId);
    List<TAnimal> getAnimalsByBreed(String breed); // 按品种模糊查询
    List<TAnimal> getAllAnimals();
}