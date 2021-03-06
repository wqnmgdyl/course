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
import com.kh.server.util.ValidatorUtil;
import org.apache.commons.lang.StringUtils;
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
    public void save(ChapterDto chapterDto) {
        ValidatorUtil.require(chapterDto.getName(),"名称");
        ValidatorUtil.require(chapterDto.getCourseId(),"课程ID");
        ValidatorUtil.length(chapterDto.getCourseId(),"课程ID",1,8);
        Chapter chapter = CopyUtil.copy(chapterDto, Chapter.class);
        if(StringUtils.isEmpty(chapterDto.getId())) {
            this.insert(chapter);
        } else {
            this.update(chapter);
        }
    }

    private void insert(Chapter chapter) {
        chapter.setId(UuidUtil.getShortUuid());
        this.save(chapter);
    }

    private void update(Chapter chapter) {
        this.updateById(chapter);
    }
}
