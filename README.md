# ToDoアプリ

## 概要

Spring Bootを使用して作成したToDo管理アプリケーションです。

ToDoの登録・編集・検索・論理削除・完了管理などの基本機能に加え、締切日設定や入力チェック機能を実装しています。

---

## 画面イメージ

### 一覧画面

<img width="896" height="656" alt="スクリーンショット 2026-06-29 13 42 59" src="https://github.com/user-attachments/assets/50c5d9d1-a029-4b53-bf59-8c4ac2dbe333" />

一覧画面では登録済みのToDoを確認できます。

### 登録・編集画面

<img width="1470" height="956" alt="スクリーンショット 2026-06-29 13 43 50" src="https://github.com/user-attachments/assets/712782d0-9195-461d-aeb6-b9816d115ae3" />

タイトルや詳細、締切日、完了状態を設定できます。

---

## 使用技術

* Java 21
* Spring Boot 4.0.6
* Thymeleaf 3.x
* MyBatis 3.0
* PostgreSQL 17
* Gradle
* Git / GitHub
* Eclipse

---

## 主な機能

* ToDoの新規登録
* ToDoの一覧表示
* ToDoの編集
* ToDoの論理削除
* タイトル検索
* タイトル重複チェック
* 完了状態の管理
* 締切日の設定
* 締切日の入力チェック
* 締切超過タスクの色分け表示
* ログ出力
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

```bash
git clone https://github.com/tamayan03/todo-app.git
```

### 2. PostgreSQLを起動する

PostgreSQLをインストールし、サーバーを起動します。

### 3. データベースを作成する

```sql
CREATE DATABASE todo;
```

### 4. アプリケーション起動時

アプリケーション起動時に `schema.sql` が自動実行され、todosテーブルが作成されます。

### 5. application.properties を設定する

データベース接続情報を環境に合わせて設定してください。

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todo
spring.datasource.username=postgres
spring.datasource.password=パスワード
```

### 6. アプリケーションを起動する

`ToDoApplication.java` を実行するとアプリケーションが起動します。

ブラウザで以下へアクセスしてください。

```text
http://localhost:8080/todos
```

---

## ディレクトリ構成

```text
src
├── controller
├── service
├── repository
├── entity
├── form
├── helper
├── templates
└── mapper
```

---

## 今後の改善案

* Git Flowを利用したブランチ運用
* Pull Requestを利用したコードレビュー
* JUnitを利用したテストコードの作成
* ページネーション機能
* ログイン機能

---

## 作者

玉舎 亮太朗
