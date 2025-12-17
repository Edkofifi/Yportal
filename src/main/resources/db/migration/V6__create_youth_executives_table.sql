CREATE TABLE youth_executives (
    id UUID PRIMARY KEY,
    member_id UUID UNIQUE,
    position VARCHAR(50),
    CONSTRAINT fk_youth_executive_member FOREIGN KEY (member_id)
        REFERENCES members(id)
        ON DELETE CASCADE
);
