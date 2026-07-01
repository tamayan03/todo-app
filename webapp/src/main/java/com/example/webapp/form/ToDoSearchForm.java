package com.example.webapp.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ToDoSearchForm {

    /** タイトル */
    private String keyword;

    /** カテゴリ */
    private String category;

    /** 完了状態 */
    private Boolean isCompleted;

    /** 締切日From */
    private LocalDate fromDate;

    /** 締切日To */
    private LocalDate toDate;
    
    /** ページ番号 */
    private Integer page = 1;
    
    /** 1ページの表示件数 */
    private Integer size = 10;

}