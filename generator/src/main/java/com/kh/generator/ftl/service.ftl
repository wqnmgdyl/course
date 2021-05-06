package com.kh.business.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kh.server.domain.${Domain};
import com.kh.server.dto.${Domain}Dto;
import com.kh.server.dto.PageDto;
import com.kh.server.mapper.${Domain}Mapper;
import com.kh.business.service.${Domain}Service;
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
public class ${Domain}ServiceImpl extends ServiceImpl<${Domain}Mapper, ${Domain}> implements ${Domain}Service {
    @Resource
    private ${Domain}Mapper ${domain}Mapper;

    @Override
    public void list${Domain}(PageDto pageDto) {
        Page<${Domain}> page = new Page<>(pageDto.getPage(), pageDto.getSize());
        Page<${Domain}> ${domain}Page = ${domain}Mapper.selectPage(page, null);
        List<${Domain}> ${domain}List = ${domain}Page.getRecords();
        List<${Domain}Dto> ${domain}DtoList = CopyUtil.copyList(${domain}List, ${Domain}Dto.class);
        pageDto.setTotal(${domain}Page.getTotal());
        pageDto.setList(${domain}DtoList);
    }

    @Override
    public void save(${Domain}Dto ${domain}Dto) {
        //保存校验
        <#list fieldList as field>
            <#if !field.nullAble>
                ValidatorUtil.require(${domain}Dto.get${field.nameBigHump}(), "${field.nameCn}");
            </#if>
            <#if (field.length > 0)>
                ValidatorUtil.length(${domain}Dto.get${field.nameBigHump}(), "${field.nameCn}", 1, ${field.length});
            </#if>
        </#list>
        ${Domain} ${domain} = CopyUtil.copy(${domain}Dto, ${Domain}.class);
        if(StringUtils.isEmpty(${domain}Dto.getId())) {
            this.insert(${domain});
        } else {
            this.update(${domain});
        }
    }

    private void insert(${Domain} ${domain}) {
        ${domain}.setId(UuidUtil.getShortUuid());
        this.save(${domain});
    }

    private void update(${Domain} ${domain}) {
        this.updateById(${domain});
    }
}
