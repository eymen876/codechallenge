package canovate.codechallenge.mobiledevice.Service;


import canovate.codechallenge.mobiledevice.Enums.os;
import canovate.codechallenge.mobiledevice.Mapper.MobileDeviceMapper;
import canovate.codechallenge.mobiledevice.Repository.MobileDeviceRepository;
import canovate.codechallenge.mobiledevice.Model.MobileDevice;
import canovate.codechallenge.mobiledevice.ModelDTO.MobileDeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class MobileDeviceService implements ServiceInterface{
    @Autowired
    private MobileDeviceRepository mobileDeviceRepository;

    @Autowired
    private MobileDeviceMapper mobileDeviceMapper;

    public List<MobileDeviceDTO> getDevices() {
        return mobileDeviceMapper.toDto(mobileDeviceRepository.findAll());
    }

    public void addNewDevice(MobileDevice mobileDevice) {
        MobileDeviceDTO device = mobileDeviceMapper.toDto(mobileDevice);
        List<MobileDeviceDTO> devices = new ArrayList<>();
        devices = mobileDeviceMapper.toDto(mobileDeviceRepository.findAll());
        boolean exists = false;

        for (MobileDeviceDTO d : devices) {
            if (device.getBrand().equals(d.getBrand()) && device.getModel().equals(d.getModel()) && device.getOsVersion().equals(d.getOsVersion())) {
                exists=true;
            }
        }
        if(exists==false) {
            mobileDeviceRepository.save(mobileDevice);
        }
        else
            System.out.println("Device Already Exists");
    }

    public void deleteDevice(Long id) {
        if (!mobileDeviceRepository.existsById(id)) {
            System.out.println("device with id " + id + " doesn't exists");
        }
        else
            mobileDeviceRepository.deleteById(id);
    }

    public List<MobileDeviceDTO> search(Long id,String model ,String brand, os os,String osVersion){
        return mobileDeviceMapper.toDto(mobileDeviceRepository.search(id,model,brand,os,osVersion));
    }

    public void save(List<MobileDevice> devices) {
        mobileDeviceRepository.saveAll(devices);
    }
}




