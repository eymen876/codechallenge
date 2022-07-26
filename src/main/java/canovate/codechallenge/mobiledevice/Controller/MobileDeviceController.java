package canovate.codechallenge.mobiledevice.Controller;

import canovate.codechallenge.mobiledevice.Service.MobileDeviceService;
import canovate.codechallenge.mobiledevice.Model.MobileDeviceDTO;
import canovate.codechallenge.mobiledevice.Enums.os;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/devices")
public class MobileDeviceController {
    @Autowired
    private MobileDeviceService mobileDeviceService;

    @GetMapping
    public List<MobileDeviceDTO> getDevices(){
        return mobileDeviceService.getDevices();
    }

    @PostMapping
    public long registerNewDevice(@RequestBody MobileDeviceDTO mobileDeviceDTO){
        mobileDeviceService.addNewDevice(mobileDeviceDTO);
        return mobileDeviceDTO.getId();
    }

    @DeleteMapping(path = "{mobileDeviceId}")
    public String deleteDevice(@PathVariable Long mobileDeviceId){
        mobileDeviceService.deleteDevice(mobileDeviceId);
        return "Device with id " +mobileDeviceId+ " is deleted";
    }

    @GetMapping("/search")
    public List<MobileDeviceDTO> search(@RequestParam(required = false) Long id ,
                                        @RequestParam(required = false) String model,
                                        @RequestParam(required = false) String brand,
                                        @RequestParam(required = false) os os,
                                        @RequestParam(required = false) String osVersion){
        return mobileDeviceService.search(id,model,brand,os,osVersion);
    }

    @PostMapping("/insertData")
    public String addListOfData(@RequestBody List<MobileDeviceDTO> devices){
        return mobileDeviceService.save(devices);
    }



    //updates using object
    @PutMapping("/update")
    public MobileDeviceDTO updateDevice(@RequestBody MobileDeviceDTO mobileDeviceDTO ){
        return mobileDeviceService.updateDevice(mobileDeviceDTO);
    }

}

