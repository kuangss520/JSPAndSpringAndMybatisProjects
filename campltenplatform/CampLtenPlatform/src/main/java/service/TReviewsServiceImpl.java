package service;

import mapper.TReviewsMapper;
import model.TReviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 功能:
 * 作者：
 * 日期:2025/5/17 下午7:34
 */
@Service("reviewService")
public class TReviewsServiceImpl implements TReviewsService {

    @Autowired
    private TReviewsMapper reviewsMapper;

    @Override
    public TReviews getReviewById(Integer reviewId) {
        return reviewsMapper.selectByPrimaryKey(reviewId);
    }

    @Override
    public List<TReviews> getReviewsByNovelId(Integer novelId) {
        // 需在TReviewsMapper中添加selectByNovelId方法
        throw new UnsupportedOperationException("需在Mapper中添加selectByNovelId方法");
    }

    @Override
    public int addReview(TReviews review) {
        return reviewsMapper.insertSelective(review);
    }

    @Override
    public boolean updateReview(TReviews review) {
        int count = reviewsMapper.updateByPrimaryKeySelective(review);
        return count > 0;
    }

    @Override
    public boolean deleteReview(Integer reviewId) {
        int count = reviewsMapper.deleteByPrimaryKey(reviewId);
        return count > 0;
    }
}
