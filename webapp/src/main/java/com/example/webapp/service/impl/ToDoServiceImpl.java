package com.example.webapp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.ToDo;
import com.example.webapp.repository.ToDoMapper;
import com.example.webapp.service.ToDoService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    /** DI */
    private final ToDoMapper toDoMapper;

    /** ロガー */
    private static final Logger logger = LoggerFactory.getLogger(ToDoServiceImpl.class);

    @Override
    public List<ToDo> findAllToDo(String sort) {

        logger.info("ToDo一覧取得開始");

        List<ToDo> todos = toDoMapper.selectAll(sort);

        logger.info("ToDo一覧取得終了 件数={}", todos.size());

        return todos;
    }

    @Override
    public ToDo findByIdToDo(Integer id) {

        logger.info("ToDo取得開始 id={}", id);

        ToDo todo = toDoMapper.selectById(id);

        logger.info("ToDo取得終了 id={}", id);

        return todo;
    }

    @Override
    public void insertToDo(ToDo toDo) {

        logger.info("ToDo登録開始 title={}", toDo.getTodo());

        toDoMapper.insert(toDo);

        logger.info("ToDo登録終了");
    }

    @Override
    public void updateToDo(ToDo toDo) {

        logger.info("ToDo更新開始 id={}", toDo.getId());

        toDoMapper.update(toDo);

        logger.info("ToDo更新終了 id={}", toDo.getId());
    }

    @Override
    public void deleteToDo(Integer id) {

        logger.info("ToDo削除開始 id={}", id);

        toDoMapper.delete(id);

        logger.info("ToDo削除終了 id={}", id);
    }

    @Override
    public List<ToDo> findByTodo(String keyword) {

        logger.info("タイトル検索開始 keyword={}", keyword);

        List<ToDo> todos = toDoMapper.selectByTodo(keyword);

        logger.info("タイトル検索終了 件数={}", todos.size());

        return todos;
    }

    @Override
    public void complete(Integer id) {

        logger.info("完了処理開始 id={}", id);

        ToDo todo = toDoMapper.selectById(id);

        todo.setIsCompleted(true);

        toDoMapper.update(todo);

        logger.info("完了処理終了 id={}", id);
    }

    @Override
    public int getCompletedCount() {

        logger.info("完了件数取得開始");

        int count = toDoMapper.getCompletedCount();

        logger.info("完了件数取得終了 件数={}", count);

        return count;
    }
    
    @Override
    public ToDo findDuplicateTodo(String todo) {

        logger.info("タイトル重複チェック開始 title={}", todo);

        ToDo duplicateTodo = toDoMapper.selectDuplicateTodo(todo);

        logger.info("タイトル重複チェック終了");

        return duplicateTodo;
    }
    
    @Override
    public List<ToDo> search(
            String keyword,
            String category) {

        logger.info("検索開始 keyword={}, category={}", keyword, category);

        List<ToDo> todos = toDoMapper.search(keyword, category);

        logger.info("検索終了 件数={}", todos.size());

        return todos;
    }

}