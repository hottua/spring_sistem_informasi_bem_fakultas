package com.sibftie.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by solo on 01/05/2017.
 */

@Entity
@Table(name = "t_uang_kas")
public class UangKas
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private BigDecimal jmlPenyetoran;

    @Column
    private  BigDecimal jmlPembayaran;

    @Column
    private BigDecimal jmlHutang;


    @Column
    private Date tglPenyetoran;

    @Column
    private Date timeStamp;

    @Column
    private Boolean Status;

    @ManyToOne
    @JoinColumn(name = "t_kelas_id")
    private Kelas kelas;

    @OneToMany(mappedBy = "uangKas")
    private Set<Transaksi> transaksis;

//    @ManyToMany
//    @JoinTable(name = "t_UangKas_Pengeluaran", joinColumns = @JoinColumn(name = "uang_kas_id", referencedColumnName = "id"),
//                                        inverseJoinColumns = @JoinColumn(name = "pengeluaran_id", referencedColumnName = "id"))
//    private Set<Pengeluaran> pengeluarans;



}
