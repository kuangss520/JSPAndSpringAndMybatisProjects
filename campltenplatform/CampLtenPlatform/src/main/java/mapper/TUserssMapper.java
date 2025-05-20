package mapper;

import model.TChapters;
import model.TUserss;

import java.util.List;

public interface TUserssMapper {
    int deleteByPrimaryKey(String account);

    int insert(TUserss record);

    int insertSelective(TUserss record);

    TUserss selectByPrimaryKey(String account);

    int updateByPrimaryKeySelective(TUserss record);

    int updateByPrimaryKey(TUserss record);

    List<TUserss> selectSelective(TUserss record);
}