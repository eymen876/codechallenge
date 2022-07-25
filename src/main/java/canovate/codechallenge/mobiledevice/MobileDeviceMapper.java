package canovate.codechallenge.mobiledevice;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = {})
public interface MobileDeviceMapper extends BaseMapper<MobileDeviceDTO,MobileDevice>{

    @Mapping(source = "id", target = "id")
    @Mapping(source = "model", target = "model")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "os", target = "os")
    @Mapping(source = "osVersion", target = "osVersion")
    MobileDeviceDTO toDto (MobileDevice mobileDevice);


//    List<MobileDeviceDTO> modelsToDTOs(List<MobileDevice> mobileDevices);
//
//    MobileDevice DTOToModel (MobileDeviceDTO mobiledeviceDTO);
}
