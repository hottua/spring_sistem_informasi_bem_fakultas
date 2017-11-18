package com.sibftie.model;


import com.sibftie.validator.EmailExist;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by solo on 01/05/2017.
 */
@Entity
@Table(name = "t_akun")
public class Akun
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @EmailExist
    @Email(message = "Masukkan email yang valid")
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Email tidak boleh kosong")
    private String email;

    @Column
    private String password;

    @OneToOne
    @JoinColumn(name = "t_mahasiswa_id")
    private Mahasiswa mahasiswa;

    public Akun() {
    }

    public Akun(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
}
