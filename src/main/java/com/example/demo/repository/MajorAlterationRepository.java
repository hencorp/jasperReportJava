package com.example.demo.repository;

import com.example.demo.model.MajorAlterationDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorAlterationRepository extends JpaRepository<MajorAlterationDoc,Long> {

}
