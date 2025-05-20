package service;

import mapper.TUssrerMapper;
import model.TUssrer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TUssrerService;

@Service("ussrerService")
public class TUssrerServiceImpl implements TUssrerService {

    @Autowired
    private TUssrerMapper ussrerMapper;

    @Override
    public int addUser(TUssrer record) {
        return ussrerMapper.insertSelective(record);
    }

    @Override
    public boolean modifyUser(TUssrer record) {
        return ussrerMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean removeUser(String userAccount) {
        return ussrerMapper.deleteByPrimaryKey(userAccount) > 0;
    }

    @Override
    public TUssrer getUserByAccount(String userAccount) {
        return ussrerMapper.selectByPrimaryKey(userAccount);
    }

    @Override
    public TUssrer login(String userAccount, String password) {
        TUssrer query = new TUssrer();
        query.setUserAccount(userAccount);
        query.setPassword(password);

        // 使用传统方式替代 Stream
        java.util.List<TUssrer> users = ussrerMapper.selectSelective(query);
        if (users != null && !users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }
}