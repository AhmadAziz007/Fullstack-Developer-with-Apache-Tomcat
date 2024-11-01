package com.fullstack.apachetomcat.service.implement;

import com.fullstack.apachetomcat.dto.MstKendaraanDto;
import com.fullstack.apachetomcat.model.MstKendaraan;
import com.fullstack.apachetomcat.repository.KendaraanRepository;
import com.fullstack.apachetomcat.service.KendaraanService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class KendaraanServiceImplement implements KendaraanService {

    @Autowired
    private KendaraanRepository kendaraanRepository;

    @Override
    public ResponseEntity<?> createKendaraan(MstKendaraanDto mstKendaraanDto) {
        try {

            if (mstKendaraanDto.getNoRegistrasi() == null &&
                mstKendaraanDto.getNamaPemilik() == null &&
                mstKendaraanDto.getAlamat() == null &&
                mstKendaraanDto.getMerkKendaraan() == null &&
                mstKendaraanDto.getTahunPembuatan() == null &&
                mstKendaraanDto.getKapasitasSilinder() == null &&
                mstKendaraanDto.getWarnaKendaraan() == null &&
                mstKendaraanDto.getBahanBakar() == null) {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fields cannot be null");
            }
            MstKendaraan kendaraan = new MstKendaraan();
            kendaraan.setNoRegistrasi(mstKendaraanDto.getNoRegistrasi());
            kendaraan.setNamaPemilik(mstKendaraanDto.getNamaPemilik());
            kendaraan.setAlamat(mstKendaraanDto.getAlamat());
            kendaraan.setMerkKendaraan(mstKendaraanDto.getMerkKendaraan());
            kendaraan.setTahunPembuatan(mstKendaraanDto.getTahunPembuatan());
            kendaraan.setKapasitasSilinder(mstKendaraanDto.getKapasitasSilinder());
            kendaraan.setWarnaKendaraan(mstKendaraanDto.getWarnaKendaraan());
            kendaraan.setBahanBakar(mstKendaraanDto.getBahanBakar());

            kendaraan.setCreatedDatetime(new Date());
            kendaraan.setCreatedBy("Admin");

            System.out.println("Data kendaraan yang akan disimpan: " + kendaraan);

            MstKendaraan savedKendaraan = kendaraanRepository.save(kendaraan);

            return ResponseEntity.ok("Kendaraan created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating kendaraan" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateKendaraan(Long kendaraanId, MstKendaraanDto mstKendaraanDto) {
        Optional<MstKendaraan> kendaraanOpt = kendaraanRepository.findByKendaraanId(kendaraanId);
        if (kendaraanOpt.isPresent()) {
            MstKendaraan kendaraan = kendaraanOpt.get();
            kendaraan.setNoRegistrasi(mstKendaraanDto.getNoRegistrasi());
            kendaraan.setNamaPemilik(mstKendaraanDto.getNamaPemilik());
            kendaraan.setAlamat(mstKendaraanDto.getAlamat());
            kendaraan.setMerkKendaraan(mstKendaraanDto.getMerkKendaraan());
            kendaraan.setTahunPembuatan(mstKendaraanDto.getTahunPembuatan());
            kendaraan.setKapasitasSilinder(mstKendaraanDto.getKapasitasSilinder());
            kendaraan.setWarnaKendaraan(mstKendaraanDto.getWarnaKendaraan());
            kendaraan.setBahanBakar(mstKendaraanDto.getBahanBakar());

            kendaraan.setUpdatedDatetime(new Date());
            kendaraan.setUpdatedBy("Admin");

            kendaraanRepository.save(kendaraan);
            return ResponseEntity.ok("Kendaraan updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kendaraan not found");
        }
    }

    @Override
    public Optional<MstKendaraan> getKendaraanById(Long kendaraanId) {
        return kendaraanRepository.findByKendaraanId(kendaraanId);
    }

    @Override
    public List<MstKendaraan> getKendaraan(String noRegistrasi, String namaPemilik) {
        if ((noRegistrasi == null || noRegistrasi.isEmpty()) && (namaPemilik == null || namaPemilik.isEmpty())) {
            return kendaraanRepository.findAll();
        } else {
            noRegistrasi = noRegistrasi != null ? noRegistrasi.toUpperCase() : "";
            namaPemilik = namaPemilik != null ? namaPemilik.toUpperCase() : "";
            return kendaraanRepository.findByLikeCriteria(noRegistrasi, namaPemilik);
        }
    }

    @Override
    public ResponseEntity<?> deleteKendaraan(Long kendaraanId) {
        Optional<MstKendaraan> kendaraan = kendaraanRepository.findByKendaraanId(kendaraanId);
        if (kendaraan.isPresent()) {
            kendaraanRepository.delete(kendaraan.get());
            return new ResponseEntity<>("Kendaraan deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Kendaraan not found", HttpStatus.NOT_FOUND);
        }
    }
}
