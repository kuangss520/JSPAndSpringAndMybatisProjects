package service;

import mapper.TFlightMapper;
import model.TFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TFlightService;
import java.util.List;

@Service("tFlightService")
public class TFlightServiceImpl implements TFlightService {

    @Autowired
    private TFlightMapper flightMapper;

    @Override
    public int addFlight(TFlight record) {
        return flightMapper.insertSelective(record);
    }

    @Override
    public boolean modifyFlight(TFlight record) {
        return flightMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean removeFlight(Integer flightId) {
        return flightMapper.deleteByPrimaryKey(flightId) > 0;
    }

    @Override
    public TFlight getFlightById(Integer flightId) {
        return flightMapper.selectByPrimaryKey(flightId);
    }

    @Override
    public List<TFlight> getFlightsByStation(String departureStation, String arrivalPort) {
        TFlight query = new TFlight();
        query.setDeparturePort(departureStation);
        query.setArrivalPort(arrivalPort);
        return flightMapper.selectSelective(query);
    }

    @Override
    public List<TFlight> getAllFlights() {
        return flightMapper.selectSelective(new TFlight());
    }
}