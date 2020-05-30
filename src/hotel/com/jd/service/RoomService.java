package hotel.com.jd.service;

import hotel.com.jd.domain.Room;
import hotel.com.jd.util.PageParms;

import java.util.ArrayList;

public interface RoomService {
    Room findRoomByNo(String room_no);
    Room findRoomById(int room_id);
    ArrayList<Room> findRoomByType(String room_type,
                                   int currentPage,PageParms parms);
    ArrayList<Room> findRoomByTypeAndFlag(String room_type,String room_flag,
                                          int currentPage,PageParms parms);
    void insert(Room room);
    void update(Room room);
    void delete(int roomId);
}
