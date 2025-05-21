package mapper;

import model.TUserInformation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


@Repository("tUserInformationMapper")
public class TUserInformationMapperImpl implements TUserInformationMapper{

    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSession;

    @Override
    public int deleteByPrimaryKey(String userid) {
        return sqlSession.delete("mapper.TUserInformationMapper.deleteByPrimaryKey",userid);
    }

    @Override
    public int insert(TUserInformation record) {
        // 通常使用 insertSelective，如果需要完整的 insert，请确保record包含所有字段
        return sqlSession.insert("mapper.TUserInformationMapper.insert",record);
    }

    @Override
    public int insertSelective(TUserInformation record) {
        return sqlSession.insert("mapper.TUserInformationMapper.insertSelective",record);
    }

    @Override
    public TUserInformation selectByPrimaryKey(String userid) {
        return sqlSession.selectOne("mapper.TUserInformationMapper.selectByPrimaryKey",userid);
    }

    @Override
    public int updateByPrimaryKeySelective(TUserInformation record) {
        return sqlSession.update("mapper.TUserInformationMapper.updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(TUserInformation record) {
        // 通常使用 updateByPrimaryKeySelective，如果需要完整的 update，请确保record包含所有字段
        return sqlSession.update("mapper.TUserInformationMapper.updateByPrimaryKey",record);
    }

    @Override
    public List<TUserInformation> selectAllUserSelective(TUserInformation record) {
        return sqlSession.selectList("mapper.TUserInformationMapper.selectAllUserSelective", record);
    }
}
