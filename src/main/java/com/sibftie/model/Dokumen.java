package com.sibftie.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by solo on 01/05/2017.
 */
@Entity
@Table(name = "t_dokumen")
public class Dokumen
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotEmpty
    private String jdlDokumen;

    @Column
    private String deskripsi;

    @Column
    private int jmlSpam;

    @Column
    private Date tglDibuat;

    @Column
    private String path;

    @Column
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Transient
    private MultipartFile fileDokumen;

    public MultipartFile getFileDokumen() {
        return fileDokumen;
    }

    public void setFileDokumen(MultipartFile fileDokumen) {
        this.fileDokumen = fileDokumen;
    }

    @ManyToOne
    @JoinColumn(name = "t_mahasiswa_id")
    private Mahasiswa mahasiswa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJdlDokumen() {
        return jdlDokumen;
    }

    public void setJdlDokumen(String jdlDokumen) {
        this.jdlDokumen = jdlDokumen;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getJmlSpam() {
        return jmlSpam;
    }

    public void setJmlSpam(int jmlSpam) {
        this.jmlSpam = jmlSpam;
    }

    public Date getTglDibuat() {
        return tglDibuat;
    }

    public void setTglDibuat(Date tglDibuat) {
        this.tglDibuat = tglDibuat;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
}
