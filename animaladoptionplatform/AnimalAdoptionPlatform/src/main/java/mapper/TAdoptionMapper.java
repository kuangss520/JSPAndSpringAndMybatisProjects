package mapper;

import model.TAdoption;

import java.util.List;

public interface TAdoptionMapper {
    int deleteByPrimaryKey(String adoptionId);

    int insert(TAdoption record);

    int insertSelective(TAdoption record);

    TAdoption selectByPrimaryKey(String adoptionId);

    int updateByPrimaryKeySelective(TAdoption record);

    int updateByPrimaryKey(TAdoption record);

    List<TAdoption>selectSelective(TAdoption record);
}