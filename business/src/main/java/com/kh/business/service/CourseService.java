package com.kh.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kh.server.domain.Course;
import com.kh.server.dto.CourseDto;
import com.kh.server.dto.PageDto;

/**
 * @author ly
 * @date 2021/5/6 16:22
 */
public interface CourseService extends IService<Course> {

    /**
     * 查询所有chapter
     * @param pageDto
     */
    void listCourse(PageDto pageDto);

    /**
     * id有值更新，无值新增
     * @param courseDto
     */
    void save(CourseDto courseDto);
}
