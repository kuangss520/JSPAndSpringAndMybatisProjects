package mapper;

import model.TChapters;
import model.TNovels;

import java.util.List;

public interface TNovelsMapper {
    int deleteByPrimaryKey(Integer novelId);

    int insert(TNovels record);

    int insertSelective(TNovels record);

    TNovels selectByPrimaryKey(Integer novelId);

    int updateByPrimaryKeySelective(TNovels record);

    int updateByPrimaryKeyWithBLOBs(TNovels record);

    int updateByPrimaryKey(TNovels record);

    List<TNovels> selectSelective(TNovels record);
}