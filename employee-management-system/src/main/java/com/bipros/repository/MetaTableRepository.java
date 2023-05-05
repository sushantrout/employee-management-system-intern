package com.bipros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bipros.entity.MetaTableInformation;

@Repository
public interface MetaTableRepository extends JpaRepository<MetaTableInformation, Long> {
    MetaTableInformation findByTableName(String tableName);
}
