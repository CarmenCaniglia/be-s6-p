package carmencaniglia.bes6p.services;

import carmencaniglia.bes6p.entities.Device;
import carmencaniglia.bes6p.entities.User;
import carmencaniglia.bes6p.exceptions.NotFoundException;
import carmencaniglia.bes6p.repositories.DevicesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DevicesService {
    @Autowired
    private DevicesDAO devicesDAO;
    public List<Device> getDevices(){
    return devicesDAO.findAll();
    }

    public Device save(Device body){
    return devicesDAO.save(body);
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
