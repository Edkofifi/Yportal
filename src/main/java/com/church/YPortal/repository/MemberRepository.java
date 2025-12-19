package com.church.YPortal.repository;


import com.church.YPortal.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository  extends JpaRepository<Member, UUID> {
}
