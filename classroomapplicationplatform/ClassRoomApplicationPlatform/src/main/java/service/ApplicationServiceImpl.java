package service;

import mapper.TApplicationMapper;
import model.TApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ApplicationService;
import java.util.List;

@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private TApplicationMapper applicationMapper;

    @Override
    public int addApplication(TApplication record) {
        return applicationMapper.insertSelective(record);
    }

    @Override
    public boolean modifyApplication(TApplication record) {
        if (record.getApplicationId() == null) return false;
        return applicationMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean removeApplication(Integer applicationId) {
        return applicationMapper.deleteByPrimaryKey(applicationId) > 0;
    }

    @Override
    public TApplication getApplicationById(Integer applicationId) {
        return applicationMapper.selectByPrimaryKey(applicationId);
    }

    @Override
    public List<TApplication> getApplicationsByClassroom(Integer classroomId) {
        TApplication query = new TApplication();
        query.setClassroomId(classroomId); // 假设实体类包含classroomId字段
        return applicationMapper.selectSelective(query);
    }

    @Override
    public List<TApplication> getApplicationsByApplicant(Integer applicantId) {
        TApplication query = new TApplication();
        query.setApplicationId(applicantId); // 假设实体类包含applicantId字段
        return applicationMapper.selectSelective(query);
    }
}