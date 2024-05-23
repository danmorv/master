package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final UserCrudServise servise;
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return servise.getById(id);
    }
    @GetMapping
    public Collection<UserDto> getAllUsers() {
        return servise.getAll();
    }
    @PostMapping("/user")
    public void createUser(@RequestBody UserDto userDto) {
        servise.create(userDto);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        servise.delete(id);
    }
    @GetMapping("/number")
    public UserDto getUserPhone(@RequestParam String number) {
        return servise.getByPhone(number);
    }
    @GetMapping("/email")
    public UserDto getUserEmail(@RequestParam String email) {
        return servise.getByEmail(email);
    }

}
