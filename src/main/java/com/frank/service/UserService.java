package com.frank.service;

import com.frank.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String> {
    List<UserDTO> findManagers();

    List<UserDTO> findEmployees();
}
