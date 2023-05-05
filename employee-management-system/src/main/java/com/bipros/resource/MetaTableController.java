package com.bipros.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bipros.entity.MetaTableInformation;
import com.bipros.service.MetaTableService;

@RestController
public class MetaTableController {
    @Autowired
    private MetaTableService metaTableService;

    @PostMapping("/metaTables")
    public MetaTableInformation createMetaTable(@RequestBody MetaTableInformation metaTable) {
        return metaTableService.createMetaTable(metaTable.getTableName(), metaTable.getJsonStructure());
    }

    @PutMapping("/metaTables/{tableName}")
    public MetaTableInformation updateMetaTable(@PathVariable String tableName, @RequestBody MetaTableInformation metaTable) {
        return metaTableService.updateMetaTable(tableName, metaTable.getJsonStructure());
    }

    @DeleteMapping("/{tableName}")
    public ResponseEntity<?> deleteMetaTable(@PathVariable String tableName) {
        metaTableService.deleteMetaTable(tableName);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{tableName}/schema")
    public ResponseEntity<String> getJsonSchemaForTable(@PathVariable String tableName) {
        try {
            String jsonSchema = metaTableService.getJsonSchemaForTable(tableName);
            return ResponseEntity.ok(jsonSchema);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
