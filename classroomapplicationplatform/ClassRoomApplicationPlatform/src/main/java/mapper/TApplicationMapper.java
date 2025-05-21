package mapper;

import model.TApplication;

import java.util.List;

public interface TApplicationMapper {
    int deleteByPrimaryKey(Integer applicationId);

    int insert(TApplication record);

    int insertSelective(TApplication record);

    TApplication selectByPrimaryKey(Integer applicationId);

    int updateByPrimaryKeySelective(TApplication record);

    int updateByPrimaryKeyWithBLOBs(TApplication record);

    int updateByPrimaryKey(TApplication record);

    List<TApplication>  selectSelective(TApplication record);
}