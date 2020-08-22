package com.foreverredremilia.jpademo.controller;

import com.foreverredremilia.jpademo.entity.dto.QueryDto;
import com.foreverredremilia.jpademo.entity.vo.CharacterPage;
import com.foreverredremilia.jpademo.entity.vo.CharacterVo;
import com.foreverredremilia.jpademo.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/test")
public class TestController {


    private final CharacterService characterService;

    @Autowired
    public TestController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @RequestMapping("/test")
    @ResponseBody
    public Map<String, Object> test(@RequestBody @Validated QueryDto queryDto, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.getErrorCount() > 0) {
            StringBuilder msg = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                msg.append(error.getDefaultMessage()).append(";");
            }
            result.put("msg", msg);
            return result;
        }
        long start = System.currentTimeMillis();
        List<CharacterVo> charaVos = characterService.getCharaVo(queryDto);
        result.put("time", System.currentTimeMillis() - start + "ms");
        result.put("total", charaVos.size());
        result.put("data", charaVos);
        return result;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public Map<String, Object> test2(@RequestBody @Validated QueryDto queryDto, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.getErrorCount() > 0) {
            StringBuilder msg = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                msg.append(error.getDefaultMessage()).append(";");
            }
            result.put("msg", msg);
            return result;
        }
        long start = System.currentTimeMillis();
        List<CharacterVo> charaVos = characterService.getCharaVo2(queryDto);
        result.put("time", System.currentTimeMillis() - start + "ms");
        result.put("total", charaVos.size());
        result.put("data", charaVos);
        return result;
    }

    @RequestMapping("/test3")
    @ResponseBody
    public Map<String, Object> test3(@RequestBody @Validated QueryDto queryDto, BindingResult bindingResult) {
        Map<String, Object> result = new LinkedHashMap<>();
        if (bindingResult.getErrorCount() > 0) {
            StringBuilder msg = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                msg.append(error.getDefaultMessage()).append(";");
            }
            result.put("msg", msg);
            return result;
        }
        long start = System.currentTimeMillis();
        CharacterPage characterPage = characterService.getCharaPage(queryDto);
        result.put("time", System.currentTimeMillis() - start + "ms");
        result.put("count",characterPage.getCount());
        result.put("page",queryDto.getPage());
        result.put("size", characterPage.getCharacterVoList().size());
        result.put("data", characterPage.getCharacterVoList());
        return result;
    }

}
