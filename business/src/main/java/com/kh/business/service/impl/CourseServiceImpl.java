package com.kh.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kh.server.domain.Course;
import com.kh.server.dto.CourseDto;
import com.kh.server.dto.PageDto;
import com.kh.server.mapper.CourseMapper;
import com.kh.business.service.CourseService;
import com.kh.server.util.CopyUtil;
import com.kh.server.util.UuidUtil;
import com.kh.server.util.ValidatorUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author han.ke
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    @Override
    public void listCourse(PageDto pageDto) {
        Page<Course> page = new Page<>(pageDto.getPage(), pageDto.getSize());
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");
        Page<Course> coursePage = courseMapper.selectPage(page, wrapper);
        List<Course> courseList = coursePage.getRecords();
        List<CourseDto> courseDtoList = CopyUtil.copyList(courseList, CourseDto.class);
        pageDto.setTotal(coursePage.getTotal());
        pageDto.setList(courseDtoList);
    }

    @Override
    public void save(CourseDto courseDto) {
        //保存校验
                ValidatorUtil.require(courseDto.getName(), "名称");
                ValidatorUtil.length(courseDto.getName(), "名称", 1, 50);
                ValidatorUtil.length(courseDto.getSummary(), "概述", 1, 2000);
                ValidatorUtil.length(courseDto.getImage(), "封面", 1, 100);
        Course course = CopyUtil.copy(courseDto, Course.class);
        if(StringUtils.isEmpty(courseDto.getId())) {
            this.insert(course);
        } else {
            this.update(course);
        }
    }

    private void insert(Course course) {
        course.setId(UuidUtil.getShortUuid());
        this.save(course);
    }

    private void update(Course course) {
        this.updateById(course);
    }
}
