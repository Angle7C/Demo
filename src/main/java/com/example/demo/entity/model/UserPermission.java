package com.example.demo.entity.model;

import java.security.Permission;

public class UserPermission extends Permission {
    /**
     * Constructs a permission with the specified name.
     *
     * @param name name of the Permission object being created.
     */
    public UserPermission(String name) {
        super(name);
    }

    @Override
    public boolean implies(Permission permission) {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getActions() {
        return null;
    }
}
