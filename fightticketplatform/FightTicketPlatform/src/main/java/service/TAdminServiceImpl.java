package service;



import mapper.TAdminMapper;
import model.TAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TAdminService;
import java.util.List;

@Service("tAdminService")
public class TAdminServiceImpl implements TAdminService {

    @Autowired
    private TAdminMapper adminMapper;

    @Override
    public TAdmin adminLogin(String adminAccount, String password) {
        TAdmin query = new TAdmin();
        query.setAdminAccount(adminAccount);
        query.setPassword(password);
        List<TAdmin> list = adminMapper.selectSelective(query);
        return list.isEmpty() ? null : list.get(0); // 直接判断列表是否为空
    }
}