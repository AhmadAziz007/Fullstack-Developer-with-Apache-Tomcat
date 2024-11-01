package com.fullstack.apachetomcat.service;

import com.fullstack.apachetomcat.dto.MstKendaraanDto;
import com.fullstack.apachetomcat.model.MstKendaraan;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface KendaraanService {
    public ResponseEntity<?> createKendaraan(MstKendaraanDto mstKendaraanDto);
    public ResponseEntity<?> updateKendaraan(Long kendaraanId, MstKendaraanDto mstKendaraanDto);
    public Optional<MstKendaraan> getKendaraanById(Long kendaraanId);
    public  List<MstKendaraan> getKendaraan(String noRegistrasi, String namaPemilik);
    public ResponseEntity<?> deleteKendaraan(Long kendaraanId);
}
