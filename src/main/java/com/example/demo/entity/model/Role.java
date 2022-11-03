package com.example.demo.entity.model;

import com.example.demo.entity.action.RoleAction;

public enum Role implements RoleAction {
    Admin{
        @Override
        public boolean isAdmin() {
            return true;
        }
        @Override
        public boolean isContest() {
            return true;
        }
        @Override
        public boolean isPlayer() {
            return true;
        }
    }

}
