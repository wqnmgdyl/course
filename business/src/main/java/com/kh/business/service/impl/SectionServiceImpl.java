package com.kh.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kh.server.domain.Section;
import com.kh.server.dto.SectionDto;
import com.kh.server.dto.PageDto;
import com.kh.server.enums.SectionChargeEnum;
import com.kh.server.mapper.SectionMapper;
import com.kh.business.service.SectionService;
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
public class SectionServiceImpl extends ServiceImpl<SectionMapper, Section> implements SectionService {
    @Resource
    private SectionMapper sectionMapper;

    @Override
    public void listSection(PageDto pageDto) {
        Page<Section> page = new Page<>(pageDto.getPage(), pageDto.getSize());
        QueryWrapper<Section> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");
        Page<Section> sectionPage = sectionMapper.selectPage(page, wrapper);
        List<Section> sectionList = sectionPage.getRecords();
        List<SectionDto> sectionDtoList = CopyUtil.copyList(sectionList, SectionDto.class);
        pageDto.setTotal(sectionPage.getTotal());
        pageDto.setList(sectionDtoList);
    }

    @Override
    public void save(SectionDto sectionDto) {
        ValidatorUtil.require(sectionDto.getTitle(),"标题");
        ValidatorUtil.length(sectionDto.getTitle(), "标题", 1, 50);
        ValidatorUtil.length(sectionDto.getVideo(), "视频", 1, 200);
        Section section = CopyUtil.copy(sectionDto, Section.class);
        if(StringUtils.isEmpty(sectionDto.getId())) {
            this.insert(section);
        } else {
            this.update(section);
        }
    }

    private void insert(Section section) {
        section.setId(UuidUtil.getShortUuid());
        section.setCharge(SectionChargeEnum.CHARGE.getCode());
        this.save(section);
    }

    private void update(Section section) {
        this.updateById(section);
    }
}
