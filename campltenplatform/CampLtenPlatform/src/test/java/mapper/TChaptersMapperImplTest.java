package mapper;

import model.TChapters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional // 添加事务管理，测试后自动回滚数据
public class TChaptersMapperImplTest {

    @Autowired
    private TChaptersMapper chaptersMapper;

    @Test
    public void deleteByPrimaryKey() {
        System.out.println("--- 测试 deleteByPrimaryKey (TChapters) ---");
        // 插入一个测试章节用于删除
        TChapters chapterToDelete = new TChapters();
        chapterToDelete.setNovelId(1); // 假设 novel with ID 1 exists
        chapterToDelete.setChapterOrder(999);
        chapterToDelete.setTitle("待删除章节 " + System.currentTimeMillis());
        chapterToDelete.setContent("待删除内容");
        chapterToDelete.setPublishStatus("saved");
        int insertResult = chaptersMapper.insert(chapterToDelete);
        System.out.println("插入待删除章节结果 (影响行数): " + insertResult);
        Integer chapterIdToDelete = chapterToDelete.getChapterId();
        System.out.println("插入待删除章节ID: " + chapterIdToDelete);


        System.out.println("尝试删除章节ID: " + chapterIdToDelete);
        int deleteResult = chaptersMapper.deleteByPrimaryKey(chapterIdToDelete);
        System.out.println("删除结果 (Mapper 方法返回值): " + deleteResult);


        TChapters deletedChapter = chaptersMapper.selectByPrimaryKey(chapterIdToDelete);
        System.out.println("查询删除后的章节: " + deletedChapter);
    }

    @Test
    public void insert() {
        System.out.println("--- 测试 insert (TChapters) ---");
        TChapters chapter = new TChapters();
        chapter.setNovelId(2); // 假设 novel with ID 2 exists
        chapter.setChapterOrder(100);
        chapter.setTitle("测试章节 Insert " + System.currentTimeMillis());
        chapter.setContent("这是测试章节 Insert 的内容。");
        chapter.setPublishStatus("published");

        int result = chaptersMapper.insert(chapter);
        System.out.println("插入结果 (影响行数): " + result);

        // Assuming insert populates chapter.chapterId
        System.out.println("插入的章节ID: " + chapter.getChapterId());
        TChapters insertedChapter = chaptersMapper.selectByPrimaryKey(chapter.getChapterId());
        System.out.println("查询插入的章节: " + insertedChapter);
    }

    @Test
    public void insertSelective() {
        System.out.println("--- 测试 insertSelective (TChapters) ---");
        TChapters chapter = new TChapters();
        chapter.setNovelId(3); // 假设 novel with ID 3 exists
        chapter.setChapterOrder(101);
        chapter.setTitle("测试章节 Selective " + System.currentTimeMillis());
        chapter.setContent("这是测试章节 Selective 的内容。");
        // publishStatus 不设置 (假设数据库有默认值)

        int result = chaptersMapper.insertSelective(chapter);
        System.out.println("选择性插入结果 (影响行数): " + result);

        System.out.println("选择性插入的章节ID: " + chapter.getChapterId());
        TChapters insertedChapter = chaptersMapper.selectByPrimaryKey(chapter.getChapterId());
        System.out.println("查询选择性插入的章节: " + insertedChapter);
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println("--- 测试 selectByPrimaryKey (TChapters) ---");
        // 使用一个存在的章节ID进行查询测试，根据初始数据修改
        Integer chapterIdToSelect = 1; // 根据你的初始数据
        System.out.println("查询章节ID: " + chapterIdToSelect);
        TChapters chapter = chaptersMapper.selectByPrimaryKey(chapterIdToSelect);
        System.out.println("查询结果: " + chapter);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        System.out.println("--- 测试 updateByPrimaryKeySelective (TChapters) ---");
        // 使用一个存在的章节ID进行更新测试，根据初始数据修改
        Integer chapterIdToUpdate = 3; // 根据你的初始数据 ('reviewing')
        System.out.println("更新章节ID (选择性): " + chapterIdToUpdate);

        TChapters chapter = new TChapters();
        chapter.setChapterId(chapterIdToUpdate);
        chapter.setPublishStatus("published"); // 更改发布状态

        int result = chaptersMapper.updateByPrimaryKeySelective(chapter);
        System.out.println("更新结果 (影响行数): " + result);

        TChapters updatedChapter = chaptersMapper.selectByPrimaryKey(chapterIdToUpdate);
        System.out.println("查询更新后的章节: " + updatedChapter);
    }

    @Test
    public void updateByPrimaryKey() {
        System.out.println("--- 测试 updateByPrimaryKey (TChapters) ---");
        // 插入一个测试章节用于完全更新
        TChapters chapterToUpdate = new TChapters();
        chapterToUpdate.setNovelId(4); // 假设 novel with ID 4 exists
        chapterToUpdate.setChapterOrder(998);
        chapterToUpdate.setTitle("原始章节 " + System.currentTimeMillis());
        chapterToUpdate.setContent("原始内容");
        chapterToUpdate.setPublishStatus("saved");
        int insertResult = chaptersMapper.insert(chapterToUpdate);
        System.out.println("插入待完全更新章节结果 (影响行数): " + insertResult);
        Integer chapterIdToUpdate = chapterToUpdate.getChapterId();
        System.out.println("插入待完全更新章节ID: " + chapterIdToUpdate);

        TChapters chapter = new TChapters();
        chapter.setChapterId(chapterIdToUpdate);
        chapter.setNovelId(4); // 仍然关联小说ID 4
        chapter.setChapterOrder(998); // 章节顺序不变
        chapter.setTitle("完全更新后章节 " + System.currentTimeMillis());
        chapter.setContent("完全更新后的内容。");
        chapter.setPublishStatus("submitted"); // 更改发布状态

        int result = chaptersMapper.updateByPrimaryKey(chapter);
        System.out.println("完全更新结果 (影响行数): " + result);

        TChapters updatedChapter = chaptersMapper.selectByPrimaryKey(chapterIdToUpdate);
        System.out.println("查询完全更新后的章节: " + updatedChapter);
    }

    @Test
    public void selectSelective() {
        System.out.println("--- 测试 selectSelective (TChapters) ---");
        TChapters query = new TChapters();
        query.setNovelId(1); // 根据小说ID查询章节

        List<TChapters> chapterList = chaptersMapper.selectSelective(query);
        System.out.println("查询结果列表: " + chapterList);
        System.out.println("找到 " + (chapterList != null ? chapterList.size() : 0) + " 条记录.");
    }
}