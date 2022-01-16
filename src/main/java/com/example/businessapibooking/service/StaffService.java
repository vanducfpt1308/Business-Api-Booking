package com.example.businessapibooking.service;

import com.example.businessapibooking.entity.Role;
import com.example.businessapibooking.entity.Staff;
import org.springframework.data.domain.Page;

import javax.persistence.OrderBy;
import java.util.List;
import java.util.Map;


public interface StaffService {
    Staff findById(Integer id);

    List<Staff> findAll();

    List<Staff> findAll(List<Integer> ids);

    List<Staff> findByUserRole(Integer role);

    List<Staff> findByNameAndRole(Map map);

    List<Staff> findByRole(Map map);

    Staff save(Staff obj);

    List<Staff> saveAll(List<Staff> lst) throws Exception;

    void delete(Integer key);

    void deleteAll(List<Staff> lst);

    boolean existsById(Integer key);

    List<Staff> queryAllAndSort(List<OrderBy> orderBys);

    List<Staff> findByExample(Staff e);

    List<Staff> findLimit(int numberSkip, int limit);

    Page<Staff> findPage(int numberSkip, int limit, List<OrderBy> orderBys);

}
