package com.sibftie.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by solo on 01/05/2017.
 */

@Entity
@Table(name = "t_pengeluaran")
public class Pengeluaran
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private BigDecimal jmlPengeluaran;

    @Column
    private Date tglPengeluaran;

    @Column
    private Date periode;

    @Column
    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name = "t_event_id")
    private Event event;

    @OneToMany(mappedBy = "pengeluaran")
    private Set<Transaksi> transaksis;
//
//    @ManyToMany(mappedBy = "pengeluarans")
//    private Set<UangKas> uangKass;


}
