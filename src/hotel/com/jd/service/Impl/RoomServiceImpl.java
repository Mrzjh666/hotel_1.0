package hotel.com.jd.service.Impl;
import hotel.com.jd.domain.Room;
import hotel.com.jd.mapper.RoomMapper;
import hotel.com.jd.service.RoomService;
import hotel.com.jd.util.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("roomService")
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Transactional(readOnly = true)
    @Override
    public Room findRoomByNo(String room_no) {
        return roomMapper.findRoomByNo(room_no);
    }
    @Transactional(readOnly = true)
    @Override
    public Room findRoomById(int  room_id) {
        return roomMapper.findRoomById(room_id);
    }
    @Transactional(readOnly = true)
    @Override
    public ArrayList<Room> findRoomByType(String room_type, int currentPage, PageParms parms) {
        if(room_type == null)
            room_type="";
        parms.setAllCount(roomMapper.getRecordNum(room_type));
        parms.setAllPageCount((parms.getAllCount()+parms.getPageSize()-1)/parms.getPageSize());
        if(parms.getAllPageCount()>0 && currentPage> parms.getAllPageCount())
            parms.setCurrentPage(parms.getAllPageCount());
        else
            if(currentPage < 1)
                parms.setCurrentPage(1);
            else
                parms.setCurrentPage(currentPage);
        int start_place = (parms.getAllPageCount()-1)*parms.getPageSize();
        int size = parms.getPageSize();
        ArrayList<Room> list = roomMapper.findRoomByType(room_type,start_place,size);

        return list;
    }
    @Transactional(readOnly = true)
    @Override
    public ArrayList<Room> findRoomByTypeAndFlag(String room_type, String room_flag, int currentPage, PageParms parms) {
        if(room_type == null)
            room_type="";
        if(room_flag == null)
            room_flag="";
        parms.setAllCount(roomMapper.getRecordNum(room_type));
        parms.setAllPageCount((parms.getAllCount()+parms.getPageSize()-1)/parms.getPageSize());
        if(parms.getAllPageCount()>0 && currentPage> parms.getAllPageCount())
            parms.setCurrentPage(parms.getAllPageCount());
        else
        if(currentPage < 1)
            parms.setCurrentPage(1);
        else
            parms.setCurrentPage(currentPage);
        int start_place = (parms.getAllPageCount()-1)*parms.getPageSize();
        int size = parms.getPageSize();
        ArrayList<Room> list = roomMapper.findRoomByTypeAndFlag(room_type,room_flag,start_place,size);
        return list;
    }
    @Transactional(readOnly=false)
    @Override
    public void insert(Room room) {
        roomMapper.insert(room);
    }
    @Transactional(readOnly=false)
    @Override
    public void update(Room room) {
        roomMapper.update(room);
    }
    @Transactional(readOnly=false)
    @Override
    public void delete(int roomId) {
        roomMapper.delete(roomId);
    }
}
