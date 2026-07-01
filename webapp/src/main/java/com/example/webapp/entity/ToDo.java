package com.example.webapp.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {

	/** ID */
	private Integer id;

	/** タスク名 */
	private String todo;

	/** 詳細 */
	private String detail;

	/** 作成日時 */
	private LocalDateTime createdAt;

	/** 更新日時 */
	private LocalDateTime updatedAt;

	/** 完了状態 */
	private Boolean isCompleted;

	/** 締切日 */
	private LocalDate dueDate;
	
	/** カテゴリ */
	private String category;

	/** 削除フラグ（0:有効 1:削除） */
	private Integer deleteFlag;

}