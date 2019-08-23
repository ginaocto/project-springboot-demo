package com.tmsi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmsi.demo.model.Dosen;

@Repository
public interface DosenRepository extends JpaRepository<Dosen, Long>{

}
