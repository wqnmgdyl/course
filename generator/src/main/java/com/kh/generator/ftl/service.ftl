package com.kh.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kh.server.domain.${Domain};
import com.kh.server.dto.PageDto;
import com.kh.server.dto.${Domain}Dto;

/**
* @author ly
* @date 2021/4/28 14:26
*/
public interface ${Domain}Service extends IService<${Domain}> {
    /**
     * 查询所有chapter
     * @param pageDto
     */
    void list${Domain}(PageDto pageDto);

    /**
     * id有值更新，无值新增
     * @param ${domain}Dto
     */
    void save(${Domain}Dto ${domain}Dto); 
}