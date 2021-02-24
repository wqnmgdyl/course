package com.kh.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kh.server.domain.Chapter;
import com.kh.server.dto.ChapterDto;
import com.kh.server.dto.PageDto;



/**
 * @author han.ke
 */
public interface ChapterService extends IService<Chapter> {
    /**
     * 查询所有chapter
     */
    void listChapter(PageDto pageDto);

    /**
     * 添加chapter
     */
    void save(ChapterDto chapterDto);
}
