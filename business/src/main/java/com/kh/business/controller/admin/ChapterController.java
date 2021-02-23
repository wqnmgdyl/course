package com.kh.business.controller.admin;

import com.kh.business.service.ChapterService;
import com.kh.server.dto.ChapterDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author han.ke
 */
@RestController
@RequestMapping("/admin")
public class ChapterController {

    @Resource
    private ChapterService service;

    @RequestMapping("/chapter")
    public List<ChapterDto> list() {
        return service.listChapterDto();
    }
}
