package com.kh.business.controller.admin;

import com.kh.business.service.ChapterService;
import com.kh.server.dto.ChapterDto;
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
@RequestMapping("/admin/chapter")
public class ChapterController {

    public static final String BUSINESS_NAME = "大章";

    @Resource
    private ChapterService service;

    /**
     * 列表查询
     * @param pageDto
     * @return
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        log.info("pageDto: -> {}", pageDto);
        ResponseDto responseDto = new ResponseDto<>();
        service.listChapter(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * id有值时更新，无值时新增
     * @param chapterDto
     * @return
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ChapterDto chapterDto) {
        log.info("chapterDto: -> {}", chapterDto);
        service.save(chapterDto);
        ResponseDto responseDto = new ResponseDto<>();
        responseDto.setContent(chapterDto);
        return responseDto;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        log.info("chapterID -> {}", id);
        service.removeById(id);
        return new ResponseDto();
    }
}
