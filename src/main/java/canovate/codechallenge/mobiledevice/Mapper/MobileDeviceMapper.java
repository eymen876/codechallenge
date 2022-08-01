package canovate.codechallenge.mobiledevice.Mapper;

import canovate.codechallenge.mobiledevice.Model.MobileDevice;
import canovate.codechallenge.mobiledevice.ModelDTO.MobileDeviceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {})
public interface MobileDeviceMapper extends BaseMapper<MobileDeviceDTO, MobileDevice> {

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
