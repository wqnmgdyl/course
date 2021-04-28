package com.kh.server.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 67641
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("section")
public class Section {
    @TableId
    private String id;

    private String title;

    @TableField("course_id")
    private String courseId;

    @TableField("chapter_id")
    private String chapterId;

    private String video;

    private Integer time;

    private String charge;

    private Integer sort;

    @TableField(value = "created_at",fill = FieldFill.INSERT)
    private Date createdAt;

    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    private Date updatedAt;
}