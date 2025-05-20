package service;

import model.TNovels;

import java.util.List;

public interface TNovelsService {
    /**
     * 根据小说ID返回对应的小说
     * @param novelId 小说ID
     * @return TNovels
     */
    public TNovels getNovelById(Integer novelId);

    /**
     * 根据小说名称模糊查询小说列表
     * @param title 小说名称
     * @return List<TNovels>
     */
    public List<TNovels> getNovelsByTitle(String title);

    /**
     * 查询所有小说
     * @return List<TNovels>
     */
    public List<TNovels> getAllNovels();

    /**
     * 添加一个新的小说
     * @param record TNovels类型对象
     * @return 成功返回新小说的主键值，失败返回0
     */
    public int addNovel(TNovels record);

    /**
     * 修改指定的小说信息
     * @param record TNovels类型对象
     * @return 成功返回true，失败返回false
     */
    public boolean modifyNovel(TNovels record);

    /**
     * 删除指定的小说信息
     * @param novelId 小说ID
     * @return 成功返回true，失败返回false
     */
    public boolean removeNovel(Integer novelId);
}
