package service;

import model.TVehicleInformation;

import java.util.List;

/**
 * 车辆管理业务接口
 */
public interface VehicleService {

    /**
     * 添加车辆
     * @param vehicle 车辆信息
     * @return 添加成功返回true，失败返回false
     */
    boolean addVehicle(TVehicleInformation vehicle);

    /**
     * 修改车辆信息
     * @param vehicle 车辆信息
     * @return 修改成功返回true，失败返回false
     */
    boolean modifyVehicle(TVehicleInformation vehicle);

    /**
     * 删除车辆
     * @param vehicleId 车辆ID（车牌号）
     * @return 删除成功返回true，失败返回false
     */
    boolean removeVehicle(String vehicleId);

    /**
     * 根据车辆ID（车牌号）查询租赁车辆
     * @param vehicleId 车辆ID
     * @return 匹配的车辆信息，如果不存在则返回null
     */
    TVehicleInformation getVehicleById(String vehicleId);

    /**
     * 根据租赁车辆类型查询租赁车辆
     * @param vehicleType 车辆类型
     * @return 匹配的车辆信息列表
     */
    List<TVehicleInformation> getVehiclesByType(String vehicleType);

    /**
     * 查询所有租赁车辆
     * @return 所有租赁车辆信息列表
     */
    List<TVehicleInformation> getAllVehicles();
}
