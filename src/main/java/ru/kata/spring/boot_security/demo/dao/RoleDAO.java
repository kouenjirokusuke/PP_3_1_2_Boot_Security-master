package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.Optional;

public interface RoleDAO {
    Role getRoleByName(String name);
}
