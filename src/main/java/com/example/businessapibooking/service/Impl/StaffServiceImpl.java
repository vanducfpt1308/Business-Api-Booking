package com.example.businessapibooking.service.Impl;

import com.example.businessapibooking.entity.Staff;
import com.example.businessapibooking.repository.StaffRepository;
import com.example.businessapibooking.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService {
    public static final Logger LOGGER = LoggerFactory.getLogger(StaffServiceImpl.class);
    @Autowired
    StaffRepository staffRepository;

    @Override
    public List<Staff> findByRole(Map map) {
        List<Staff> lst = new ArrayList<>();
        if (map != null) {
            String role = (String) map.get("ROLE");
            lst = staffRepository.findByRole(role);
        }
        return lst;
    }

    @Override
    public List<Staff> findByUserRole(Integer role) {
        return staffRepository.findByUserRole(role);
    }

    @Override
    public Staff findById(Integer id) {
        Staff staff = new Staff();
        try {
            staff = staffRepository.findById(id).get();
        } catch (Exception e) {
            LOGGER.info("error :" + e);
        }
        return staff;
    }

    @Override
    public List<Staff> findAll(List<Integer> ids) {
        return staffRepository.findAllById(ids);
    }

    @Override
    public Staff save(Staff obj) {
        return staffRepository.save(obj);
    }

    @Override
    public List<Staff> saveAll(List<Staff> lst) throws Exception {
        return staffRepository.saveAll(lst);
    }

    @Override
    public void delete(Integer key) {
        staffRepository.deleteById(key);
    }

    @Override
    public void deleteAll(List<Staff> lst) {
        staffRepository.deleteAll(lst);
    }

    @Override
    public boolean existsById(Integer key) {
        return staffRepository.existsById(key);
    }

    @Override
    public List<Staff> queryAllAndSort(List<OrderBy> orderBys) {
        return null;
    }

    @Override
    public List<Staff> findByExample(Staff e) {
        return null;
    }

    @Override
    public List<Staff> findLimit(int numberSkip, int limit) {
        return null;
    }

    @Override
    public Page<Staff> findPage(int numberSkip, int limit, List<OrderBy> orderBys) {
        return null;
    }

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }
}
