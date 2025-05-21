package mapper;

import model.TUserInformation;

import java.util.List;

public interface TUserInformationMapper {
    int deleteByPrimaryKey(String userid);

    int insert(TUserInformation record);

    int insertSelective(TUserInformation record);

    TUserInformation selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(TUserInformation record);

    int updateByPrimaryKey(TUserInformation record);

    /**
     * 根据用户信息进行动态查询（用户ID、用户名等）
     * @param record 包含查询条件的TUserInformation对象
     * @return 匹配的用户信息列表
     */
    List<TUserInformation> selectAllUserSelective(TUserInformation record);
}
