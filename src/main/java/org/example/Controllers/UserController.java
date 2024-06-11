package org.example.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProductDto;
import org.example.dto.UserDto;
import org.example.services.ProductCRUD;
import org.example.services.UserCRUD;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserCRUD userCRUD;
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return userCRUD.getById(id);
    }
    @GetMapping()
    public Collection<UserDto> getAllProduct() {
        return userCRUD.getAll();
    }
    @PostMapping()
    public void createProduct(@RequestBody UserDto userDto) {
        userCRUD.create(userDto);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userCRUD.delete(id);
    }
}
