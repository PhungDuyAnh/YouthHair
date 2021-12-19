package poly.datn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.datn.dao.LienHeTKDAO;
import poly.datn.entity.LienHeTK;
import poly.datn.entity.ThongKeDT;
import poly.datn.service.LienHeTKService;

@Service
public class LienHeTKServiceimlp implements LienHeTKService {
    @Autowired
    LienHeTKDAO lienHeTKDAO;

    @Override
    public Integer countLienHeTK(String monthYear) {
        if(monthYear.equals("") || monthYear==null){
            System.out.println("Nếu không chọn tháng thì sẽ lấy tháng hiện tại");
        }
        Integer countLH=0;

        LienHeTK lienHeTK=lienHeTKDAO.getLienHeTK(monthYear);
        if (checkLH(lienHeTK)){
            countLH=lienHeTKDAO.countLienHeTK(monthYear);
        }
        return countLH;
    }

    @Override
    public boolean checkLH(LienHeTK lh) {
        return lh != null ? true :false;
    }
}
