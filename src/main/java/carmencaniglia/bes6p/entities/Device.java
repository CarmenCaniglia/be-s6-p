package carmencaniglia.bes6p.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "devices")
public class Device {
    private long id;
    private String category;
    private String state;
}
