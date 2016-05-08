package com.hust.cms.service;

import com.hust.cms.model.Role;

import java.util.List;

public interface IRoleService {
    public void add(Role role);

    public void delete(int id);

    public void update(Role role);

    public Role load(int id);

    public List<Role> listRole();

    public void deleteRoleUsers(int rid);
}
