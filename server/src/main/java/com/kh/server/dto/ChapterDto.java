package com.kh.server.dto;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author han.ke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("chapter")
public class ChapterDto {
    @TableId
    private String id;

    @TableField("course_id")
    private String courseId;

    private String name;

}