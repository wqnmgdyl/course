package com.kh.business.controller.admin;

import com.kh.business.service.SectionService;
import com.kh.server.dto.SectionDto;
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
@RequestMapping("/admin/section")
public class SectionController {

    public static final String BUSINESS_NAME = "小节";

    @Resource
    private SectionService service;

    /**
     * 列表查询
     * @param pageDto
     * @return
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        log.info("pageDto: -> {}", pageDto);
        ResponseDto responseDto = new ResponseDto<>();
        service.listSection(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * id有值时更新，无值时新增
     * @param sectionDto
     * @return
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody SectionDto sectionDto) {
        log.info("sectionDto: -> {}", sectionDto);
        service.save(sectionDto);
        ResponseDto responseDto = new ResponseDto<>();
        responseDto.setContent(sectionDto);
        return responseDto;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        log.info("sectionID -> {}", id);
        service.removeById(id);
        return new ResponseDto();
    }
}
