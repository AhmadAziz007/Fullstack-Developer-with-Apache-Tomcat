package com.fullstack.apachetomcat.controllerpurehtmljs;

import com.fullstack.apachetomcat.dto.MstKendaraanDto;
import com.fullstack.apachetomcat.model.MstKendaraan;
import com.fullstack.apachetomcat.service.KendaraanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kendaraan")
@CrossOrigin(origins = "*")
public class KendaraanControllerPureHtmlJs {
    @Autowired
    private KendaraanService kendaraanService;

    @GetMapping("/")
    public ResponseEntity<List<MstKendaraan>> getDaftarKendaraan(
            @RequestParam(required = false) String noRegistrasi,
            @RequestParam(required = false) String namaPemilik) {

        List<MstKendaraan> kendaraanList = kendaraanService.getKendaraan(noRegistrasi, namaPemilik);
        return ResponseEntity.ok(kendaraanList);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveKendaraan(@RequestBody MstKendaraanDto mstKendaraanDto) {
        return kendaraanService.createKendaraan(mstKendaraanDto);
    }

    @GetMapping("/edit/{kendaraanId}")
    public ResponseEntity<MstKendaraan> getKendaraanDetail(@PathVariable Long kendaraanId) {
        Optional<MstKendaraan> kendaraanOpt = kendaraanService.getKendaraanById(kendaraanId);
        return kendaraanOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PutMapping(value = "/edit/{kendaraanId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editKendaraan(@PathVariable Long kendaraanId, @RequestBody MstKendaraanDto mstKendaraanDto) {
        return kendaraanService.updateKendaraan(kendaraanId, mstKendaraanDto);
    }

    @DeleteMapping("/delete/{kendaraanId}")
    public ResponseEntity<?> deleteKendaraan(@PathVariable Long kendaraanId) {
        kendaraanService.deleteKendaraan(kendaraanId);
        return ResponseEntity.noContent().build();
    }
}

