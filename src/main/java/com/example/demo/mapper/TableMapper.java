package com.example.demo.mapper;

import java.util.List;

import com.example.demo.model.Table;

public interface TableMapper {

    public void insertOne(Table table);

    public List<Table> getAll();

    // @Insert("INSERT INTO tables(table_title, table_autor, table_text)
    // VALUES(#{table.title},#{table.autor},#{table.text})")
    // int insert(@Param("tables")Table table);

    // @Select("SELECT * FROM tables")
    // List<Table> getAll();

}
