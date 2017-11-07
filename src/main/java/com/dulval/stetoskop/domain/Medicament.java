/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulval.stetoskop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author Diego Dulval
 */
@Data
@Entity
public class Medicament implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "id.medicamentInteration")
    private Set<InterationMedicament> interations = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.medicament")
    private Set<InterationMedicament> medicamentInteration = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "APRESENTATION")
    private Set<String> apresentations = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "COMERCIAL_NAME")
    private Set<String> comercialNames = new HashSet<>();

}