package com.sibftie.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "t_mahasiswa")
public class Mahasiswa
{
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 8, max = 9, message = "Masukkan nim yang valid")
    @Column(unique = true)
    private String nim;

    @Column(nullable = false)
    private String namaLengkap;

    @Column
    private String jnsKelamin;

    @Column
    private String alamat;

    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date tglLahir;

    @Column
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public Mahasiswa(String nim, String namaLengkap, String jnsKelamin, String alamat, Date tglLahir, Kelas kelas, Akun akun, Set<Proposal> proposals, Set<Aspirasi> aspirasis, Set<Pengumuman> pengumumans, Set<Dokumen> dokumens, Set<Diskusi> diskusis, Set<Komentar> komentars, Set<MahasiswaJabatan> mahasiswaJabatans) {

        this.nim = nim;
        this.namaLengkap = namaLengkap;
        this.jnsKelamin = jnsKelamin;
        this.alamat = alamat;
        this.tglLahir = tglLahir;
        this.kelas = kelas;
        this.akun = akun;
        this.proposals = proposals;
        this.aspirasis = aspirasis;
        this.pengumumans = pengumumans;
        this.dokumens = dokumens;
        this.diskusis = diskusis;
        this.komentars = komentars;
        this.mahasiswaJabatans = mahasiswaJabatans;
    }


    @ManyToOne
    @JoinColumn(name = "t_kelas_id")
    private Kelas kelas;

    @OneToOne(mappedBy = "mahasiswa",cascade = CascadeType.ALL)
    private Akun akun;

    @OneToMany(mappedBy = "mahasiswa")
    private Set<Proposal> proposals;

    @OneToMany(mappedBy = "mahasiswa")
    private Set<Aspirasi> aspirasis;

    @OneToMany(mappedBy = "mahasiswa")
    private Set<Pengumuman> pengumumans;

    @OneToMany(mappedBy = "mahasiswa")
    private Set<Dokumen> dokumens;

    @OneToMany(mappedBy = "mahasiswa")
    private Set<Diskusi> diskusis;

    @OneToMany(mappedBy = "mahasiswa")
    private Set<Komentar> komentars;

    @OneToMany(mappedBy = "mahasiswa")
    private Set<MahasiswaJabatan> mahasiswaJabatans;

    public Set<Proposal> getProposals() {
        return proposals;
    }

    public void setProposals(Set<Proposal> proposals) {
        this.proposals = proposals;
    }

    public Set<Aspirasi> getAspirasis() {
        return aspirasis;
    }

    public void setAspirasis(Set<Aspirasi> aspirasis) {
        this.aspirasis = aspirasis;
    }

    public Set<Pengumuman> getPengumumans() {
        return pengumumans;
    }

    public void setPengumumans(Set<Pengumuman> pengumumans) {
        this.pengumumans = pengumumans;
    }

    public Set<Dokumen> getDokumens() {
        return dokumens;
    }

    public void setDokumens(Set<Dokumen> dokumens) {
        this.dokumens = dokumens;
    }

    public Set<Diskusi> getDiskusis() {
        return diskusis;
    }

    public void setDiskusis(Set<Diskusi> diskusis) {
        this.diskusis = diskusis;
    }

    public Set<Komentar> getKomentars() {
        return komentars;
    }

    public void setKomentars(Set<Komentar> komentars) {
        this.komentars = komentars;
    }

    public Set<MahasiswaJabatan> getMahasiswaJabatans() {
        return mahasiswaJabatans;
    }

    public void setMahasiswaJabatans(Set<MahasiswaJabatan> mahasiswaJabatans) {
        this.mahasiswaJabatans = mahasiswaJabatans;
    }

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, String namaLengkap, String jnsKelamin, String alamat, Date tglLahir) {
        this.nim = nim;
        this.namaLengkap = namaLengkap;
        this.jnsKelamin = jnsKelamin;
        this.alamat = alamat;
        this.tglLahir = tglLahir;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getJnsKelamin() {
        return jnsKelamin;
    }

    public void setJnsKelamin(String jnsKelamin) {
        this.jnsKelamin = jnsKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    public Akun getAkun() {
        return akun;
    }

    public void setAkun(Akun akun) {
        this.akun = akun;
    }


}
