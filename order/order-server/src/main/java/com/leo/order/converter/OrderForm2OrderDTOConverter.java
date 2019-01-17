package com.leo.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.leo.order.dataobject.OrderDetail;
import com.leo.order.dto.OrderDTO;
import com.leo.order.enums.ResultEnum;
import com.leo.order.exception.OrderException;
import com.leo.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 廖师兄
 * 2017-12-10 17:38
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductQuantity(2);
        orderDetail.setOrderId("12");
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
