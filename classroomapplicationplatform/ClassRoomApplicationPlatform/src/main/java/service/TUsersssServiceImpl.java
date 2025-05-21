package service;

import mapper.TUsersssMapper;
import model.TUsersss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TUsersssService;

import java.util.List;

@Service("usersssService")
public class TUsersssServiceImpl implements TUsersssService {

    @Autowired
    private TUsersssMapper usersssMapper;

    @Override
    public int registerUser(TUsersss record) {
        // 使用insertSelective实现选择性插入，返回影响行数
        return usersssMapper.insertSelective(record);
    }

    @Override
    public TUsersss login(String staffId, String password) {
        // 构造查询条件
        TUsersss query = new TUsersss();
        query.setStaffId(staffId);    // 假设staffId为账号字段
        query.setPassword(password);  // 假设实体类包含password字段

        // 调用mapper查询
        List<TUsersss> userList = usersssMapper.selectSelective(query);
        if (!userList.isEmpty()) {
            return userList.get(0); // 返回查询到的第一个用户（假设账号唯一）
        }
        return null;
    }

    @Override
    public boolean modifyUser(TUsersss record) {
        // 校验主键是否存在
        if (record.getStaffId() == null) {
            return false;
        }
        // 使用updateByPrimaryKeySelective更新非空字段
        return usersssMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public boolean removeUser(String staffId) {
        // 调用deleteByPrimaryKey删除用户
        return usersssMapper.deleteByPrimaryKey(staffId) > 0;
    }
}