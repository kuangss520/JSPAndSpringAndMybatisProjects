package mapper;

import model.TReviews;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
@Transactional // 添加事务管理，测试后自动回滚数据
public class TReviewsMapperImplTest {

    @Autowired
    private TReviewsMapper reviewsMapper;

    @Test
    public void deleteByPrimaryKey() {
        System.out.println("--- 测试 deleteByPrimaryKey (TReviews) ---");
        // 插入一个测试评价用于删除
        TReviews reviewToDelete = new TReviews();
        reviewToDelete.setNovelId(1); // 假设 novel with ID 1 exists
        reviewToDelete.setAccount("reader1"); // 假设 reader1 exists
        reviewToDelete.setRating((byte) 1);
        reviewToDelete.setComment("待删除评论 " + System.currentTimeMillis());
        int insertResult = reviewsMapper.insert(reviewToDelete);
        System.out.println("插入待删除评价结果 (影响行数): " + insertResult);
        Integer reviewIdToDelete = reviewToDelete.getReviewId();
        System.out.println("插入待删除评价ID: " + reviewIdToDelete);

        int deleteResult = reviewsMapper.deleteByPrimaryKey(reviewIdToDelete);
        System.out.println("删除结果 (影响行数): " + deleteResult);

        TReviews deletedReview = reviewsMapper.selectByPrimaryKey(reviewIdToDelete);
        System.out.println("查询删除后的评价: " + deletedReview);
    }

    @Test
    public void insert() {
        System.out.println("--- 测试 insert (TReviews) ---");
        TReviews review = new TReviews();
        review.setNovelId(2); // 假设 novel with ID 2 exists
        review.setAccount("reader2"); // 假设 reader2 exists
        review.setRating((byte) 9);
        review.setComment("测试评论 Insert " + System.currentTimeMillis());

        int result = reviewsMapper.insert(review);
        System.out.println("插入结果 (影响行数): " + result);

        // Assuming insert populates review.reviewId
        System.out.println("插入的评价ID: " + review.getReviewId());
        TReviews insertedReview = reviewsMapper.selectByPrimaryKey(review.getReviewId());
        System.out.println("查询插入的评价: " + insertedReview);
    }

    @Test
    public void insertSelective() {
        System.out.println("--- 测试 insertSelective (TReviews) ---");
        TReviews review = new TReviews();
        review.setNovelId(3); // 假设 novel with ID 3 exists
        review.setAccount("reader1"); // 假设 reader1 exists
        review.setRating((byte) 6);
        // comment 不设置

        int result = reviewsMapper.insertSelective(review);
        System.out.println("选择性插入结果 (影响行数): " + result);

        System.out.println("选择性插入的评价ID: " + review.getReviewId());
        TReviews insertedReview = reviewsMapper.selectByPrimaryKey(review.getReviewId());
        System.out.println("查询选择性插入的评价: " + insertedReview);
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println("--- 测试 selectByPrimaryKey (TReviews) ---");
        // 使用一个存在的评价ID进行查询测试，根据初始数据修改
        Integer reviewIdToSelect = 1; // 根据你的初始数据
        System.out.println("查询评价ID: " + reviewIdToSelect);
        TReviews review = reviewsMapper.selectByPrimaryKey(reviewIdToSelect);
        System.out.println("查询结果: " + review);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        System.out.println("--- 测试 updateByPrimaryKeySelective (TReviews) ---");
        // 使用一个存在的评价ID进行更新测试，根据初始数据修改
        Integer reviewIdToUpdate = 2; // 根据你的初始数据 (novel_id=1, reader2)
        System.out.println("更新评价ID (选择性): " + reviewIdToUpdate);

        TReviews review = new TReviews();
        review.setReviewId(reviewIdToUpdate);
        review.setRating((byte) 10); // 更新评分
        review.setComment("更新后的评论 " + System.currentTimeMillis()); // 更新评论

        int result = reviewsMapper.updateByPrimaryKeySelective(review);
        System.out.println("更新结果 (影响行数): " + result);

        TReviews updatedReview = reviewsMapper.selectByPrimaryKey(reviewIdToUpdate);
        System.out.println("查询更新后的评价: " + updatedReview);
    }

    @Test
    public void updateByPrimaryKey() {
        System.out.println("--- 测试 updateByPrimaryKey (TReviews) ---");
        // 插入一个测试评价用于完全更新
        TReviews reviewToUpdate = new TReviews();
        reviewToUpdate.setNovelId(4);
        reviewToUpdate.setAccount("reader2");
        reviewToUpdate.setRating((byte) 2);
        reviewToUpdate.setComment("原始评论 " + System.currentTimeMillis());
        int insertResult = reviewsMapper.insert(reviewToUpdate);
        System.out.println("插入待完全更新评价结果 (影响行数): " + insertResult);
        Integer reviewIdToUpdate = reviewToUpdate.getReviewId();
        System.out.println("插入待完全更新评价ID: " + reviewIdToUpdate);

        TReviews review = new TReviews();
        review.setReviewId(reviewIdToUpdate);
        review.setNovelId(4); // 仍然关联小说ID 4
        review.setAccount("reader1"); // 更改用户
        review.setRating((byte) 7); // 更改评分
        review.setComment("完全更新后的评论 " + System.currentTimeMillis()); // 完全更新评论

        int result = reviewsMapper.updateByPrimaryKey(review);
        System.out.println("完全更新结果 (影响行数): " + result);

        TReviews updatedReview = reviewsMapper.selectByPrimaryKey(reviewIdToUpdate);
        System.out.println("查询完全更新后的评价: " + updatedReview);
    }

    @Test
    public void selectSelective() {
        System.out.println("--- 测试 selectSelective (TReviews) ---");
        TReviews query = new TReviews();
        query.setNovelId(1); // 根据小说ID查询评价

        List<TReviews> reviewList = reviewsMapper.selectSelective(query);
        System.out.println("查询结果列表: " + reviewList);
        System.out.println("找到 " + (reviewList != null ? reviewList.size() : 0) + " 条记录.");
    }
}