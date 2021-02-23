package com.kh.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kh.server.domain.Chapter;
import com.kh.server.dto.ChapterDto;

import java.util.List;


/**
 * @author han.ke
 */
public interface ChapterService extends IService<Chapter> {
    /**
     * 查询所有chapterDto
     * @return
     */
    List<ChapterDto> listChapterDto();
}
