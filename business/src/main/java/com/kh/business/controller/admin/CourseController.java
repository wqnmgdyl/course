package com.kh.business.controller.admin;

import com.kh.business.service.CourseService;
import com.kh.server.dto.CourseDto;
import com.kh.server.dto.PageDto;
import com.kh.server.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author han.ke
 */
@Slf4j
@RestController
@RequestMapping("/admin/course")
public class CourseController {

    public static final String BUSINESS_NAME = "课程";

    @Resource
    private CourseService service;

    /**
     * 列表查询
     * @param pageDto
     * @return
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        log.info("pageDto: -> {}", pageDto);
        ResponseDto responseDto = new ResponseDto<>();
        service.listCourse(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * id有值时更新，无值时新增
     * @param courseDto
     * @return
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody CourseDto courseDto) {
        log.info("courseDto: -> {}", courseDto);
        service.save(courseDto);
        ResponseDto responseDto = new ResponseDto<>();
        responseDto.setContent(courseDto);
        return responseDto;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        log.info("courseID -> {}", id);
        service.removeById(id);
        return new ResponseDto();
    }
}
