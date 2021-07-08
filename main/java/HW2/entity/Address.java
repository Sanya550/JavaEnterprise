package HW2.entity;

import lombok.Data;

@Data
public class Address {
    private long id;
    private String city;
    private String street;
    private long house;
}
