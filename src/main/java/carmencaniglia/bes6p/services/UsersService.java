package carmencaniglia.bes6p.services;

import carmencaniglia.bes6p.entities.User;
import carmencaniglia.bes6p.exceptions.NotFoundException;
import carmencaniglia.bes6p.repositories.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersDAO usersDAO;
    public List<User> getUsers(){
    return usersDAO.findAll();
    }

    public User save(User body){
    return usersDAO.save(body);
    }

    public User findById(long id){
    return usersDAO.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public void findByIdAndDelete (long id){
    User found = this.findById(id);
    usersDAO.delete(found);
    }

    public User findByIdAndUpdate(long id, User body){
        User found = this.findById(id);
        found.setUsername(body.getUsername());
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setEmail(body.getEmail());
        return usersDAO.save(found);
    }
}
