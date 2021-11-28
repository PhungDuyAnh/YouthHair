package poly.datn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import poly.datn.entity.Services;
import poly.datn.service.dto.ServiceDTO;

import java.util.List;
import java.util.Optional;

public interface IServiceService {

    List<Services> findAll();

    Optional<Services> findById(Integer id);
    Services getById (Integer id);

    Page<Services> findAll(Pageable pageable);
    boolean checkService (Services services);
    ServiceDTO save(ServiceDTO serviceDTO);

    Services update(Services services);

    List<Services> seachServiceByName(String serviceName);


}
