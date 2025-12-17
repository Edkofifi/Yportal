CREATE TABLE employment (
    id UUID PRIMARY KEY,
    employed BOOLEAN,
    company_name VARCHAR(255),
    position VARCHAR(255),
    industry VARCHAR(255),
    member_id UUID UNIQUE,
    CONSTRAINT fk_employment_member FOREIGN KEY (member_id)
        REFERENCES members(id)
        ON DELETE CASCADE
);
