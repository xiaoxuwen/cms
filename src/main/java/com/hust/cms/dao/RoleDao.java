package com.hust.cms.dao;


import com.hust.cms.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public class RoleDao extends BaseDao<Role> implements IRoleDao {

    @Override
    public List<Role> listRole() {
        return this.list("from Role");
    }

    @Override
    public void deleteRoleUsers(int rid) {
        this.updateByHql("delete UserRole ur where ur.role.id=?", rid);
    }


}
