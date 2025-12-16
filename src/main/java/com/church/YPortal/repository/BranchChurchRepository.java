package com.church.YPortal.repository;

import com.church.YPortal.entity.BranchChurch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BranchChurchRepository extends JpaRepository<BranchChurch, UUID> {

}
