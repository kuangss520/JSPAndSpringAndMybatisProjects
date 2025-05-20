package service;

import mapper.THealth_checkMapper;
import model.THealth_check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.THealthCheckService;
import java.util.List;

@Service("healthCheckService")
public class THealthCheckServiceImpl implements THealthCheckService {

    @Autowired
    private THealth_checkMapper healthCheckMapper;

    @Override
    public int addHealthCheck(THealth_check record) {
        return healthCheckMapper.insertSelective(record);
    }

    @Override
    public boolean modifyHealthCheck(THealth_check record) {
        return healthCheckMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean removeHealthCheck(Integer checkId) {
        return healthCheckMapper.deleteByPrimaryKey(checkId) > 0;
    }

    @Override
    public List<THealth_check> getChecksByAnimalId(String animalId) {
        THealth_check query = new THealth_check();
        query.setAnimalId(animalId); // 假设实体类包含animalId字段
        return healthCheckMapper.selectSelective(query);
    }

    @Override
    public THealth_check getCheckById(Integer checkId) {
        return healthCheckMapper.selectByPrimaryKey(checkId);
    }
}