package com.kh.${module}.controller.admin;

import com.kh.business.service.${Domain}Service;
import com.kh.server.dto.${Domain}Dto;
import com.kh.server.dto.PageDto;
import com.kh.server.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author han.ke
 */
@Slf4j
@RestController
@RequestMapping("/admin/${domain}")
public class ${Domain}Controller {

    public static final String BUSINESS_NAME = "${tableNameCn}";

    @Resource
    private ${Domain}Service service;

    /**
     * 列表查询
     * @param pageDto
     * @return
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        log.info("pageDto: -> {}", pageDto);
        ResponseDto responseDto = new ResponseDto<>();
        service.list${Domain}(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * id有值时更新，无值时新增
     * @param ${domain}Dto
     * @return
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ${Domain}Dto ${domain}Dto) {
        log.info("${domain}Dto: -> {}", ${domain}Dto);
        service.save(${domain}Dto);
        ResponseDto responseDto = new ResponseDto<>();
        responseDto.setContent(${domain}Dto);
        return responseDto;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        log.info("${domain}ID -> {}", id);
        service.removeById(id);
        return new ResponseDto();
    }
}
