package com.sibftie.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by solo on 09/05/2017.
 */
@Entity
@Table(name = "t_prodi")
public class Prodi
{
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String kodeProdi;

    @Column
    private String namaProdi;

    @OneToMany(mappedBy = "prodi")
    private Set<Kelas> kelass;


    public Prodi() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Prodi(String kodeProdi, String namaProdi) {
        this.kodeProdi = kodeProdi;
        this.namaProdi = namaProdi;
    }

    public String getKodeProdi() {
        return kodeProdi;
    }

    public void setKodeProdi(String kodeProdi) {
        this.kodeProdi = kodeProdi;
    }

    public String getNamaProdi() {
        return namaProdi;
    }

    public void setNamaProdi(String namaProdi) {
        this.namaProdi = namaProdi;
    }

    public Set<Kelas> getKelass() {
        return kelass;
    }

    public void setKelass(Set<Kelas> kelass) {
        this.kelass = kelass;
    }
}
