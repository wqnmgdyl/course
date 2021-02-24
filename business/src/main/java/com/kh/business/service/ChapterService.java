package com.kh.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kh.server.domain.Chapter;
import com.kh.server.dto.PageDto;



/**
 * @author han.ke
 */
public interface ChapterService extends IService<Chapter> {
    /**
     * 查询所有chapterDto
     */
    void listChapterDto(PageDto pageDto);
}
