package com.sibftie.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "t_jabatan")
public class Jabatan
{
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String namaJabatan;

    @Column
    private String deskripsi;

    @OneToMany(mappedBy = "jabatan")
    private Set<MahasiswaJabatan> mahasiswaJabatans;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaJabatan() {
        return namaJabatan;
    }

    public void setNamaJabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Set<MahasiswaJabatan> getMahasiswaJabatans() {
        return mahasiswaJabatans;
    }

    public void setMahasiswaJabatans(Set<MahasiswaJabatan> mahasiswaJabatans) {
        this.mahasiswaJabatans = mahasiswaJabatans;
    }
}
