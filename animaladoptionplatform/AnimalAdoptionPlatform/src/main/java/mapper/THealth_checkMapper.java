package mapper;

import model.TAdoption;
import model.THealth_check;

import java.util.List;

public interface THealth_checkMapper {
    int deleteByPrimaryKey(Integer checkId);

    int insert(THealth_check record);

    int insertSelective(THealth_check record);

    THealth_check selectByPrimaryKey(Integer checkId);

    int updateByPrimaryKeySelective(THealth_check record);

    int updateByPrimaryKey(THealth_check record);

    List<THealth_check> selectSelective(THealth_check record);
}