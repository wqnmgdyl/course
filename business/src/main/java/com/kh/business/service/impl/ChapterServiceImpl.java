package com.kh.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kh.server.domain.Chapter;
import com.kh.server.mapper.ChapterMapper;
import com.kh.business.service.ChapterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author han.ke
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper,Chapter> implements ChapterService {
    @Resource
    private ChapterMapper chapterMapper;

}
