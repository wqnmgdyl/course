package com.kh.business.controller.admin;

import com.kh.business.service.ChapterService;
import com.kh.server.dto.PageDto;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author han.ke
 */
@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Resource
    private ChapterService service;

    @RequestMapping("/list")
    public PageDto list(@RequestBody PageDto pageDto) {
        service.listChapterDto(pageDto);
        return pageDto;
    }
}
