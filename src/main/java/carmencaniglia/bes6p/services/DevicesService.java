package carmencaniglia.bes6p.services;

import carmencaniglia.bes6p.entities.Device;
import carmencaniglia.bes6p.entities.State;
import carmencaniglia.bes6p.exceptions.NotFoundException;
import carmencaniglia.bes6p.payloads.devices.DeviceDTO;
import carmencaniglia.bes6p.repositories.DevicesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DevicesService {
    @Autowired
    private DevicesDAO devicesDAO;
    public Page<Device> getDevices(int page, int size, String orderBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
    return devicesDAO.findAll(pageable);
    }

    public Device save(DeviceDTO body){
        Device device = new Device();
        device.setCategory(body.category());
        device.setState(State.AVAILABLE);
    return devicesDAO.save(device);
    }

    public Device findById(long id){
    return devicesDAO.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public void findByIdAndDelete (long id){
    Device found = this.findById(id);
    devicesDAO.delete(found);
    }

    public Device findByIdAndUpdate(long id, Device body){
        Device found = this.findById(id);
        found.setCategory(body.getCategory());
        found.setState(body.getState());
        return devicesDAO.save(found);
    }
}
