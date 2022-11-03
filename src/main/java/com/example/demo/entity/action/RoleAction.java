package com.example.demo.entity.action;

public interface RoleAction {
    default boolean isContest(){
        return false;
    }

    default boolean isAdmin(){
        return false;
    }
    default boolean isPlayer(){
        return true;
    }
}
