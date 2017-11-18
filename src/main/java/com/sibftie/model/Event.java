package com.sibftie.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by solo on 01/05/2017.
 */
@Entity
@Table(name = "t_event")
public class Event
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String namaKegiatan;

    @Column
    private String deskripsi;

    @OneToMany(mappedBy = "event")
    private Set<Pengeluaran> pengeluarans;

    public Event(String namaKegiatan, String deskripsi) {
        this.namaKegiatan = namaKegiatan;
        this.deskripsi = deskripsi;
    }

    public Event() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Set<Pengeluaran> getPengeluarans() {
        return pengeluarans;
    }

    public void setPengeluarans(Set<Pengeluaran> pengeluarans) {
        this.pengeluarans = pengeluarans;
    }
}
