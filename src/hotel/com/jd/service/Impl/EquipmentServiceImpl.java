package hotel.com.jd.service.Impl;

/**
 * @Description
 * @Author cyb
 * @Date 2020/6/1 19:20
 */
import hotel.com.jd.domain.Equipment;
import hotel.com.jd.mapper.EquipmentMapper;
import hotel.com.jd.service.EquipmentService;
import hotel.com.jd.util.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Transactional(readOnly = true)
    @Override
    public Equipment findEquipmentById(int equ_id) { return equipmentMapper.findEquipmentById(equ_id);
    }

    @Transactional(readOnly = true)
    @Override
    public ArrayList<Equipment> findEquipmentByTpye(String equ_type, int currentPage, PageParms parms) {
        if(equ_type == null)
            equ_type="";
        System.out.println(equ_type+"service");
        parms.setAllCount(equipmentMapper.getRecordNum(equ_type));
        parms.setAllPageCount((parms.getAllCount()+parms.getPageSize()-1)/parms.getPageSize());
        if(parms.getAllPageCount()>0 && currentPage> parms.getAllPageCount())
            parms.setCurrentPage(parms.getAllPageCount());
        else
        if(currentPage <= 1)
            parms.setCurrentPage(1);
        else
            parms.setCurrentPage(currentPage);
        int start_place = (parms.getAllPageCount()-1)*parms.getPageSize();
        int size = parms.getPageSize();
        ArrayList<Equipment> list = equipmentMapper.findEquipmentByType(equ_type,start_place,size);

        return list;
    }
    @Transactional(readOnly=false)
    @Override
    public void insert(Equipment equipment) {
        equipmentMapper.insert(equipment);
    }
    @Transactional(readOnly=false)
    @Override
    public void update(Equipment equipment) {
        System.out.println(equipment.toString()+"service");
        equipmentMapper.update(equipment);
    }
    @Transactional(readOnly=false)
    @Override
    public void delete(int equId) {


        equipmentMapper.delete(equId);
    }
}

