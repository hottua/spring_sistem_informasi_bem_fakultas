package com.sibftie.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by solo on 30/05/2017.
 */
@Entity
@Table(name = "t_privasi")
public class Privasi
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String namaPrivasi;

    @OneToMany(mappedBy = "privasi")
    private Set<Pengumuman> pengumumens;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaPrivasi() {
        return namaPrivasi;
    }

    public void setNamaPrivasi(String namaPrivasi) {
        this.namaPrivasi = namaPrivasi;
    }

    public Set<Pengumuman> getPengumumens() {
        return pengumumens;
    }

    public void setPengumumens(Set<Pengumuman> pengumumens) {
        this.pengumumens = pengumumens;
    }
}
