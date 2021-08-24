package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.mapper.TableMapper;
import com.example.demo.model.Table;
import com.example.demo.model.TableDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/table")
@RequiredArgsConstructor
@RestController
public class TableController {

    @Autowired
    private TableMapper tableMapper;

    @PostMapping("/insert")
    public Map<String, String> insert(@RequestParam final Map<String, String> param
    // TableDTO tableDTO
    ) {
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("status", "fail");
        String table_title = param.get("table_title");
        String table_text = param.get("table_text");
        Table table = new Table(table_title, "글쓴이", table_text);
        try {
            tableMapper.insertOne(table);

            ret.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @GetMapping("/getall")
    public Map<String, List<?>> getAll(@RequestParam final Map<String, String> param,
            final HttpServletRequest request) {
        // final HttpSession session = request.getSession();
        // String userid = session.getAttribute("userid");

        // final HttpSession session = request.getSession();
        // session.setAttribute("userid",userid);

        Map<String, List<?>> ret = new HashMap<String, List<?>>();
        try {
            List<Table> list = tableMapper.getAll();
            ret.put("data", list);
        } catch (Exception e) {
        }
        return ret;
    }

}
