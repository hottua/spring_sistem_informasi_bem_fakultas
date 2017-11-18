package com.sibftie.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by solo on 30/04/2017.
 */
@Entity
@Table(name = "t_kelas")
public class Kelas implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String kodeKelas;

    @Column(nullable = false)
    private String deskripsi;

    @OneToMany(mappedBy = "kelas")
    private List<Mahasiswa> mahasiswas;

    @OneToMany(mappedBy = "kelas")
    private Set<UangKas> uangKass;

    @ManyToOne
    @JoinColumn(name = "t_prodi_id")
    private Prodi prodi;

    public Kelas(String kodeKelas, String deskripsi) {
        this.kodeKelas = kodeKelas;
        this.deskripsi = deskripsi;

    }

    public Kelas() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKodeKelas() {
        return kodeKelas;
    }

    public void setKodeKelas(String kodeKelas) {
        this.kodeKelas = kodeKelas;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    public void setMahasiswas(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

    public Set<UangKas> getUangKass() {
        return uangKass;
    }

    public void setUangKass(Set<UangKas> uangKass) {
        this.uangKass = uangKass;
    }

    public Prodi getProdi() {
        return prodi;
    }

    public void setProdi(Prodi prodi) {
        this.prodi = prodi;
    }
}
