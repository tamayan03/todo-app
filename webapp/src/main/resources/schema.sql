-- テーブルが存在したら削除
DROP TABLE IF EXISTS todos;

-- テーブル作成
CREATE TABLE todos (
    id SERIAL PRIMARY KEY,
    todo VARCHAR(100),
    detail TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    is_completed BOOLEAN DEFAULT false,
    due_date DATE,
    category VARCHAR(30),
    delete_flag INTEGER DEFAULT 0
);