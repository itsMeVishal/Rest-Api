package com.vish.security.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vish.security.security.demo.entity.FileModel;

@Repository
public interface FileRepository extends JpaRepository<FileModel, Long>{

}
