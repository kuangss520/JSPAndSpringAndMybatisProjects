package mapper;

import model.TRentalOrder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("tRentalOrderMapper")
public class TRentalOrderMapperImpl implements TRentalOrderMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSession;

    @Override
    public int deleteByPrimaryKey(String orderid) {
        return sqlSession.delete("mapper.TRentalOrderMapper.deleteByPrimaryKey", orderid);
    }

    @Override
    public int insert(TRentalOrder record) {
        // 通常使用 insertSelective，如果需要完整的 insert，请确保record包含所有字段
        return sqlSession.insert("mapper.TRentalOrderMapper.insert", record);
    }

    @Override
    public int insertSelective(TRentalOrder record) {
        return sqlSession.insert("mapper.TRentalOrderMapper.insertSelective", record);
    }

    @Override
    public TRentalOrder selectByPrimaryKey(String orderid) {
        return sqlSession.selectOne("mapper.TRentalOrderMapper.selectByPrimaryKey", orderid);
    }

    @Override
    public int updateByPrimaryKeySelective(TRentalOrder record) {
        return sqlSession.update("mapper.TRentalOrderMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(TRentalOrder record) {
        // 通常使用 updateByPrimaryKeySelective，如果需要完整的 update，请确保record包含所有字段
        return sqlSession.update("mapper.TRentalOrderMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TRentalOrder> selectByOrderLikeSelective(TRentalOrder record) {
        return sqlSession.selectList("mapper.TRentalOrderMapper.selectByOrderLikeSelective", record);
    }

    @Override
    public List<TRentalOrder> selectAllOrders() {
        return sqlSession.selectList("mapper.TRentalOrderMapper.selectAllOrders");
    }
}
