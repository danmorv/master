package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class UserCRUD implements UserServices<UserDto>{
    private final UserRepository userRepository;
    @Override
    public UserDto getById(Integer id) {
        User user = userRepository.findById(id).orElseThrow();
        return mapToDto(user);
    }

    @Override
    public Collection<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(UserCRUD::mapToDto)
                .toList();
    }

    @Override
    public void create(UserDto userDto) {
        User user = mapToEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
    public static UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurName());
        userDto.setBirthDay(user.getBirthDay());
        userDto.setShiftNumber(user.getShiftNumber());
        return userDto;
    }
    public static User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurName(userDto.getSurname());
        user.setBirthDay(userDto.getBirthDay());
        user.setShiftNumber(userDto.getShiftNumber());
        return user;
    }
}
