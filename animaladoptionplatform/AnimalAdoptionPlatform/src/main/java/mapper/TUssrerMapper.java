package mapper;

import model.TAdoption;
import model.TUssrer;

import java.util.List;

public interface TUssrerMapper {
    int deleteByPrimaryKey(String userAccount);

    int insert(TUssrer record);

    int insertSelective(TUssrer record);

    TUssrer selectByPrimaryKey(String userAccount);

    int updateByPrimaryKeySelective(TUssrer record);

    int updateByPrimaryKey(TUssrer record);

    List<TUssrer> selectSelective(TUssrer record);

}