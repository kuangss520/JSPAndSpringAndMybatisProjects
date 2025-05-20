package mapper;

import model.TReviews;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 功能:
 * 作者：
 * 日期:2025/5/17 下午4:26
 */

@Repository("reviewsMapper")
public class TReviewsMapperImpl implements TReviewsMapper {
    @Resource(name = "sqlSession")
    private SqlSessionTemplate session;


    @Override
    public int deleteByPrimaryKey(Integer reviewId) {
        return session.delete("mapper.TReviewsMapper.deleteByPrimaryKey", reviewId);
    }

    @Override
    public int insert(TReviews record) {
        return session.insert("mapper.TReviewsMapper.insert", record);
    }

    @Override
    public int insertSelective(TReviews record) {
        return session.insert("mapper.TReviewsMapper.insertSelective", record);
    }

    @Override
    public TReviews selectByPrimaryKey(Integer reviewId) {
        return session.selectOne("mapper.TReviewsMapper.selectByPrimaryKey", reviewId);
    }

    @Override
    public int updateByPrimaryKeySelective(TReviews record) {
        return session.update("mapper.TReviewsMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(TReviews record) {
        return session.update("mapper.TReviewsMapper.updateByPrimaryKeyWithBLOBs", record);
    }

    @Override
    public int updateByPrimaryKey(TReviews record) {
        return session.update("mapper.TReviewsMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TReviews> selectSelective(TReviews record) {
        return session.selectList("mapper.TReviewsMapper.selectSelective", record);
    }


}
