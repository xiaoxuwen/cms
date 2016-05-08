package com.hust.cms.dao;

import com.hust.cms.model.Role;

import java.util.List;


public interface IRoleDao extends IBaseDao<Role> {
    public List<Role> listRole();

    public void deleteRoleUsers(int rid);
}
