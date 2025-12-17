CREATE TABLE members (
    id UUID PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    gender VARCHAR(50),
    date_of_birth DATE,
    phone VARCHAR(50),
    email VARCHAR(255),
    abroad BOOLEAN,
    country_of_residence VARCHAR(100),
    branch_id UUID,
    permanent_address_id UUID,
    temporary_address_id UUID,
    CONSTRAINT fk_member_branch FOREIGN KEY (branch_id)
        REFERENCES branch_churches(id),
    CONSTRAINT fk_member_permanent_address FOREIGN KEY (permanent_address_id)
        REFERENCES addresses(id),
    CONSTRAINT fk_member_temporary_address FOREIGN KEY (temporary_address_id)
        REFERENCES addresses(id)
);

-- indexes
CREATE INDEX idx_members_branch ON members(branch_id);
CREATE INDEX idx_members_email ON members(email);
