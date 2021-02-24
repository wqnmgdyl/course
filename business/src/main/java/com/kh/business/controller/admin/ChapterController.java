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

    @Resource
    private ChapterService service;

    @RequestMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        log.info("pageDto: -> {}", pageDto);
        ResponseDto<Object> responseDto = new ResponseDto<>();
        service.listChapter(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @RequestMapping("/save")
    public ResponseDto save(@RequestBody ChapterDto chapterDto) {
        log.info("chapterDto: -> {}", chapterDto);
        service.save(chapterDto);
        ResponseDto<Object> responseDto = new ResponseDto<>();
        responseDto.setContent(chapterDto);
        return responseDto;
    }
}
