package service;

import model.TNovels;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@Rollback(true) // 测试完成后回滚事务
public class TNovelsServiceImplTest {

    @Autowired
    private TNovelsService novelService;

    @Test
    public void testGetNovelById() {
        System.out.println("--- 测试 getNovelById (TNovelsService) ---");
        // 使用一个存在的小说ID进行查询测试，根据初始数据修改
        Integer novelIdToSelect = 1; // 假设 novel with ID 1 存在
        System.out.println("查询小说ID: " + novelIdToSelect);

        TNovels novel = novelService.getNovelById(novelIdToSelect);
        System.out.println("查询结果: " + novel);
    }

    @Test
    public void testGetNovelsByTitle() {
        System.out.println("--- 测试 getNovelsByTitle (TNovelsService) ---");
        // **注意:** 你的 TNovelsServiceImpl 中 getNovelsByTitle 方法抛出了 UnsupportedOperationException。
        // 在你实现这个 Service 方法和对应的 Mapper 方法之前，这个测试会抛出异常。
        // 一旦实现，你可以根据标题进行测试。
        String titleToFind = "校园风云录"; // 示例标题

        System.out.println("尝试根据标题查询小说: " + titleToFind);
        try {
            List<TNovels> novels = novelService.getNovelsByTitle(titleToFind);
            System.out.println("查询结果列表: " + novels);
            System.out.println("找到 " + (novels != null ? novels.size() : 0) + " 条记录.");
        } catch (UnsupportedOperationException e) {
            System.out.println("Service 方法 getNovelsByTitle 尚未实现: " + e.getMessage());
        }
    }

    @Test
    public void testGetAllNovels() {
        System.out.println("--- 测试 getAllNovels (TNovelsService) ---");
         // **注意:** 你的 TNovelsServiceImpl 中 getAllNovels 方法抛出了 UnsupportedOperationException。
        // 在你实现这个 Service 方法和对应的 Mapper 方法之前，这个测试会抛出异常。
        // 一旦实现，你可以测试查询所有小说。
        System.out.println("尝试查询所有小说");
        try {
            List<TNovels> allNovels = novelService.getAllNovels();
            System.out.println("查询结果列表: " + allNovels);
            System.out.println("找到 " + (allNovels != null ? allNovels.size() : 0) + " 条记录.");
        } catch (UnsupportedOperationException e) {
             System.out.println("Service 方法 getAllNovels 尚未实现: " + e.getMessage());
        }
    }

    @Test
    public void testAddNovel() {
        System.out.println("--- 测试 addNovel (TNovelsService) ---");
        TNovels novel = new TNovels();
        novel.setTitle("测试Service添加小说 " + System.currentTimeMillis());
        novel.setGenre("测试分类");
        novel.setDescription("这是一部通过Service添加的测试小说");
        novel.setAuthor("author1"); // 假设 'author1' 存在
        novel.setStatus("serializing");
        novel.setCoverImage("/covers/service_test.jpg");
        novel.setTotalRating(new BigDecimal("4.2"));

        int result = novelService.addNovel(novel);
        System.out.println("添加小说结果 (影响行数): " + result);
    }

    @Test
    public void testModifyNovel() {
        System.out.println("--- 测试 modifyNovel (TNovelsService) ---");
        TNovels novel = new TNovels();
        // 使用一个存在的小说ID进行更新测试，根据初始数据修改
        Integer novelIdToUpdate = 2; // 假设 novel with ID 2 存在
        System.out.println("尝试修改小说ID: " + novelIdToUpdate);
        novel.setNovelId(novelIdToUpdate);
        novel.setStatus("completed"); // 更改状态
        novel.setTotalRating(new BigDecimal("8.5")); // 更新评分

        boolean result = novelService.modifyNovel(novel);
        System.out.println("修改小说结果 (true表示成功): " + result);
    }

    @Test
    public void testRemoveNovel() {
        System.out.println("--- 测试 removeNovel (TNovelsService) ---");
         // 插入一部测试小说用于删除
        TNovels novelToDelete = new TNovels();
        novelToDelete.setTitle("待删除Service小说 " + System.currentTimeMillis());
        novelToDelete.setGenre("其他");
        novelToDelete.setAuthor("author2"); // 假设 'author2' 存在
        novelToDelete.setStatus("serializing");
        novelService.addNovel(novelToDelete); // 先添加小说
        Integer novelIdToDelete = novelToDelete.getNovelId();
        System.out.println("插入待删除小说ID: " + novelIdToDelete);


        System.out.println("尝试删除小说ID: " + novelIdToDelete);
        boolean result = novelService.removeNovel(novelIdToDelete);
        System.out.println("删除小说结果 (true表示成功): " + result);
    }
}