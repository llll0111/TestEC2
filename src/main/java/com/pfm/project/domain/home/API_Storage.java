package com.pfm.project.domain.home;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class API_Storage {

    @Id
    private Long store_id;

    @Column(length = 200)
    private String store_name;
    private int store_type;
    @Column(length = 100)
    private String store_tpye_name;
    @Column(length = 200)
    private String store_address;
    @Column(length = 200)
    private String store_number;
    @Column(length = 200)
    private String store_waytogo;
    private String store_pride;
    @Column(length = 200)
    private String store_url;
    @Column(length = 200)
    private String store_info;

    public API_Storage() {
    }

    public API_Storage(Long store_id, String store_name, int store_type, String store_tpye_name, String store_address, String store_number, String store_waytogo, String store_price, String store_url, String store_info) {
        this.store_id = store_id;
        this.store_name = store_name;
        this.store_type = store_type;
        this.store_tpye_name = store_tpye_name;
        this.store_address = store_address;
        this.store_number = store_number;
        this.store_waytogo = store_waytogo;
        this.store_pride = store_price;
        this.store_url = store_url;
        this.store_info = store_info;
    }

    public Long getStore_id() {
        return store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public int getStore_type() {
        return store_type;
    }

    public String getStore_tpye_name() {
        return store_tpye_name;
    }

    public String getStore_address() {
        return store_address;
    }

    public String getStore_number() {
        return store_number;
    }

    public String getStore_waytogo() {
        return store_waytogo;
    }

    public String getStore_pride() {
        return store_pride;
    }

    public String getStore_url() {
        return store_url;
    }

    public String getStore_info() {
        return store_info;
    }
}
