package poly.datn.service;

import poly.datn.entity.LienHeTK;
import poly.datn.entity.ThongKeDT;

public interface LienHeTKService {
    Integer countLienHeTK(String monthYear);

    boolean checkLH(LienHeTK lh);
}
