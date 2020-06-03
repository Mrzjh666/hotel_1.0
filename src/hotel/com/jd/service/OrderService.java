package hotel.com.jd.service;

import hotel.com.jd.domain.Orders;
import hotel.com.jd.util.PageParms;

import java.util.ArrayList;

public interface OrderService {
    void newOrder(Orders order);

    Orders findOrderById(int order_id);

    void delete(int order_id);

    ArrayList<Orders> findOrderByType(String order_type, int currentPage, PageParms parms);
}
