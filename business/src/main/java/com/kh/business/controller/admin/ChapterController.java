package com.kh.business.controller.admin;

import com.kh.business.service.ChapterService;
import com.kh.server.dto.ChapterDto;
import com.kh.server.dto.PageDto;
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
    public PageDto list(@RequestBody PageDto pageDto) {
        log.info("pageDto: -> {}", pageDto);
        service.listChapter(pageDto);
        return pageDto;
    }

    @RequestMapping("/save")
    public ChapterDto save(@RequestBody ChapterDto chapterDto) {
        log.info("chapterDto: -> {}", chapterDto);
        service.addChapter(chapterDto);
        return chapterDto;
    }
}
