package service;

import model.TApplication;
import java.util.List;

public interface ApplicationService {
    /**
     * 添加教室申请
     * @param record 申请信息
     * @return 成功返回新申请的主键值，失败返回0
     */
    int addApplication(TApplication record);

    /**
     * 修改申请信息
     * @param record 申请信息（需包含主键ID）
     * @return 成功返回true，失败返回false
     */
    boolean modifyApplication(TApplication record);

    /**
     * 删除申请
     * @param applicationId 申请ID
     * @return 成功返回true，失败返回false
     */
    boolean removeApplication(Integer applicationId);

    /**
     * 根据ID查询申请
     * @param applicationId 申请ID
     * @return 申请信息（不存在返回null）
     */
    TApplication getApplicationById(Integer applicationId);

    /**
     * 根据教室ID查询申请
     * @param classroomId 教室ID
     * @return 申请列表（无结果返回空列表）
     */
    List<TApplication> getApplicationsByClassroom(Integer classroomId);

    /**
     * 根据申请人工号查询申请
     * @param applicantId 申请人工号
     * @return 申请列表（无结果返回空列表）
     */


    List<TApplication> getApplicationsByApplicant(Integer applicantId);
}