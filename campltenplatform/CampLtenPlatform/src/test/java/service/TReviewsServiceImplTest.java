package service;

import model.TReviews;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@Rollback(true) // 测试完成后回滚事务
public class TReviewsServiceImplTest {

    @Autowired
    private TReviewsService reviewService;

    @Test
    public void testGetReviewById() {
        System.out.println("--- 测试 getReviewById (TReviewsService) ---");
        // 使用一个存在的评价ID进行查询测试，根据初始数据修改
        Integer reviewIdToSelect = 1; // 假设 review with ID 1 存在
        System.out.println("查询评价ID: " + reviewIdToSelect);

        TReviews review = reviewService.getReviewById(reviewIdToSelect);
        System.out.println("查询结果: " + review);
    }

    @Test
    public void testGetReviewsByNovelId() {
        System.out.println("--- 测试 getReviewsByNovelId (TReviewsService) ---");

        Integer novelIdToFind = 1; // 示例小说ID
        System.out.println("尝试根据小说ID查询评价: " + novelIdToFind);

        try {
            List<TReviews> reviews = reviewService.getReviewsByNovelId(novelIdToFind);
            System.out.println("查询结果列表: " + reviews);
            System.out.println("找到 " + (reviews != null ? reviews.size() : 0) + " 条记录.");
        } catch (UnsupportedOperationException e) {
            System.out.println("Service 方法 getReviewsByNovelId 尚未实现: " + e.getMessage());
        }
    }

    @Test
    public void testAddReview() {
        System.out.println("--- 测试 addReview (TReviewsService) ---");
        TReviews review = new TReviews();
        review.setNovelId(1); // 假设 novel with ID 1 存在
        review.setAccount("reader1"); // 假设 'reader1' 存在
        review.setRating((byte) 7);
        review.setComment("测试Service添加评论 " + System.currentTimeMillis());

        int result = reviewService.addReview(review);
        System.out.println("添加评价结果 (影响行数): " + result);
    }

    @Test
    public void testUpdateReview() {
        System.out.println("--- 测试 updateReview (TReviewsService) ---");
        TReviews review = new TReviews();
        // 使用一个存在的评价ID进行更新测试，根据初始数据修改
        Integer reviewIdToUpdate = 2; // 假设 review with ID 2 存在 (novel_id=1, reader2)
        System.out.println("尝试修改评价ID: " + reviewIdToUpdate);
        review.setReviewId(reviewIdToUpdate);
        review.setRating((byte) 5); // 更改评分
        review.setComment("更新后的Service评论 " + System.currentTimeMillis()); // 更新评论

        boolean result = reviewService.updateReview(review);
        System.out.println("修改评价结果 (true表示成功): " + result);
    }

    @Test
    public void testDeleteReview() {
        System.out.println("--- 测试 deleteReview (TReviewsService) ---");
         // 插入一个测试评价用于删除
        TReviews reviewToDelete = new TReviews();
        reviewToDelete.setNovelId(2); // 假设 novel with ID 2 存在
        reviewToDelete.setAccount("reader2"); // 假设 'reader2' 存在
        reviewToDelete.setRating((byte) 1);
        reviewToDelete.setComment("待删除Service评论 " + System.currentTimeMillis());
        reviewService.addReview(reviewToDelete); // 先添加评价
        Integer reviewIdToDelete = reviewToDelete.getReviewId();
        System.out.println("插入待删除评价ID: " + reviewIdToDelete);


        System.out.println("尝试删除评价ID: " + reviewIdToDelete);
        boolean result = reviewService.deleteReview(reviewIdToDelete);
        System.out.println("删除评价结果 (true表示成功): " + result);
    }
}