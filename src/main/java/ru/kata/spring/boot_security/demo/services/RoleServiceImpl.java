package ru.kata.spring.boot_security.demo.services;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Role> getRolesSet() {
        return new HashSet<>(roleRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Role findById(Long id) {
        Optional<Role> foundRole = roleRepository.findById(id);
        if (foundRole.isPresent()) {
            return foundRole.get();
        } else {
            throw new UsernameNotFoundException(String.format("Role with id - %s not found", id));
        }
    }
}
