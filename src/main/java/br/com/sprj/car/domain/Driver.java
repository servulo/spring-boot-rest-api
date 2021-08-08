package br.com.sprj.car.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Driver {

    @Id
    private Long id;
    private String name;
    private Date birthDate;

}