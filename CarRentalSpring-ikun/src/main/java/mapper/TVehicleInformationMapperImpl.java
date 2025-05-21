package mapper;

import model.TVehicleInformation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("tVehicleInformationMapper")
public class TVehicleInformationMapperImpl implements TVehicleInformationMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;

    @Override
    public int deleteByPrimaryKey(String vehicleid) {
        return session.delete("mapper.TVehicleInformationMapper.deleteByPrimaryKey", vehicleid);
    }

    @Override
    public int insert(TVehicleInformation record) {
        return session.insert("mapper.TVehicleInformationMapper.insert", record);
    }

    @Override
    public int insertSelective(TVehicleInformation record) {
        return session.insert("mapper.TVehicleInformationMapper.insertSelective", record);
    }

    @Override
    public TVehicleInformation selectByPrimaryKey(String vehicleid) {
        return session.selectOne("mapper.TVehicleInformationMapper.selectByPrimaryKey", vehicleid);
    }

    @Override
    public int updateByPrimaryKeySelective(TVehicleInformation record) {
        return session.update("mapper.TVehicleInformationMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(TVehicleInformation record) {
        return session.update("mapper.TVehicleInformationMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TVehicleInformation> selectByVehicleLikeSelective(TVehicleInformation record) {
        return session.selectList("mapper.TVehicleInformationMapper.selectByVehicleLikeSelective", record);
    }

    @Override
    public List<TVehicleInformation> selectAllVehicles() {
        return session.selectList("mapper.TVehicleInformationMapper.selectAllVehicles");
    }
}
