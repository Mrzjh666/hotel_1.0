package hotel.com.jd.service;

import hotel.com.jd.domain.Equipment;
import hotel.com.jd.util.PageParms;

import java.util.ArrayList;

public interface EquipmentService {
    Equipment findEquipmentById(int equ_id);
    ArrayList<Equipment> findEquipmentByTpye(String equ_type, int currentPage,PageParms parms);
    void insert(Equipment equipment);
    void update(Equipment equipment);
    void delete(int equId);
    
}
