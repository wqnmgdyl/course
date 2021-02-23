package com.kh.business.controller;

import com.kh.server.domain.Chapter;
import com.kh.business.service.ChapterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author han.ke
 */
@RestController
public class ChapterController {

    @Resource
    private ChapterService service;

    @RequestMapping("/chapter")
    public List<Chapter> list() {
        return service.list();
    }
}
