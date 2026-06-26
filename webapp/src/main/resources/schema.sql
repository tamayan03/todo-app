-- テーブルが存在したら削除
DROP TABLE IF EXISTS todos;

-- テーブル作成
CREATE TABLE todos(

    id serial PRIMARY KEY,

    todo varchar(255) NOT NULL,

    detail text,

    created_at timestamp without time zone,

    updated_at timestamp without time zone,

    is_completed BOOLEAN DEFAULT false,

    due_date DATE

);