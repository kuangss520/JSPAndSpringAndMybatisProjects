package mapper;

import model.TAdmin;
import model.TFlight;

import java.util.List;

public interface TAdminMapper {
    int deleteByPrimaryKey(String adminAccount);

    int insert(TAdmin record);

    int insertSelective(TAdmin record);

    TAdmin selectByPrimaryKey(String adminAccount);

    int updateByPrimaryKeySelective(TAdmin record);

    int updateByPrimaryKey(TAdmin record);

    List<TAdmin> selectSelective(TAdmin record);
}