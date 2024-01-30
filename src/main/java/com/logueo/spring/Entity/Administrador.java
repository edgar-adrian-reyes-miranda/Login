package com.logueo.spring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="admins")
/*
@SQLDelete(sql="UPDATE admins SET deleted= true WHERE id_admin= ?")
@FilterDef(
    name="deletedadminsFilter",
	parameters = @ParamDef(name = "isDeleted",
            type = "boolean") )
@Filter(name="deleteAdminFilter",condition="deleted = :isDeleted")*/
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_admin;
    private String username;
    private String password;
   // private  boolean deleted = Boolean.FALSE;
}
