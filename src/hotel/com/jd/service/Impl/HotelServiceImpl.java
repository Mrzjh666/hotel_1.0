package hotel.com.jd.service.Impl;

import hotel.com.jd.domain.Hotel;
import hotel.com.jd.mapper.HotelMapper;
import hotel.com.jd.service.HotelService;
import hotel.com.jd.util.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("hotelService")
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelMapper hotelMapper;

    @Transactional(readOnly=false)
    @Override
    public void insert(Hotel hotel) {
        hotelMapper.insert(hotel);
    }
    @Transactional(readOnly=false)
    @Override
    public void update(Hotel hotel) {
        hotelMapper.update(hotel);
    }
    @Transactional(readOnly=false)
    @Override
    public void delete(int hotel_id) {
        hotelMapper.delete(hotel_id);
    }

    @Transactional(readOnly = true)
    @Override
    public Hotel findHotelById(int hotel_id) {
       return hotelMapper.findHotelById(hotel_id);
    }

    /**
     * @Controller注意try catch 确认是否成功
     * @param hotel_id
     * @param money
     * @return
     */
    @Transactional(readOnly = false)
    @Override
    public void setHotelMealincome(int hotel_id,double money) {
        hotelMapper.setHotelMealincome(hotel_id,money);
    }
    @Transactional(readOnly = false)
    @Override
    public void setHotelRoomincome(int hotel_id,double money) {
       hotelMapper.setHotelRoomincome(hotel_id,money);
    }
    @Transactional(readOnly = true)
    @Override
    public ArrayList<Hotel> findHotelAll(int currentPage, PageParms parms) {
        parms.setAllCount(hotelMapper.getRecordNum());
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
        ArrayList<Hotel> list = hotelMapper.findHotelAll(start_place,size);
        return list;
    }
}
