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
     * @param pageDto
     */
    void listChapter(PageDto pageDto);

    /**
     * id有值更新，无值新增
     * @param chapterDto
     */
    void save(ChapterDto chapterDto);
}
