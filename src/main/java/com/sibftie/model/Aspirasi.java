package com.sibftie.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by solo on 01/05/2017.
 */
@Entity
@Table(name = "t_aspirasi")
public class Aspirasi
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotNull(message = "Judul Aspirasi tidak boleh kosong")
    private String judulAspirasi;

    @Column(nullable = false)
    @NotNull(message = "Aspirasi tidak boleh kosong")
    private String isiAspirasi;

    @Column
    private Date tgl_dibuat;

    @Column
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "t_mahasiswa_id")
    private Mahasiswa mahasiswa;

    public Aspirasi() {
    }

    public Aspirasi(String judulAspirasi, String isiAspirasi, Date tgl_dibuat, Mahasiswa mahasiswa) {
        this.judulAspirasi = judulAspirasi;
        this.isiAspirasi = isiAspirasi;
        this.tgl_dibuat = tgl_dibuat;
        this.mahasiswa = mahasiswa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJudulAspirasi() {
        return judulAspirasi;
    }

    public void setJudulAspirasi(String judulAspirasi) {
        this.judulAspirasi = judulAspirasi;
    }

    public String getIsiAspirasi() {
        return isiAspirasi;
    }

    public void setIsiAspirasi(String isiAspirasi) {
        this.isiAspirasi = isiAspirasi;
    }

    public Date getTgl_dibuat() {
        return tgl_dibuat;
    }

    public void setTgl_dibuat(Date tgl_dibuat) {
        this.tgl_dibuat = tgl_dibuat;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }


}
