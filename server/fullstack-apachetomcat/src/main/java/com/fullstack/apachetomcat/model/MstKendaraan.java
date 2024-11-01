package com.fullstack.apachetomcat.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "kendaraan", schema = "public")
public class MstKendaraan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kendaraan_id")
    private Long kendaraanId;

    @Column(name = "no_registrasi")
    private String noRegistrasi;

    @Column(name = "nama_pemilik")
    private String namaPemilik;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "merk_kendaraan")
    private String merkKendaraan;

    @Column(name = "tahun_pembuatan", length = 4)
    private Integer tahunPembuatan;

    @Column(name = "kapasitas_silinder")
    private Integer kapasitasSilinder;

    @Column(name = "warna_kendaraan")
    private String warnaKendaraan;

    @Column(name = "bahan_bakar")
    private String bahanBakar;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "created_datetime")
    private Date createdDatetime;

    @Column(name = "updated_datetime")
    private Date updatedDatetime;

    public Long getKendaraanId() {
        return kendaraanId;
    }

    public void setKendaraanId(Long kendaraanId) {
        this.kendaraanId = kendaraanId;
    }

    public String getNoRegistrasi() {
        return noRegistrasi;
    }

    public void setNoRegistrasi(String noRegistrasi) {
        this.noRegistrasi = noRegistrasi;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMerkKendaraan() {
        return merkKendaraan;
    }

    public void setMerkKendaraan(String merkKendaraan) {
        this.merkKendaraan = merkKendaraan;
    }

    public Integer getTahunPembuatan() {
        return tahunPembuatan;
    }

    public void setTahunPembuatan(Integer tahunPembuatan) {
        this.tahunPembuatan = tahunPembuatan;
    }

    public Integer getKapasitasSilinder() {
        return kapasitasSilinder;
    }

    public void setKapasitasSilinder(Integer kapasitasSilinder) {
        this.kapasitasSilinder = kapasitasSilinder;
    }

    public String getWarnaKendaraan() {
        return warnaKendaraan;
    }

    public void setWarnaKendaraan(String warnaKendaraan) {
        this.warnaKendaraan = warnaKendaraan;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public Date getUpdatedDatetime() {
        return updatedDatetime;
    }

    public void setUpdatedDatetime(Date updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }
}
