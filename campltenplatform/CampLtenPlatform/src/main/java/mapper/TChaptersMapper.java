package mapper;

import model.TChapters;

import java.util.List;

public interface TChaptersMapper {
    int deleteByPrimaryKey(Integer chapterId);

    int insert(TChapters record);

    int insertSelective(TChapters record);

    TChapters selectByPrimaryKey(Integer chapterId);

    int updateByPrimaryKeySelective(TChapters record);

    int updateByPrimaryKeyWithBLOBs(TChapters record);

    int updateByPrimaryKey(TChapters record);

    List<TChapters> selectSelective(TChapters record);
}