package service;

import mapper.TChaptersMapper;
import model.TChapters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能:
 * 作者：
 * 日期:2025/5/17 下午7:29
 */

@Service("chapterService")
public class TChaptersServiceImpl implements TChaptersService {

    @Autowired
    private TChaptersMapper chaptersMapper;

    @Override
    public TChapters getChapterById(Integer chapterId) {
        return chaptersMapper.selectByPrimaryKey(chapterId);
    }

    @Override
    public List<TChapters> getChaptersByNovelId(Integer novelId) {
        // 需在TChaptersMapper中添加selectByNovelId方法
        throw new UnsupportedOperationException("需在Mapper中添加selectByNovelId方法");
    }

    @Override
    public int addChapter(TChapters chapter) {
        return chaptersMapper.insertSelective(chapter);
    }

    @Override
    public boolean updateChapter(TChapters chapter) {
        int count = chaptersMapper.updateByPrimaryKeySelective(chapter);
        return count > 0;
    }

    @Override
    public boolean deleteChapter(Integer chapterId) {
        int count = chaptersMapper.deleteByPrimaryKey(chapterId);
        return count > 0;
    }
}
