package cn.com.edzleft.dao.captial.attachment;

import cn.com.edzleft.entity.Attachment;

import java.util.List;
import java.util.Map;

public interface CaptialAttachmentMapper {
    int deleteByPrimaryKey(Integer attachmentId);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    Attachment selectByPrimaryKey(Integer attachmentId);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);

    /**
     * 接口查询
     * @param attachmentId
     * @return
     */
    List<Map<String,Object>> attachmentUrl(Integer attachmentCreditId);
}