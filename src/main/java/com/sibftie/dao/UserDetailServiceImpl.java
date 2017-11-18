package com.sibftie.dao;

import com.sibftie.model.Akun;
import com.sibftie.model.Mahasiswa;
import com.sibftie.model.MahasiswaJabatan;
import com.sibftie.service.MahasiswaJabatanService;
import com.sibftie.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService
{
    @Autowired
    MahasiswaService mahasiswaService;

    @Autowired
    MahasiswaJabatanService mahasiswaJabatanService;

    @Autowired
    AkunServiceImpl akunService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Akun a = null;
        a = akunService.getAkunByEmail(email);
        MahasiswaJabatan mj = mahasiswaJabatanService.getMahasiswaJabatanByMahasiswa(a.getMahasiswa());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(mj.getJabatan().getNamaJabatan()));
        System.out.println("============================================");
        System.out.println("Nama\t:"+mj.getMahasiswa().getNamaLengkap());
        System.out.println("Email\t:"+mj.getMahasiswa().getAkun().getEmail());
        System.out.println("Jabatan\t:"+mj.getJabatan().getNamaJabatan());
        System.out.println("============================================");
        return new User(email, a.getPassword(), grantedAuthorities);

    }
}
