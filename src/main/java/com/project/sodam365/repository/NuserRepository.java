package com.project.sodam365.repository;

import com.project.sodam365.entity.Nuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NuserRepository extends JpaRepository<Nuser, String> {
}
