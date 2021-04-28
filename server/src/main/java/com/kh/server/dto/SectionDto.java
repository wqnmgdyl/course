package com.kh.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ly
 * @date 2021/4/28 14:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionDto {
    private String id;

    private String title;

    private String courseId;

    private String chapterId;

    private String video;

    private Integer time;

    private String charge;

    private Integer sort;

    private Date createdAt;

    private Date updatedAt;
}
