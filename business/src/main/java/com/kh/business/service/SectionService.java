package com.kh.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kh.server.domain.Section;
import com.kh.server.dto.PageDto;
import com.kh.server.dto.SectionDto;

/**
 * @author ly
 * @date 2021/4/28 14:26
 */
public interface SectionService extends IService<Section> {
    /**
     * 查询所有chapter
     */
    void listSection(PageDto pageDto);

    /**
     * id有值更新，无值新增
     */
    void save(SectionDto sectionDto);
}
