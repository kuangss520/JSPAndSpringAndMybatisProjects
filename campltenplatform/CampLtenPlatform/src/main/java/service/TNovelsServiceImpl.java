package service;

import mapper.TNovelsMapper;
import model.TNovels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 功能:
 * 作者：
 * 日期:2025/5/17 下午7:24
 */

@Service("novelService")
public class TNovelsServiceImpl implements TNovelsService {

    @Autowired
    private TNovelsMapper novelsMapper;

    @Override
    public TNovels getNovelById(Integer novelId) {
        return novelsMapper.selectByPrimaryKey(novelId);
    }

    @Override
    public List<TNovels> getNovelsByTitle(String title) {
        // 注意：这里需要在Mapper XML中添加对应的select语句
        // 目前的Mapper实现中没有该方法，需要补充
        throw new UnsupportedOperationException("需在Mapper中添加selectByTitle方法");
    }

    @Override
    public List<TNovels> getAllNovels() {
        // 注意：这里需要在Mapper XML中添加对应的select语句
        throw new UnsupportedOperationException("需在Mapper中添加selectAll方法");
    }

    @Override
    public int addNovel(TNovels record) {
        return novelsMapper.insertSelective(record);
    }

    @Override
    public boolean modifyNovel(TNovels record) {
        int count = novelsMapper.updateByPrimaryKeySelective(record);
        return count > 0;
    }

    @Override
    public boolean removeNovel(Integer novelId) {
        int count = novelsMapper.deleteByPrimaryKey(novelId);
        return count > 0;
    }
}
