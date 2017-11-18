package com.sibftie.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by solo on 01/05/2017.
 */
@Entity
@Table(name = "t_kategori_diskusi")
public class KategoriDiskusi
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String namaKategori;

    @Column
    private String deskripsiKategori;

    @OneToMany(mappedBy = "kategoriDiskusi")
    private List<Diskusi> diskusi;


}
