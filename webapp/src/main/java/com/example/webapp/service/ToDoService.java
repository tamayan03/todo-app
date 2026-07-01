package com.example.webapp.service;

import java.util.List;

import com.example.webapp.entity.ToDo;

public interface ToDoService {

    /**
     * 全「すること」を検索
     */
	List<ToDo> findAllToDo(String sort);

    /**
     * 指定されたIDの「すること」を検索
     */
    ToDo findByIdToDo(Integer id);

    /**
     * 「すること」を新規登録
     */
    void insertToDo(ToDo toDo);

    /**
     * 「すること」を更新
     */
    void updateToDo(ToDo toDo);

    /**
     * 指定されたIDの「すること」を削除
     */
    void deleteToDo(Integer id);

    List<ToDo> findByTodo(String keyword);

    /** タイトル・カテゴリ検索 */
    List<ToDo> search(String keyword, String category);
    
    void complete(Integer id);
    
    int getCompletedCount();
    
    /**
     * 同名の未完了タスクを検索
     */
    ToDo findDuplicateTodo(String todo);
    

}

