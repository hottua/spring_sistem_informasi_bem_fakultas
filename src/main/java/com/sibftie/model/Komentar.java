package com.sibftie.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by solo on 01/05/2017.
 */
@Entity
@Table(name = "t_komentar")
public class Komentar
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String isiKomentar;

    @Column
    private int rating;

    @Column
    private String filePath;

    @Column
    private Date tglDibuat;

    @ManyToOne
    @JoinColumn(name = "t_diskusi_id")
    private Diskusi diskusi;

    @ManyToOne
    @JoinColumn(name = "t_mahasiswa_id")
    private Mahasiswa mahasiswa;




}
