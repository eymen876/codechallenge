package canovate.codechallenge.mobiledevice.Service;

import canovate.codechallenge.mobiledevice.Enums.os;
import canovate.codechallenge.mobiledevice.Entity.MobileDevice;
import canovate.codechallenge.mobiledevice.Model.MobileDeviceDTO;

import java.util.List;

public interface ServiceInterface {
    public List<MobileDeviceDTO> getDevices();
    public void addNewDevice(MobileDeviceDTO mobileDeviceDTO);
    public void deleteDevice(Long id);
    List<MobileDeviceDTO> search(Long id,String model, String brand, os os, String osVersion);
    public String save(List<MobileDeviceDTO> devices);
}
