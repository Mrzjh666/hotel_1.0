package hotel.com.jd.service.Impl;

import hotel.com.jd.domain.Orders;
import hotel.com.jd.mapper.OrderMapper;
import hotel.com.jd.service.OrderService;
import hotel.com.jd.util.PageParms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public void newOrder(Orders order) {
        orderMapper.insert(order);
    }

    @Override
    public Orders findOrderById(int order_id) {
        return orderMapper.findOrderById(order_id);
    }

    @Override
    public void delete(int order_id) {
        orderMapper.delete(order_id);
    }

    @Override
    public ArrayList<Orders> findOrderByType(String order_type, int currentPage, PageParms parms) {
        if(order_type == null)
            order_type="";
        System.out.println(order_type+"service");
        parms.setAllCount(orderMapper.getRecordNum(order_type));
        System.out.println("AllCount"+orderMapper.getRecordNum(order_type));
        parms.setAllPageCount((parms.getAllCount()+parms.getPageSize()-1)/parms.getPageSize());
        if(parms.getAllPageCount()>0 && currentPage> parms.getAllPageCount())
            parms.setCurrentPage(parms.getAllPageCount());
        else
        if(currentPage <=1)
            parms.setCurrentPage(1);
        else
            parms.setCurrentPage(currentPage);
        int start_place = (parms.getCurrentPage()-1)*parms.getPageSize();
        int size = parms.getPageSize();
        ArrayList<Orders> list = orderMapper.findRoomByType(order_type,start_place,size);

        return list;
    }
}
