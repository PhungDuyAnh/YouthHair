package poly.datn.service.impl;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.datn.dao.ServiceDAO;
import poly.datn.entity.Services;
import poly.datn.service.IServiceService;
import poly.datn.service.dto.ServiceDTO;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    ServiceDAO serviceDAO;


    @Override
    public List<Services> findAll() {
        return serviceDAO.findAll();
    }

    @Override
    public Services getById(Integer id) {
        return serviceDAO.getById(id);
    }


    @Override
    public Page<Services> findAll(Pageable pageable) {
        return serviceDAO.findAll(pageable);
    }

    @Override
    public Services save(ServiceDTO serviceDTO) {
        Time time=null;
        Services services = new Services();

        //get time
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(serviceDTO.getTime());
            time = new Time(date1.getTime());
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //set dữ liệu vào entity services
        services.setServiceName(serviceDTO.getServiceName());
        services.setTime(time);
        services.setImage(serviceDTO.getImage());
        services.setNote(serviceDTO.getNote());
        services.setStatus(serviceDTO.getStatus());
        services.setPrice(serviceDTO.getPrice());

        System.out.println("2:"+services.getTime() + "3 : "+ time);
        return serviceDAO.save(services);
    }

    @Override
    public Services update(Services services) {
        return null;
    }
}
