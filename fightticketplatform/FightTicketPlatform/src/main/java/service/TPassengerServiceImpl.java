package service;



import mapper.TPassengerMapper;
import model.TPassenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TPassengerService;
import java.util.List;

@Service("tPassengerService")
public class TPassengerServiceImpl implements TPassengerService {

    @Autowired
    private TPassengerMapper passengerMapper;

    @Override
    public int addPassenger(TPassenger record) {
        return passengerMapper.insertSelective(record);
    }

    @Override
    public boolean modifyPassenger(TPassenger record) {
        return passengerMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean removePassenger(String idCard) {
        return passengerMapper.deleteByPrimaryKey(idCard) > 0;
    }

    @Override
    public TPassenger getPassengerByIdCard(String idCard) {
        return passengerMapper.selectByPrimaryKey(idCard);
    }

    @Override
    public TPassenger passengerLogin(String idCard, String password) {
        TPassenger query = new TPassenger();
        query.setIdCard(idCard);
        query.setPassword(password);
        List<TPassenger> list = passengerMapper.selectSelective(query);
        return list.isEmpty() ? null : list.get(0); // 直接判断列表是否为空
    }
}