package mapper;

import model.TChapters;
import model.TReviews;

import java.util.List;

public interface TReviewsMapper {
    int deleteByPrimaryKey(Integer reviewId);

    int insert(TReviews record);

    int insertSelective(TReviews record);

    TReviews selectByPrimaryKey(Integer reviewId);

    int updateByPrimaryKeySelective(TReviews record);

    int updateByPrimaryKeyWithBLOBs(TReviews record);

    int updateByPrimaryKey(TReviews record);

    List<TReviews> selectSelective(TReviews record);
}