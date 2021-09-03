package com.example.demo.mapper;

import java.util.List;

import com.example.demo.dto.TableDTO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TableMapper {

    public int insertTable(TableDTO params);

    public List<TableDTO> selectTable();

    public int updateTable(TableDTO params);

    public int deleteTable(Long table_id);

    public TableDTO selectDetail(Long table_id);

}
