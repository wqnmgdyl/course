package com.kh.server.dto;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 67641
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("section")
public class SectionDto {

    /**
     * ID
     */
    @TableId
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 课程|course.id
     */
    private String courseId;

    /**
     * 大章|chapter.id
     */
    private String chapterId;

    /**
     * 视频
     */
    private String video;

    /**
     * 时长|单位秒
     */
    private Integer time;

    /**
     * 收费|C 收费; F 免费
     */
    private String charge;

    /**
     * 顺序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "created_at",fill = FieldFill.INSERT)
    private Date createdAt;

    /**
     * 修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    private Date updatedAt;

}