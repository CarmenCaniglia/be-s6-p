package carmencaniglia.bes6p.controllers;

import carmencaniglia.bes6p.entities.Device;
import carmencaniglia.bes6p.entities.User;
import carmencaniglia.bes6p.services.DevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")

public class DevicesController {
    @Autowired
    private DevicesService devicesService;

    @GetMapping
    public Page<Device> getDevice(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String orderBy){
        return devicesService.getDevices(page, size, orderBy);
    }
    @GetMapping("/{deviceId}")
    public Device getDeviceById(@PathVariable long deviceId){
       return devicesService.findById(deviceId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Device createDevice(@RequestBody Device newDevicePayload){
        return devicesService.save(newDevicePayload);
    }
    @PutMapping("/{deviceId}")
    public Device updateDevice(@PathVariable long deviceId,@RequestBody Device updateDevicePayload){
        return devicesService.findByIdAndUpdate(deviceId, updateDevicePayload);
    }
    @DeleteMapping("/{deviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getAndDeleteUser(@PathVariable long deviceId){
        devicesService.findByIdAndDelete(deviceId);
    }
}
