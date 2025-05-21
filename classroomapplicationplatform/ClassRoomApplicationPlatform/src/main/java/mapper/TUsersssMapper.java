package mapper;

import model.TClassroom;
import model.TUsersss;

import java.util.List;

public interface TUsersssMapper {
    int deleteByPrimaryKey(String staffId);

    int insert(TUsersss record);

    int insertSelective(TUsersss record);

    TUsersss selectByPrimaryKey(String staffId);

    int updateByPrimaryKeySelective(TUsersss record);

    int updateByPrimaryKey(TUsersss record);

    List<TUsersss> selectSelective(TUsersss record);
}