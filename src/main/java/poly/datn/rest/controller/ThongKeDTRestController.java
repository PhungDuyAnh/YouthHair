package poly.datn.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poly.datn.service.ThongKeService;

@RestController
@RequestMapping("/rest")
public class ThongKeDTRestController {
    @Autowired
    ThongKeService thongKeService;

    @GetMapping("/thongKeDT")
    public float thongKeDT(String monthYear) {
        return thongKeService.getDTByMonth(monthYear);
    }
}
