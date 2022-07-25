package canovate.codechallenge.mobiledevice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MobileDeviceService {
    @Autowired
    private MobileDeviceRepository mobileDeviceRepository;

    @Autowired
    private MobileDeviceMapper mobileDeviceMapper;

    public MobileDeviceDTO convertEntityToDTO(MobileDevice mobileDevice) {
        MobileDeviceDTO mobileDeviceDTO = new MobileDeviceDTO();
        mobileDeviceDTO.setId(mobileDevice.getId());
        mobileDeviceDTO.setModel(mobileDevice.getModel());
        mobileDeviceDTO.setBrand(mobileDevice.getBrand());
        mobileDeviceDTO.setOs(mobileDevice.getOs());
        mobileDeviceDTO.setOsVersion(mobileDevice.getOsVersion());
        return mobileDeviceDTO;
    }

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
        for (MobileDeviceDTO d : devices) {
            if (device.getBrand().equals(d.getBrand()) && device.getModel().equals(d.getModel()) && device.getOsVersion().equals(d.getOsVersion())) {
                throw new IllegalStateException("Device Already Exists");
            }
        }
        mobileDeviceRepository.save(mobileDevice);
    }

    public void deleteDevice(Long mobileDeviceId) {
        if (!mobileDeviceRepository.existsById(mobileDeviceId)) {
            throw new IllegalStateException("device with id " + mobileDeviceId + " doesn't exists");
        }
        mobileDeviceRepository.deleteById(mobileDeviceId);
    }

    public List <MobileDeviceDTO> getMobileDeviceByModel(String model) {
        return mobileDeviceMapper.toDto(mobileDeviceRepository.findByModel(model));
    }

    public MobileDeviceDTO getMobileDeviceById(long id) {
        if (!mobileDeviceRepository.existsById(id)) {
            throw new IllegalStateException("device with id " + id + " doesn't exists");
        }
        return mobileDeviceMapper.toDto(mobileDeviceRepository.findById(id).get());
    }

    public List<MobileDeviceDTO> getMobileDeviceByBrand(String brand) {

        //second implementation  -without using findbybrand
//        List<MobileDeviceDTO> devices = new ArrayList<>();
//        List<MobileDevice> deviceList = mobileDeviceRepository.findAll();
//        for (MobileDevice d : deviceList) {
//            if(Objects.equals(d.getBrand(),brand)){
//                devices.add(mobileDeviceMapper.toDto(d));
//            }
//        }
//        if(devices.size()==0){
//            throw new IllegalStateException("device with brand " + brand + " is not found");
//        }
//        return devices;


        List <MobileDeviceDTO> devices = mobileDeviceMapper.toDto(mobileDeviceRepository.findByBrand(brand));
        if(devices.size()==0){
            throw new IllegalStateException("device with brand " + brand + " is not found");
        }
        return devices;


    }



    public List <MobileDeviceDTO> getMobileDeviceByOs(os os){
        List<MobileDeviceDTO> devices = mobileDeviceMapper.toDto(mobileDeviceRepository.findByOs(os));
        if(devices.size()==0){
            throw new IllegalStateException("device with os "+ os+" is not found");
        }
        return mobileDeviceMapper.toDto(mobileDeviceRepository.findByOs(os));
    }

    public List<MobileDeviceDTO> getMobileDeviceByOsVersion(String osVersion){
        List<MobileDeviceDTO> devices =mobileDeviceMapper.toDto(mobileDeviceRepository.findByOsVersion(osVersion));
        if(devices.size()==0){
            throw new IllegalStateException("device with os version "+ osVersion+" is not found");
        }
        return devices;
    }

    public List<MobileDeviceDTO> search(String brand ,String model, String osVersion){

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
        return devices;
    }

    public void addListOfData(List<MobileDevice> devices) {
        mobileDeviceRepository.saveAll(devices);
    }
}




