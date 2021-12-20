package poly.datn.service;

import poly.datn.entity.ThongKeDT;

public interface ThongKeService {
    float getDTByMonth(String monthYear);

    boolean checkDT(ThongKeDT dt);

	float thongKeLichHenCPM(String monthYear);

	float thongKeLichHenAll(String monthYear);
}
