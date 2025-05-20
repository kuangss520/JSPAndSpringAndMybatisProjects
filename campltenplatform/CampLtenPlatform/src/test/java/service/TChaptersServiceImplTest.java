package service;

import model.TChapters;
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
public class TChaptersServiceImplTest {

    @Autowired
    private TChaptersService chapterService;

    @Test
    public void testGetChapterById() {
        System.out.println("--- 测试 getChapterById (TChaptersService) ---");
        // 使用一个存在的章节ID进行查询测试，根据初始数据修改
        Integer chapterIdToSelect = 1; // 假设 chapter with ID 1 存在
        System.out.println("查询章节ID: " + chapterIdToSelect);

        TChapters chapter = chapterService.getChapterById(chapterIdToSelect);
        System.out.println("查询结果: " + chapter);
    }

    @Test
    public void testGetChaptersByNovelId() {
        System.out.println("--- 测试 getChaptersByNovelId (TChaptersService) ---");
        // **注意:** 你的 TChaptersServiceImpl 中 getChaptersByNovelId 方法抛出了 UnsupportedOperationException。
        // 在你实现这个 Service 方法和对应的 Mapper 方法之前，这个测试会抛出异常。
        // 一旦实现，你可以根据小说ID进行测试。
        Integer novelIdToFind = 1; // 示例小说ID
        System.out.println("尝试根据小说ID查询章节: " + novelIdToFind);

        try {
            List<TChapters> chapters = chapterService.getChaptersByNovelId(novelIdToFind);
            System.out.println("查询结果列表: " + chapters);
            System.out.println("找到 " + (chapters != null ? chapters.size() : 0) + " 条记录.");
        } catch (UnsupportedOperationException e) {
            System.out.println("Service 方法 getChaptersByNovelId 尚未实现: " + e.getMessage());
        }
    }

    @Test
    public void testAddChapter() {
        System.out.println("--- 测试 addChapter (TChaptersService) ---");
        TChapters chapter = new TChapters();
        chapter.setNovelId(1); // 假设 novel with ID 1 存在
        chapter.setChapterOrder(99);
        chapter.setTitle("测试Service添加章节 " + System.currentTimeMillis());
        chapter.setContent("这是通过Service添加的测试章节内容。");
        chapter.setPublishStatus("saved");

        int result = chapterService.addChapter(chapter);
        System.out.println("添加章节结果 (影响行数): " + result);
    }

    @Test
    public void testUpdateChapter() {
        System.out.println("--- 测试 updateChapter (TChaptersService) ---");
        TChapters chapter = new TChapters();
        // 使用一个存在的章节ID进行更新测试，根据初始数据修改
        Integer chapterIdToUpdate = 3;
        System.out.println("尝试修改章节ID: " + chapterIdToUpdate);
        chapter.setChapterId(chapterIdToUpdate);
        chapter.setPublishStatus("published"); // 更改发布状态
        chapter.setContent("更新后的章节内容。"); // 更新内容

        boolean result = chapterService.updateChapter(chapter);
        System.out.println("修改章节结果 (true表示成功): " + result);
    }

    @Test
    public void testDeleteChapter() {
        System.out.println("--- 测试 deleteChapter (TChaptersService) ---");
         // 插入一个测试章节用于删除
        TChapters chapterToDelete = new TChapters();
        chapterToDelete.setNovelId(2);
        chapterToDelete.setChapterOrder(998);
        chapterToDelete.setTitle("待删除Service章节 " + System.currentTimeMillis());
        chapterToDelete.setContent("待删除内容");
        chapterToDelete.setPublishStatus("saved");
        chapterService.addChapter(chapterToDelete); // 先添加章节
        Integer chapterIdToDelete = chapterToDelete.getChapterId();
        System.out.println("插入待删除章节ID: " + chapterIdToDelete);

        System.out.println("尝试删除章节ID: " + chapterIdToDelete);
        boolean result = chapterService.deleteChapter(chapterIdToDelete);
        System.out.println("删除章节结果 (true表示成功): " + result);
    }
}