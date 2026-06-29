
# ToDoアプリ

## 概要

Spring Bootを使用して作成したToDo管理アプリケーションです。

ToDoの登録・編集・削除・検索・完了管理などの基本機能に加え、締切日設定機能を実装しています。

---

## 画面イメージ

### 一覧画面

<img width="896" height="656" alt="スクリーンショット 2026-06-29 13 42 59" src="https://github.com/user-attachments/assets/50c5d9d1-a029-4b53-bf59-8c4ac2dbe333" />


一覧画面では登録済みのToDoを確認できます。

### 登録・編集画面

<img width="1470" height="956" alt="スクリーンショット 2026-06-29 13 43 50" src="https://github.com/user-attachments/assets/712782d0-9195-461d-aeb6-b9816d115ae3" />


タイトルや詳細、締切日、完了状態を設定できます。

## 使用技術

* Java 21
* Spring Boot
* Thymeleaf
* MyBatis
* PostgreSQL
* Gradle
* Git / GitHub
* Eclipse

---

## 主な機能

* ToDoの新規登録
* ToDoの一覧表示
* ToDoの編集
* ToDoの削除
* タイトル検索
* 完了状態の管理
* 締切日の設定
* 達成済み件数の表示

---

## 動作環境

* Java 21
* PostgreSQL
* Eclipse
* Git

---

## セットアップ手順

### 1. リポジトリを取得

bash
git clone https://github.com/tamayan03/todo-app.git


### 2. PostgreSQLを起動する

PostgreSQLをインストールし、サーバーを起動します。

### 3. データベースを作成する

例

sql
CREATE DATABASE todo;


### 4. テーブルを作成する

プロジェクト内の `schema.sql` を実行し、todosテーブルを作成します。

### 5. application.propertiesを設定する

データベース接続情報を環境に合わせて設定してください。

例

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todo
spring.datasource.username=postgres
spring.datasource.password=パスワード

### 6. アプリケーションを起動する

`ToDoApplication.java` を実行するとアプリケーションが起動します。

ブラウザで以下へアクセスしてください。

http://localhost:8080/todos

---

## ディレクトリ構成

src
├── controller
├── service
├── repository
├── entity
├── form
├── helper
├── templates
└── mapper

---

## 今後追加予定

* ログ出力機能
* 論理削除
* タイトル重複チェック
* 締切日の入力チェック
* 締切超過タスクの色分け表示

---

## 作者

玉舎 亮太朗
