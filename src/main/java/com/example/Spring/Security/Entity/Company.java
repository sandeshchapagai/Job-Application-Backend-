package com.example.Spring.Security.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Company_table")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "companyId")
    private long companyId;
    @Column(name = "companyName")
    private String companyName;

    @Column(name="companyNumber")
    private  String companyNumber;

//

}
