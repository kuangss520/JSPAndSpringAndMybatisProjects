package service;

import model.THealth_check;
import java.util.List;

public interface THealthCheckService {
    int addHealthCheck(THealth_check record);
    boolean modifyHealthCheck(THealth_check record);
    boolean removeHealthCheck(Integer checkId);
    List<THealth_check> getChecksByAnimalId(String animalId); // 按动物编号查询
    THealth_check getCheckById(Integer checkId);
}