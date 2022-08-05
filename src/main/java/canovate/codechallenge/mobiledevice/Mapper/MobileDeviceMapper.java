package canovate.codechallenge.mobiledevice.Mapper;

import canovate.codechallenge.mobiledevice.Entity.MobileDevice;
import canovate.codechallenge.mobiledevice.Model.MobileDeviceDTO;
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


}
