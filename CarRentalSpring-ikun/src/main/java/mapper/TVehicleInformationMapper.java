package mapper;

import model.TVehicleInformation;

import java.util.List;

public interface TVehicleInformationMapper {
    int deleteByPrimaryKey(String vehicleid);

    int insert(TVehicleInformation record);

    int insertSelective(TVehicleInformation record);

    TVehicleInformation selectByPrimaryKey(String vehicleid);

    int updateByPrimaryKeySelective(TVehicleInformation record);

    int updateByPrimaryKey(TVehicleInformation record);

    /**
     * 根据车辆ID或类型进行动态查询
     * @param record 包含查询条件的TVehicleInformation对象
     * @return 匹配的车辆信息列表
     */
    List<TVehicleInformation> selectByVehicleLikeSelective(TVehicleInformation record);

    /**
     * 查询所有车辆
     * @return 所有车辆信息列表
     */
    List<TVehicleInformation> selectAllVehicles();
}
