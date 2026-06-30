package com.example.webapp.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class ToDoForm {

    /** することID */
    private Integer id;

    /** すること */
    @NotBlank(message = "タイトルを入力してください")
    private String todo;

    /** すること詳細 */
    private String detail;

    /** 新規判定 */
    private Boolean isNew;
    
    /** 締切日 */
    private LocalDate dueDate;
    
    /** カテゴリ */
    private String category;

    public ToDoForm() {
    }
    
    /** 完了状態 */
    private Boolean isCompleted;

    /** 削除フラグ */
    private Integer deleteFlag;

    public ToDoForm(
            Integer id,
            String todo,
            String detail,
            Boolean isCompleted,
            Boolean isNew,
            LocalDate dueDate,
            String category,
            Integer deleteFlag
    ) {
        this.id = id;
        this.todo = todo;
        this.detail = detail;
        this.isCompleted = isCompleted;
        this.isNew = isNew;
        this.dueDate = dueDate;
        this.category = category;
        this.deleteFlag = deleteFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }
    
    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}