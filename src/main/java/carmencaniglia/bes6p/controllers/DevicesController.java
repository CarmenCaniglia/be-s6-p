package carmencaniglia.bes6p.controllers;

import carmencaniglia.bes6p.entities.Device;
import carmencaniglia.bes6p.entities.User;
import carmencaniglia.bes6p.services.DevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")

public class DevicesController {
    @Autowired
    private DevicesService devicesService;

    @GetMapping
    public List<Device> getDevice(){
        return devicesService.getDevices();
    }
    @GetMapping("/{deviceId}")
    public Device getDeviceById(@PathVariable long deviceId){
       return devicesService.findById(deviceId);
    }
    @PostMapping
    public Device createDevice(@RequestBody Device newDevicePayload){
        return devicesService.save(newDevicePayload);
    }
    @PutMapping("/{deviceId}")
    public Device updateDevice(@PathVariable long deviceId,@RequestBody Device updateDevicePayload){
        return devicesService.findByIdAndUpdate(deviceId, updateDevicePayload);
    }
    @DeleteMapping("/{deviceId}")
    public void getAndDeleteUser(@PathVariable long deviceId){
        devicesService.findByIdAndDelete(deviceId);
    }
}
