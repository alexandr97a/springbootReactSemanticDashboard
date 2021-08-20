package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.mapper.TableMapper;
import com.example.demo.model.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequestMapping("/table")
@Getter
@RequiredArgsConstructor
@RestController
public class TableController {

    @Autowired
    private TableMapper tableMapper;

    @GetMapping("/insert")
    public int insert(@RequestBody Table table){
        return tableMapper.insertOne(table);
    }

    @GetMapping("/getall")
    public Map<String,List<?>> getAll(@RequestParam final Map<String,String> param, final HttpServletRequest request){
        Map<String,List<?>> ret = new HashMap<String,List<?>>();
        List<Table> list = tableMapper.getAll();
        ret.put("data"  , list);
        return ret;
    }

}
