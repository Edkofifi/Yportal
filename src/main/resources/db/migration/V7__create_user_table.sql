CREATE TABLE users (
    id UUID PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255),
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    member_id UUID,
    CONSTRAINT fk_users_member
            FOREIGN KEY (member_id)
            REFERENCES members(id)
            ON DELETE SET NULL
);
