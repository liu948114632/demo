package com.liu.security.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions"
            ,joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")}
            ,inverseJoinColumns = {@JoinColumn(name = "permission_id",referencedColumnName = "id")}
            )
    private Set<Permission> permissions;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    
}