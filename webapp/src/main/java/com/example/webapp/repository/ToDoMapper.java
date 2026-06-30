package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.webapp.entity.ToDo;

@Mapper
public interface ToDoMapper {

    /**
     * すべての「すること」を取得
     */
	List<ToDo> selectAll(String sort);

    /**
     * 指定されたIDに対応する「すること」を取得
     */
    ToDo selectById(@Param("id") Integer id);

    /**
     * 「すること」を登録
     */
    void insert(ToDo todo);

    /**
     * 「すること」を更新
     */
    void update(ToDo todo);
    
    /**
     * 指定されたIDの「すること」を削除
     */
    void delete(@Param("id") Integer id);

    /**
     * タイトル検索
     */
    List<ToDo> selectByTodo(@Param("keyword") String keyword);
    
    /**
     * 達成済み件数を取得
     */
    int getCompletedCount();
    
    /**
     * 同名の未完了タスクを取得
     */
    ToDo selectDuplicateTodo(@Param("todo") String todo);

}