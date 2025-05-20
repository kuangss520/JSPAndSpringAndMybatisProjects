package service;

import mapper.TUserssMapper;
import model.TUserss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TUserssService;
import java.util.List;

@Service("tUserssService")
public class TUserssServiceImpl implements TUserssService {

    @Autowired
    private TUserssMapper userssMapper;

    @Override
    public int addUser(TUserss record) {
        return userssMapper.insertSelective(record);
    }

    @Override
    public boolean modifyUser(TUserss record) {
        return userssMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean removeUser(String account) {
        return userssMapper.deleteByPrimaryKey(account) > 0;
    }

    @Override
    public TUserss getUserByAccount(String account) {
        return userssMapper.selectByPrimaryKey(account);
    }

    @Override
    public TUserss userLogin(String account, String password) {
        // 创建查询条件对象
        TUserss query = new TUserss();
        query.setAccount(account);    // 假设实体类属性为account
        query.setPassword(password);  // 假设实体类有password属性

        // 调用mapper的条件查询方法
        List<TUserss> userList = userssMapper.selectSelective(query);

        // 传统集合操作：判断列表是否为空，非空则返回第一个元素
        return !userList.isEmpty() ? userList.get(0) : null;
    }
}