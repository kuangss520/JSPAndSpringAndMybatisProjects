package mapper;

import model.TFlight;

import java.util.List;

public interface TFlightMapper {
    int deleteByPrimaryKey(Integer flightId);

    int insert(TFlight record);

    int insertSelective(TFlight record);

    TFlight selectByPrimaryKey(Integer flightId);

    int updateByPrimaryKeySelective(TFlight record);

    int updateByPrimaryKey(TFlight record);

    List<TFlight> selectSelective(TFlight record);
}