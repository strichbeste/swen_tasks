-- aufgabe: task-liste als use case fuer persistente daten
-- schema mit datentypen, constraints und relationen

CREATE TABLE IF NOT EXISTS tasks (
    id          SERIAL PRIMARY KEY,           -- auto-increment primary key
    title       VARCHAR(255) NOT NULL,        -- pflichtfeld, max 255 zeichen
    description TEXT,                         -- optional, unbegrenzt
    done        BOOLEAN NOT NULL DEFAULT FALSE, -- standardmaessig offen
    created_at  TIMESTAMP DEFAULT NOW()       -- automatisch gesetzt
);

CREATE TABLE IF NOT EXISTS tags (
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE         -- unique: kein doppelter tag-name
);

-- n:m beziehung zwischen tasks und tags
CREATE TABLE IF NOT EXISTS task_tags (
    task_id INT REFERENCES tasks(id) ON DELETE CASCADE,
    tag_id  INT REFERENCES tags(id)  ON DELETE CASCADE,
    PRIMARY KEY (task_id, tag_id)             -- zusammengesetzter primary key
);
