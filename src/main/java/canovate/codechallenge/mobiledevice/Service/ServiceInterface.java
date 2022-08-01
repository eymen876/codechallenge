package canovate.codechallenge.mobiledevice.Service;

import canovate.codechallenge.mobiledevice.Enums.os;
import canovate.codechallenge.mobiledevice.Model.MobileDevice;
import canovate.codechallenge.mobiledevice.ModelDTO.MobileDeviceDTO;

import java.util.List;

public interface ServiceInterface {
    public List<MobileDeviceDTO> getDevices();
    public void addNewDevice(MobileDevice mobileDevice);
    public void deleteDevice(Long mobileDeviceId);
    List<MobileDeviceDTO> search(Long id,String model, String brand, os os, String osVersion);
}
