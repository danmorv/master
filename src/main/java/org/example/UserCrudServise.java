package org.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
@RequiredArgsConstructor
@Service
@Slf4j
public class UserCrudServise implements Servise<UserDto>{
    private final Repository repository;


    @Override
    public UserDto getById(Integer id) {
        User user = repository.findById(id).orElseThrow();
        return mapToDto(user);
    }


    @Override
    public Collection<UserDto> getAll() {
        return repository.findAll()
                .stream()
                .map(UserCrudServise::mapToDto)
                .toList();
    }

    @Override
    public void create(UserDto item) {
        User user = mapToEntity(item);
        repository.save(user);
        class ProcentWallet implements Runnable{
            private int procent = 5;
            @Override
            public void run() {
                if (procent <= 205) user.setWallet(user.getWallet() + (user.getWallet() * procent/100));
                repository.save(user);
                procent = procent + 5;
            }
        }
        new Thread(new ProcentWallet()).start();
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Integer id, UserDto item) {

    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public UserDto getByPhone(String number) {
        User user = new User();
        for (int i = 1; i <= repository.count(); i++) {
            user = repository.findById(i).orElseThrow();
            if (user.getPhoneNumber().equals(number)) {
                break;
            }
        }
        return mapToDto(user);
    }

    @Override
    public UserDto getByEmail(String email) {
        User user = new User();
        for (int i = 1; i <= repository.count(); i++) {
            user = repository.findById(i).orElseThrow();
            if (user.getEMail().equals(email)) {
                break;
            }
        }
        return mapToDto(user);
    }


    public static UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setEMail(user.getEMail());
        userDto.setBirthday(user.getBrithday());
        userDto.setWallet(user.getWallet());
        return userDto;

    }
    public static User mapToEntity(UserDto userDto){
        User user = new User();
        user.setId(user.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEMail(userDto.getEMail());
        user.setBrithday(userDto.getBirthday());
        user.setWallet(userDto.getWallet());
        return user;
    }
}
