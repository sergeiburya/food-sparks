package team.project.foodsparks.service;

import team.project.foodsparks.model.Role;

public interface RoleService {

    Role add(Role role);

    Role getByName(String role);
}
