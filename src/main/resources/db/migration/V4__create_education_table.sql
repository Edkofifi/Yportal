CREATE TABLE education (
    id UUID PRIMARY KEY,
    level VARCHAR(50),
    currently_in_school BOOLEAN,
    institution_name VARCHAR(255),
    course VARCHAR(255),
    specialization VARCHAR(255),
    member_id UUID UNIQUE,
    CONSTRAINT fk_education_member FOREIGN KEY (member_id)
        REFERENCES members(id)
        ON DELETE CASCADE
);
