package mapper;

import model.TFlight;
import model.TPassenger;

import java.util.List;

public interface TPassengerMapper {
    int deleteByPrimaryKey(String idCard);

    int insert(TPassenger record);

    int insertSelective(TPassenger record);

    TPassenger selectByPrimaryKey(String idCard);

    int updateByPrimaryKeySelective(TPassenger record);

    int updateByPrimaryKey(TPassenger record);

    List<TPassenger> selectSelective(TPassenger record);
}