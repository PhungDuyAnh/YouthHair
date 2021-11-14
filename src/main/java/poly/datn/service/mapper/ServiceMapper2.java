package poly.datn.service.mapper;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import poly.datn.entity.Services;
import poly.datn.service.dto.ServiceDTO;

@Mapper(componentModel = "spring",uses = {})
public interface ServiceMapper2 extends EntityMapper<ServiceDTO, Services>{}
