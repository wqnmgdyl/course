package com.kh.business.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kh.server.domain.Chapter;
import com.kh.server.dto.ChapterDto;
import com.kh.server.dto.PageDto;
import com.kh.server.mapper.ChapterMapper;
import com.kh.business.service.ChapterService;
import com.kh.server.util.CopyUtil;
import com.kh.server.util.UuidUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author han.ke
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {
    @Resource
    private ChapterMapper chapterMapper;

    @Override
    public void listChapter(PageDto pageDto) {
        Page<Chapter> page = new Page<>(pageDto.getPage(), pageDto.getSize());
        Page<Chapter> chapterPage = chapterMapper.selectPage(page, null);
        List<Chapter> chapterList = chapterPage.getRecords();
        List<ChapterDto> chapterDtoList = CopyUtil.copyList(chapterList, ChapterDto.class);
        pageDto.setTotal(chapterPage.getTotal());
        pageDto.setList(chapterDtoList);
    }

    @Override
    public void addChapter(ChapterDto chapterDto) {
        chapterDto.setId(UuidUtil.getShortUuid());
        Chapter chapter = new Chapter();
        BeanUtils.copyProperties(chapterDto, chapter);
        this.save(chapter);
    }
}
