package service;

import model.TChapters;

import java.util.List;

public interface TChaptersService {
    /**
     * 根据章节ID查询章节内容
     * @param chapterId 章节ID
     * @return TChapters
     */
    TChapters getChapterById(Integer chapterId);

    /**
     * 根据小说编号查询所有章节内容
     * @param novelId 小说ID
     * @return List<TChapters>
     */
    List<TChapters> getChaptersByNovelId(Integer novelId);

    /**
     * 添加章节内容
     * @param chapter 章节对象
     * @return 成功返回新章节ID，失败返回0
     */
    int addChapter(TChapters chapter);

    /**
     * 修改章节内容
     * @param chapter 章节对象
     * @return 成功返回true，失败返回false
     */
    boolean updateChapter(TChapters chapter);

    /**
     * 删除章节内容
     * @param chapterId 章节ID
     * @return 成功返回true，失败返回false
     */
    boolean deleteChapter(Integer chapterId);
}
