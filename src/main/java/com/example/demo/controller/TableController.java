package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.example.demo.dto.TableDTO;
import com.example.demo.mapper.TableMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        TableDTO table = new TableDTO(table_title, "글쓴이", table_text);
        try {
            tableMapper.insertTable(table);
            ret.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @GetMapping("/getlist/{tableid}/{page}/{sort}/{order}")
    public Map<String, List<TableDTO>> selectTable(@RequestParam final Map<String, List<TableDTO>> param,
            final HttpServletRequest request) {
        Map<String, List<TableDTO>> ret = new HashMap<String, List<TableDTO>>();
        try {
            List<TableDTO> list = tableMapper.selectTable();
            ret.put("data", list);
        } catch (Exception e) {
        }
        return ret;
        // final HttpSession session = request.getSession();
        // String userid = session.getAttribute("userid");

        // final HttpSession session = request.getSession();
        // session.setAttribute("userid",userid);
    }

    @PostMapping("/deleteTable/{table_id}")
    public Long deleteTable(@PathVariable("table_id") Long table_id) {
        tableMapper.deleteTable(table_id);
        return table_id;
    }

    @GetMapping("/view/{table_id}")
    public Long selectDetail(@PathVariable("table_id") Long table_id, Model model) {
        model.addAttribute("table_id", tableMapper.selectDetail(table_id));
        return table_id;
    }

    // @PostMapping("/login")
    // public void loginPost(LoginDTO loginDTO, HttpSession session) throws
    // Exception {

    // }

}
