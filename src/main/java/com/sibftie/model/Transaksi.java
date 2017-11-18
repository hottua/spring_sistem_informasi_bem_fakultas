package com.sibftie.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by solo on 01/05/2017.
 */
@Entity
@Table(name = "t_transaksi")
public class Transaksi
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private BigDecimal saldo;

    @Column
    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name = "t_pengeluaran_id")
    private Pengeluaran pengeluaran;

    @ManyToOne
    @JoinColumn(name = "t_uang_kas_id")
    private UangKas uangKas;


}
