package com.sibftie.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by solo on 01/05/2017.
 */
@Entity
@Table(name = "t_pengumuman")
public class Pengumuman
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String judul;

    @Column
    private String isiPengumuman;

    @Column
    private String pathFile;

    @Column
    private Date tglDibuat;

    @Column
    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name = "t_kategori_pengumuman_id")
    private KategoriPengumuman kategoriPengumuman;

    @ManyToOne
    @JoinColumn(name = "t_mahasiswa_id")
    private Mahasiswa mahasiswa;

    @ManyToOne
    @JoinColumn(name = "t_privasi_id")
    private Privasi privasi;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsiPengumuman() {
        return isiPengumuman;
    }

    public void setIsiPengumuman(String isiPengumuman) {
        this.isiPengumuman = isiPengumuman;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public Date getTglDibuat() {
        return tglDibuat;
    }

    public void setTglDibuat(Date tglDibuat) {
        this.tglDibuat = tglDibuat;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public KategoriPengumuman getKategoriPengumuman() {
        return kategoriPengumuman;
    }

    public void setKategoriPengumuman(KategoriPengumuman kategoriPengumuman) {
        this.kategoriPengumuman = kategoriPengumuman;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public Privasi getPrivasi() {
        return privasi;
    }

    public void setPrivasi(Privasi privasi) {
        this.privasi = privasi;
    }
}
