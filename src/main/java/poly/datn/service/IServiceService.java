package poly.datn.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import poly.datn.entity.Services;
import poly.datn.service.dto.ServiceDTO;

import java.util.List;
import java.util.Optional;

public interface IServiceService {

    List<Services> findAll();

    Services getById(Integer id);

    Page<Services> findAll(Pageable pageable);

    Services save(ServiceDTO serviceDTO);

    Services update(Services services);


}
