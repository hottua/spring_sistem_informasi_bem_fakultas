package com.sibftie.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by solo on 01/05/2017.
 */
@Entity
@Table(name = "t_diskusi")
public class Diskusi
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String judulDiskusi;

    @Column
    private String isiDiskusi;

    @Column
    private Date tglDibuat;

    @Column
    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name = "t_kategori_id")
    private KategoriDiskusi kategoriDiskusi;

    @OneToMany(mappedBy = "diskusi")
    private Set<Komentar> komentars;

    @ManyToOne
    @JoinColumn(name = "t_mahasiswa_id")
    private Mahasiswa mahasiswa;




}
