package com.rustemsarica.enoca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rustemsarica.enoca.dto.TableDto;
import com.rustemsarica.enoca.services.DynamicTableService;

@RestController
@RequestMapping("/tables")
public class TableController {
    
    @Autowired
    public DynamicTableService dynamicTableService;

    @GetMapping("/{tableName}")
    public ResponseEntity<?> getTable(@PathVariable String tableName) { 
        
        return ResponseEntity.ok(dynamicTableService.getTable(tableName));
    }

    @PostMapping
    public ResponseEntity<?> createTable(@RequestBody TableDto tableDto) {        
        dynamicTableService.createTable(tableDto.getTablename());
        return ResponseEntity.ok("Table created");
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertData(@RequestBody TableDto tableDto){
        dynamicTableService.insertData(tableDto.getTablename(), tableDto.getData());
        return ResponseEntity.ok("Data inserted");
    }

    @DeleteMapping("/{tableName}/{dataId}")
    public ResponseEntity<?> deleteData(@PathVariable String tableName, @PathVariable long dataId) { 
        Object object =  dynamicTableService.deleteDataFromTable(tableName, dataId);
        if(object.equals(0)){
            return ResponseEntity.ok("Data not found");
        }
        return ResponseEntity.ok("Data is deleted");
    }
}