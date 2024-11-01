package com.fullstack.apachetomcat.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fullstack.apachetomcat.model.MstKendaraan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MstKendaraanDto {
    private Long kendaraanId;

    private String noRegistrasi;

    private String namaPemilik;

    private String alamat;

    private String merkKendaraan;

    private Integer tahunPembuatan;

    private Integer kapasitasSilinder;

    private String warnaKendaraan;

    private String bahanBakar;

    private String createdBy;

    private String updatedBy;

    private Date createdDatetime;

    private Date updatedDatetime;

    public MstKendaraanDto(MstKendaraan mstKendaraan) {
        this.kendaraanId = mstKendaraan.getKendaraanId();
        this.noRegistrasi = mstKendaraan.getNoRegistrasi();
        this.namaPemilik = mstKendaraan.getNamaPemilik();
        this.merkKendaraan = mstKendaraan.getMerkKendaraan();
        this.alamat = mstKendaraan.getAlamat();
        this.tahunPembuatan = mstKendaraan.getTahunPembuatan();
        this.kapasitasSilinder = mstKendaraan.getKapasitasSilinder();
        this.warnaKendaraan = mstKendaraan.getWarnaKendaraan();
        this.bahanBakar = mstKendaraan.getBahanBakar();
        // Tambahkan semua field yang diperlukan
    }

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
