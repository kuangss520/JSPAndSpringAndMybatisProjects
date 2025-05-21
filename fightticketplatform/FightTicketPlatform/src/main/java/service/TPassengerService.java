package service;

import model.TPassenger;

/**
 * 旅客信息管理接口
 */
public interface TPassengerService {

    /**
     * 添加旅客
     * @param record 旅客信息对象
     * @return 成功返回新旅客的主键值，失败返回 0
     */
    int addPassenger(TPassenger record);

    /**
     * 修改旅客信息
     * @param record 旅客信息对象（需包含主键 ID）
     * @return 成功返回 true，失败返回 false
     */
    boolean modifyPassenger(TPassenger record);

    /**
     * 删除旅客
     * @param idCard 旅客身份证号
     * @return 成功返回 true，失败返回 false
     */
    boolean removePassenger(String idCard);

    /**
     * 根据身份证号查询旅客
     * @param idCard 身份证号
     * @return 旅客信息对象，不存在返回 null
     */
    TPassenger getPassengerByIdCard(String idCard);

    /**
     * 旅客登录
     * @param idCard 身份证号
     * @param password 密码
     * @return 登录成功返回旅客对象，失败返回 null
     */
    TPassenger passengerLogin(String idCard, String password);
}