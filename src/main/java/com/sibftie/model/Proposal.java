package com.sibftie.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by solo on 01/05/2017.
 */
@Entity
@Table(name = "t_proposal")
public class Proposal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String judulDokumen;

    @Column(nullable = false)
    private String pathDokument;

    @Column(nullable = false)
    private String status;

    @Column
    private Date tglDibuat;


    @Column
    private Date timeStamp;

    @Transient
    private MultipartFile fileProposal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_mahasiswa_id")
    private Mahasiswa mahasiswa;

    @Column
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJudulDokumen() {
        return judulDokumen;
    }

    public void setJudulDokumen(String judulDokumen) {
        this.judulDokumen = judulDokumen;
    }

    public String getPathDokument() {
        return pathDokument;
    }

    public void setPathDokument(String pathDokument) {
        this.pathDokument = pathDokument;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTglDibuat() {
        return tglDibuat;
    }

    public void setTglDibuat(Date tglDibuat) {
        this.tglDibuat = tglDibuat;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }



    public MultipartFile getFileProposal() {
        return fileProposal;
    }

    public void setFileProposal(MultipartFile fileProposal) {
        this.fileProposal = fileProposal;
    }



}
