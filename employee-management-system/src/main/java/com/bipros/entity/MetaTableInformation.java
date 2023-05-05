package com.bipros.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "meta_table_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaTableInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String tableName;

	private String jsonStructure;
	
	
	public MetaTableInformation(String tableName, String jsonStructure) {
		this.tableName = tableName;
		this.jsonStructure = jsonStructure;
	}
}
