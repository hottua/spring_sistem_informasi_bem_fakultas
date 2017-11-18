package com.sibftie.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by solo on 01/05/2017.
 */
@Entity
@Table(name = "t_kategori_pengumuman")
public class KategoriPengumuman
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (nullable = false)
    private String namaKategori;

    @OneToMany(mappedBy = "kategoriPengumuman")
    private Set<Pengumuman> pengumumans;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    public Set<Pengumuman> getPengumumans() {
        return pengumumans;
    }

    public void setPengumumans(Set<Pengumuman> pengumumans) {
        this.pengumumans = pengumumans;
    }
}
