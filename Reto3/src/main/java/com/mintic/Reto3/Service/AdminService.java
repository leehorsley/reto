package com.mintic.Reto3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.Reto3.Model.Admin;
import com.mintic.Reto3.Repository.AdminRepository;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> admin1 = adminRepository.getAdmin(admin.getIdAdmin());
            if (admin1.isEmpty()) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }

    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin>g= adminRepository.getAdmin(admin.getIdAdmin());
            if(!g.isEmpty()){
                if(admin.getEmail()!=null){                    
                    g.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    g.get().setPassword(admin.getPassword());
                }
                if(admin.getName()!=null){
                    g.get().setName(admin.getName());
                }
                return adminRepository.save(g.get());
            }
            
        }
        return admin;
    }

    /*public boolean delete(int id){
        boolean flag = false;
        Optional<Admin> g = adminRepository.getAdmin(id);
        if(g.isPresent()){
            adminRepository.delete(g.get());
        }
        return flag;
    }*/
    public boolean delete(int id){
        boolean flag = false;
        Optional<Admin> g = adminRepository.getAdmin(id);
        if(g.isPresent()){
            adminRepository.delete(g.get());
            flag = true;
        }
        return flag;
    }
}
