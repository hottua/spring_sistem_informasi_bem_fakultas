package com.sibftie.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by solo on 01/05/2017.
 */
@Entity
@Table(name = "t_mahasiswa_jabatan")
public class MahasiswaJabatan
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mahasiswa_jabatan_id")
    private long id;


    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date start;

    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date end;

    @Column
    private String periodeJabatan;

    @ManyToOne
    @JoinColumn(name = "t_mahasiswa_id")
    private Mahasiswa mahasiswa;

    @ManyToOne
    @JoinColumn(name = "t_jabatan_id")
    private Jabatan jabatan;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getPeriodeJabatan() {
        return periodeJabatan;
    }

    public void setPeriodeJabatan(String periodeJabatan) {
        this.periodeJabatan = periodeJabatan;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }
}
