package com.hust.cms.model;

import javax.persistence.*;

/**
 * 用户角色对象
 *
 * @author Administrator
 */
@Entity
@Table(name = "t_user_role")
public class UserRole {
    private int id;
    private User user;
    private Role role;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "r_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
