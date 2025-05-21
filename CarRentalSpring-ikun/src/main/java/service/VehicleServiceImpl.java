package service.impl;

import mapper.TVehicleInformationMapper;
import model.TVehicleInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.VehicleService;

import java.util.List;

/**
 * 车辆管理业务实现类
 */
@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private TVehicleInformationMapper tVehicleInformationMapper;

    /**
     * 添加车辆
     * @param vehicle 车辆信息
     * @return 添加成功返回true，失败返回false
     */
    @Override
    public boolean addVehicle(TVehicleInformation vehicle) {
        // 业务逻辑：检查车辆ID是否已存在等
        if (tVehicleInformationMapper.selectByPrimaryKey(vehicle.getVehicleid()) != null) {
            return false; // 车辆ID已存在
        }
        return tVehicleInformationMapper.insertSelective(vehicle) > 0;
    }

    /**
     * 修改车辆信息
     * @param vehicle 车辆信息
     * @return 修改成功返回true，失败返回false
     */
    @Override
    public boolean modifyVehicle(TVehicleInformation vehicle) {
        // 业务逻辑：确保车辆存在
        if (tVehicleInformationMapper.selectByPrimaryKey(vehicle.getVehicleid()) == null) {
            return false; // 车辆不存在
        }
        return tVehicleInformationMapper.updateByPrimaryKeySelective(vehicle) > 0;
    }

    /**
     * 删除车辆
     * @param vehicleId 车辆ID（车牌号）
     * @return 删除成功返回true，失败返回false
     */
    @Override
    public boolean removeVehicle(String vehicleId) {
        // 业务逻辑：确保车辆存在，可以检查是否有未完成的订单等
        if (tVehicleInformationMapper.selectByPrimaryKey(vehicleId) == null) {
            return false; // 车辆不存在
        }
        return tVehicleInformationMapper.deleteByPrimaryKey(vehicleId) > 0;
    }

    /**
     * 根据车辆ID（车牌号）查询租赁车辆
     * @param vehicleId 车辆ID
     * @return 匹配的车辆信息，如果不存在则返回null
     */
    @Override
    public TVehicleInformation getVehicleById(String vehicleId) {
        return tVehicleInformationMapper.selectByPrimaryKey(vehicleId);
    }

    /**
     * 根据租赁车辆类型查询租赁车辆
     * @param vehicleType 车辆类型
     * @return 匹配的车辆信息列表
     */
    @Override
    public List<TVehicleInformation> getVehiclesByType(String vehicleType) {
        TVehicleInformation query = new TVehicleInformation();
        query.setVehicletype(vehicleType);
        return tVehicleInformationMapper.selectByVehicleLikeSelective(query);
    }

    /**
     * 查询所有租赁车辆
     * @return 所有租赁车辆信息列表
     */
    @Override
    public List<TVehicleInformation> getAllVehicles() {
        return tVehicleInformationMapper.selectAllVehicles();
    }
}
