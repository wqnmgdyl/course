package com.kh.business.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kh.server.domain.Chapter;
import com.kh.server.dto.ChapterDto;
import com.kh.server.dto.PageDto;
import com.kh.server.mapper.ChapterMapper;
import com.kh.business.service.ChapterService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author han.ke
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper,Chapter> implements ChapterService {
    @Resource
    private ChapterMapper chapterMapper;

    @Override
    public void listChapterDto(PageDto pageDto) {
        Page<Chapter> page = new Page<>(pageDto.getPage(), pageDto.getSize());
        Page<Chapter> chapterPage = chapterMapper.selectPage(page, null);
        List<Chapter> chapterList = chapterPage.getRecords();
        List<ChapterDto> chapterDtoList = new ArrayList<>();
        for (int i = 0; i < chapterList.size(); i++) {
            Chapter chapter = chapterList.get(i);
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter,chapterDto);
            chapterDtoList.add(chapterDto);
        }
        pageDto.setTotal(chapterPage.getTotal());
        pageDto.setList(chapterDtoList);
    }
}
