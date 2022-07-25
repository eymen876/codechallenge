package canovate.codechallenge.mobiledevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/model={model}")
    public List <MobileDeviceDTO> findDeviceByModel(@PathVariable String model){
        return mobileDeviceService.getMobileDeviceByModel(model);
    }

    @GetMapping("/device={id}")
    public MobileDeviceDTO searchById(@PathVariable long id){
        return mobileDeviceService.getMobileDeviceById(id);
    }

    @GetMapping("/brand={brand}")
    public List <MobileDeviceDTO> searchByBrand(@PathVariable String brand){
        return mobileDeviceService.getMobileDeviceByBrand(brand);
    }

    @GetMapping("/os={os}")
    public List <MobileDeviceDTO> searchByOs(@PathVariable os os){
        return mobileDeviceService.getMobileDeviceByOs(os);
    }

    @GetMapping("/osVersion={osVersion}")
    public List <MobileDeviceDTO> searchByOsVersion(@PathVariable String osVersion){
        return mobileDeviceService.getMobileDeviceByOsVersion(osVersion);
    }

    @GetMapping("/search")
    public List<MobileDeviceDTO> search(@RequestParam(required = false) String brand ,
                                        @RequestParam(required = false) String model,
                                        @RequestParam(required = false) String osVersion   ){
        return mobileDeviceService.search(brand,model,osVersion);
    }

    @PostMapping("/insertData")
    public String addListOfData(@RequestBody List<MobileDevice> devices){
        mobileDeviceService.addListOfData(devices);
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

