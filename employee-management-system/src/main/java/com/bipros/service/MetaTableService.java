package com.bipros.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bipros.entity.MetaTableInformation;
import com.bipros.repository.MetaTableRepository;

@Service
public class MetaTableService {
    @Autowired
    private MetaTableRepository metaTableRepository;

    public MetaTableInformation createMetaTable(String tableName, String jsonStructure) {
    	MetaTableInformation metaTable = new MetaTableInformation(tableName, jsonStructure);
        return metaTableRepository.save(metaTable);
    }

    public MetaTableInformation updateMetaTable(String tableName, String jsonStructure) {
    	MetaTableInformation metaTable = metaTableRepository.findByTableName(tableName);
        metaTable.setJsonStructure(jsonStructure);
        return metaTableRepository.save(metaTable);
    }

    public void deleteMetaTable(String tableName) {
    	MetaTableInformation metaTable = metaTableRepository.findByTableName(tableName);
        metaTableRepository.delete(metaTable);
    }

    public String getJsonStructure(String tableName) {
    	MetaTableInformation metaTable = metaTableRepository.findByTableName(tableName);
        return metaTable.getJsonStructure();
    }

    public List<String> getTableNames() {
        List<MetaTableInformation> metaTables = metaTableRepository.findAll();
        List<String> tableNames = metaTables.stream()
                .map(MetaTableInformation::getTableName)
                .collect(Collectors.toList());
        return tableNames;
    }
    
    public String getJsonSchemaForTable(String tableName) {
        Optional<MetaTableInformation> metadata = Optional.of(metaTableRepository.findByTableName(tableName));
        if (metadata.isPresent()) {
            return metadata.get().getJsonStructure();
        } else {
            throw new RuntimeException("Metadata not found for table: " + tableName);
        }
    }
}

