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
        List<MobileDeviceDTO> devices = new ArrayList<>();
        List<MobileDevice> deviceList = mobileDeviceRepository.findAll();
        for (MobileDevice d : deviceList) {
            devices.add(mobileDeviceMapper.toDto(d));
        }
        return devices;

        //second implementation

//        List <MobileDeviceDTO> devices = new ArrayList<>();
//        devices = mobileDeviceMapper.toDto(mobileDeviceRepository.findAll());
//        return devices;
    }

    public void addNewDevice(MobileDevice mobileDevice) {
        // second implementation without validating  brand,model&osversion
//        Optional<MobileDevice> mobileDeviceOptional =  mobileDeviceRepository.findMobileDeviceByModel(mobileDevice.getModel());
//        if(mobileDeviceOptional.isPresent()){
//            throw new IllegalStateException("model already exists");
//        }
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


        public void deleteDevice(Long mobileDeviceId) {
        if (!mobileDeviceRepository.existsById(mobileDeviceId)) {
            System.out.println("device with id " + mobileDeviceId + " doesn't exists");
        }
        else
            mobileDeviceRepository.deleteById(mobileDeviceId);
    }

    public List<MobileDeviceDTO> search(String brand ,String model, String osVersion, os os,Long id){

        List<MobileDeviceDTO> devices = mobileDeviceMapper.toDto(mobileDeviceRepository.findAll());
        if(brand != null){
            devices.retainAll(mobileDeviceMapper.toDto(mobileDeviceRepository.findByBrand(brand)));
        }
        if(model != null){
            devices.retainAll(mobileDeviceMapper.toDto(mobileDeviceRepository.findByModel(model)));
        }
        if(osVersion != null){
            devices.retainAll(mobileDeviceMapper.toDto(mobileDeviceRepository.findByOsVersion(osVersion)));
        }
        if(os !=null){
            devices.retainAll(mobileDeviceMapper.toDto(mobileDeviceRepository.findByOs(os)));
        }
        if(id !=null){
            devices.retainAll(mobileDeviceMapper.toDto(mobileDeviceRepository.findByid(id)));
        }
        return devices;
    }

    public void save(List<MobileDevice> devices) {
        mobileDeviceRepository.saveAll(devices);
    }
}




