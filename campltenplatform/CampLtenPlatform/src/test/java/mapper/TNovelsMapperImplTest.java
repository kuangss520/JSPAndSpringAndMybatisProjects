package mapper;

import model.TNovels;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) // 请替换为你的实际Spring配置文件路径
@Transactional // 添加事务管理，测试后自动回滚数据
public class TNovelsMapperImplTest {

    @Autowired
    private TNovelsMapper novelsMapper;

    @Test
    public void deleteByPrimaryKey() {
        System.out.println("--- 测试 deleteByPrimaryKey (TNovels) ---");
        // 插入一部测试小说用于删除
        TNovels novelToDelete = new TNovels();
        novelToDelete.setTitle("待删除小说 " + System.currentTimeMillis());
        novelToDelete.setGenre("其他");
        novelToDelete.setAuthor("author1"); // 假设 author1 存在
        novelToDelete.setStatus("serializing");
        int insertResult = novelsMapper.insert(novelToDelete);
        System.out.println("插入待删除小说结果 (影响行数): " + insertResult);
        Integer novelIdToDelete = novelToDelete.getNovelId();
        System.out.println("插入待删除小说ID: " + novelIdToDelete);

        int deleteResult = novelsMapper.deleteByPrimaryKey(novelIdToDelete);
        System.out.println("删除结果 (影响行数): " + deleteResult);

        TNovels deletedNovel = novelsMapper.selectByPrimaryKey(novelIdToDelete);
        System.out.println("查询删除后的小说: " + deletedNovel);
    }

    @Test
    public void insert() {
        System.out.println("--- 测试 insert (TNovels) ---");
        TNovels novel = new TNovels();
        novel.setTitle("测试小说 Insert " + System.currentTimeMillis());
        novel.setGenre("奇幻");
        novel.setDescription("这是一部测试奇幻小说");
        novel.setAuthor("author2"); // 假设 author2 存在
        novel.setStatus("completed");
        novel.setCoverImage("/covers/test_insert.jpg");
        novel.setTotalRating(new BigDecimal("4.5"));

        int result = novelsMapper.insert(novel);
        System.out.println("插入结果 (影响行数): " + result);

        // Assuming insert populates novel.novelId
        System.out.println("插入的小说ID: " + novel.getNovelId());
        TNovels insertedNovel = novelsMapper.selectByPrimaryKey(novel.getNovelId());
        System.out.println("查询插入的小说: " + insertedNovel);
    }

    @Test
    public void insertSelective() {
        System.out.println("--- 测试 insertSelective (TNovels) ---");
        TNovels novel = new TNovels();
        novel.setTitle("测试小说 Selective " + System.currentTimeMillis());
        novel.setGenre("都市");
        novel.setAuthor("author1"); // 假设 author1 存在
        novel.setStatus("serializing");
        // description, coverImage, totalRating 不设置

        int result = novelsMapper.insertSelective(novel);
        System.out.println("选择性插入结果 (影响行数): " + result);

        System.out.println("选择性插入的小说ID: " + novel.getNovelId());
        TNovels insertedNovel = novelsMapper.selectByPrimaryKey(novel.getNovelId());
        System.out.println("查询选择性插入的小说: " + insertedNovel);
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println("--- 测试 selectByPrimaryKey (TNovels) ---");
        // 使用一个存在的药品ID进行查询测试，根据初始数据修改
        Integer novelIdToSelect = 1; // 根据你的初始数据
        System.out.println("查询小说ID: " + novelIdToSelect);
        TNovels novel = novelsMapper.selectByPrimaryKey(novelIdToSelect);
        System.out.println("查询结果: " + novel);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        System.out.println("--- 测试 updateByPrimaryKeySelective (TNovels) ---");
        // 使用一个存在的药品ID进行更新测试，根据初始数据修改
        Integer novelIdToUpdate = 2; // 根据你的初始数据
        System.out.println("更新小说ID (选择性): " + novelIdToUpdate);

        TNovels novel = new TNovels();
        novel.setNovelId(novelIdToUpdate);
        novel.setTotalRating(new BigDecimal("9.5")); // 更新评分
        novel.setCoverImage("/covers/updated_science1.jpg"); // 更新封面

        int result = novelsMapper.updateByPrimaryKeySelective(novel);
        System.out.println("更新结果 (影响行数): " + result);

        TNovels updatedNovel = novelsMapper.selectByPrimaryKey(novelIdToUpdate);
        System.out.println("查询更新后的小说: " + updatedNovel);
    }

    @Test
    public void updateByPrimaryKey() {
        System.out.println("--- 测试 updateByPrimaryKey (TNovels) ---");
         // 插入一部测试小说用于完全更新
        TNovels novelToUpdate = new TNovels();
        novelToUpdate.setTitle("原始小说 " + System.currentTimeMillis());
        novelToUpdate.setGenre("历史");
        novelToUpdate.setDescription("原始描述");
        novelToUpdate.setAuthor("author2"); // 假设 author2 存在
        novelToUpdate.setStatus("serializing");
        novelToUpdate.setCoverImage("/covers/original.jpg");
        novelToUpdate.setTotalRating(new BigDecimal("3.0"));
        int insertResult = novelsMapper.insert(novelToUpdate);
        System.out.println("插入待完全更新小说结果 (影响行数): " + insertResult);
        Integer novelIdToUpdate = novelToUpdate.getNovelId();
        System.out.println("插入待完全更新小说ID: " + novelIdToUpdate);


        TNovels novel = new TNovels();
        novel.setNovelId(novelIdToUpdate);
        novel.setTitle("完全更新后小说 " + System.currentTimeMillis());
        novel.setGenre("悬疑");
        novel.setDescription("更新后的描述");
        novel.setAuthor("author1"); // 更改作者
        novel.setStatus("completed"); // 更改状态
        novel.setCoverImage("/covers/fully_updated.jpg");
        novel.setTotalRating(new BigDecimal("8.0"));

        int result = novelsMapper.updateByPrimaryKey(novel);
        System.out.println("完全更新结果 (影响行数): " + result);

        TNovels updatedNovel = novelsMapper.selectByPrimaryKey(novelIdToUpdate);
        System.out.println("查询完全更新后的小说: " + updatedNovel);
    }

    @Test
    public void selectSelective() {
        System.out.println("--- 测试 selectSelective (TNovels) ---");
        TNovels query = new TNovels();
        query.setStatus("completed"); // 根据状态查询

        List<TNovels> novelList = novelsMapper.selectSelective(query);
        System.out.println("查询结果列表: " + novelList);
        System.out.println("找到 " + (novelList != null ? novelList.size() : 0) + " 条记录.");
    }
}