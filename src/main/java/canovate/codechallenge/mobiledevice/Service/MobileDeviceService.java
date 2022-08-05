package canovate.codechallenge.mobiledevice.Service;


import canovate.codechallenge.mobiledevice.Enums.os;
import canovate.codechallenge.mobiledevice.Mapper.MobileDeviceMapper;
import canovate.codechallenge.mobiledevice.Entity.MobileDevice;
import canovate.codechallenge.mobiledevice.Model.MobileDeviceDTO;
import canovate.codechallenge.mobiledevice.Repository.MobileDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MobileDeviceService implements ServiceInterface{
    @Autowired
    private MobileDeviceRepository mobileDeviceRepository;

    @Autowired
    private MobileDeviceMapper mobileDeviceMapper;

    public List<MobileDeviceDTO> getDevices() {
        return mobileDeviceMapper.toDto(mobileDeviceRepository.findAll());
    }

    public void addNewDevice(MobileDeviceDTO mobileDeviceDTO) {
        List<MobileDeviceDTO> devices = new ArrayList<>();
        devices = mobileDeviceMapper.toDto(mobileDeviceRepository.findAll());
        boolean exists = false;

        for (MobileDeviceDTO d : devices) {
            if (mobileDeviceDTO.getBrand().equals(d.getBrand()) && mobileDeviceDTO.getModel().equals(d.getModel()) && mobileDeviceDTO.getOsVersion().equals(d.getOsVersion())) {
                exists=true;
            }
        }
        if(exists==false) {
            mobileDeviceRepository.save( mobileDeviceMapper.toEntity(mobileDeviceDTO));
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

    public String save(List<MobileDeviceDTO> devices) {
        mobileDeviceRepository.saveAll(mobileDeviceMapper.toEntity(devices));
        String result="";
        for (MobileDeviceDTO d : devices){
            result += "id "+d.getId()+" inserted\n";
        }
        return result;
    }

    public MobileDeviceDTO updateDevice(MobileDeviceDTO mobileDeviceDTO){
        Optional<MobileDevice> deviceOptional = mobileDeviceRepository.findById(mobileDeviceDTO.getId());
        if(deviceOptional.isPresent()){
            MobileDevice mobileDevice=deviceOptional.get();

            mobileDevice.setBrand(mobileDeviceDTO.getBrand());
            mobileDevice.setModel(mobileDeviceDTO.getModel());
            mobileDevice.setOs(mobileDeviceDTO.getOs());
            mobileDevice.setOsVersion(mobileDeviceDTO.getOsVersion());

            return mobileDeviceMapper.toDto(mobileDevice);
        }
        else {
            System.out.println("Device with id "+mobileDeviceDTO.getId()+ " not found");
            return null;
        }

    }
}




