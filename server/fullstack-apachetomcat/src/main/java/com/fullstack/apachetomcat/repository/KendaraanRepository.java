package com.fullstack.apachetomcat.repository;

import com.fullstack.apachetomcat.model.MstKendaraan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KendaraanRepository extends JpaRepository<MstKendaraan, Long> {
    @Query(value = "select a.* from kendaraan a where kendaraan_id = :kendaraanId", nativeQuery = true)
    Optional<MstKendaraan> findByKendaraanId(@Param("kendaraanId") Long kendaraanId);

    @Query(value = "select " +
                   "a.kendaraan_id, " +
                   "a.no_registrasi, " +
                   "a.nama_pemilik, " +
                   "a.alamat, " +
                   "a.merk_kendaraan, " +
                   "a.tahun_pembuatan, " +
                   "a.kapasitas_silinder, " +
                   "a.warna_kendaraan, " +
                   "a.bahan_bakar, " +
                   "a.created_by, " +
                   "a.updated_by, " +
                   "a.created_datetime, " +
                   "a.updated_datetime " +
                   "from kendaraan a order by a.kendaraan_id asc", nativeQuery = true)
    List<MstKendaraan> findAll();

    @Query(value = "SELECT " +
            "      a.kendaraan_id, " +
            "      a.no_registrasi, " +
            "      a.nama_pemilik, " +
            "      a.alamat, " +
            "      a.merk_kendaraan, " +
            "      a.tahun_pembuatan, " +
            "      a.kapasitas_silinder, " +
            "      a.warna_kendaraan, " +
            "      a.bahan_bakar, " +
            "      a.created_by, " +
            "      a.updated_by, " +
            "      a.created_datetime, " +
            "      a.updated_datetime " +
            "FROM kendaraan a " +
            "WHERE " +
            "      a.no_registrasi ILIKE CONCAT('%', :noRegistrasi, '%') " +
            "AND   " +
            "      a.nama_pemilik ILIKE CONCAT('%', :namaPemilik, '%') " +
            "ORDER BY " +
            "      a.kendaraan_id ASC", nativeQuery = true)
    List<MstKendaraan> findByLikeCriteria(@Param("noRegistrasi") String noRegistrasi,
                                      @Param("namaPemilik") String namaPemilik);
}
