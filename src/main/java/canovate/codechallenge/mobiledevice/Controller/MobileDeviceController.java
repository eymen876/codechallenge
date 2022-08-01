package canovate.codechallenge.mobiledevice.Controller;

import canovate.codechallenge.mobiledevice.Service.MobileDeviceService;
import canovate.codechallenge.mobiledevice.Model.MobileDevice;
import canovate.codechallenge.mobiledevice.ModelDTO.MobileDeviceDTO;
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
    public long registerNewDevice(@RequestBody MobileDevice mobileDevice){
        mobileDeviceService.addNewDevice(mobileDevice);
        return mobileDevice.getId();
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
    public String addListOfData(@RequestBody List<MobileDevice> devices){
        mobileDeviceService.save(devices);
        String result="";
        for (MobileDevice d : devices){
            result += "id "+d.getId()+" inserted\n";
        }
        return result;
    }



    //Havent yet implemented.
//    @PutMapping("/update/{id}")
//    public MobileDeviceDTO replaceDevice(@RequestBody MobileDevice mobileDevice ,@PathVariable Long id){
//        return null;
//    }


}

