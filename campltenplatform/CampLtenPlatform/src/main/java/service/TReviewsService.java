package service;

import model.TReviews;

import java.util.List;

public interface TReviewsService {

    /**
     * 根据评价ID查询评价
     * @param reviewId 评价ID
     * @return TReviews
     */
    TReviews getReviewById(Integer reviewId);

    /**
     * 根据小说编号查询评价
     * @param novelId 小说ID
     * @return List<TReviews>
     */
    List<TReviews> getReviewsByNovelId(Integer novelId);

    /**
     * 添加评价
     * @param review 评价对象
     * @return 成功返回新评价ID，失败返回0
     */
    int addReview(TReviews review);

    /**
     * 修改评价
     * @param review 评价对象
     * @return 成功返回true，失败返回false
     */
    boolean updateReview(TReviews review);

    /**
     * 删除评价
     * @param reviewId 评价ID
     * @return 成功返回true，失败返回false
     */
    boolean deleteReview(Integer reviewId);
}
