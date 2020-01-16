/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learning.file.upload.with.mysql.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author garnnet
 */
@Entity
public class StoreEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    
    public String entityName;
    
    public String imageLocation;

    public StoreEntity() {
    }

    public StoreEntity(String entityName, String imageLocation) {
        this.entityName = entityName;
        this.imageLocation = imageLocation;
    }

    public Long getId() {
        return id;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    @Override
    public String toString() {
        return "StoreEntity{" + "id=" + id + ", entityName=" + entityName + ", imageLocation=" + imageLocation + '}';
    }
    
    
    
}
