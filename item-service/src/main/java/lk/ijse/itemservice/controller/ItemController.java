package lk.ijse.itemservice.controller;

import lk.ijse.itemservice.dto.ItemDTO;
import lk.ijse.itemservice.dto.UserDTO;
import lk.ijse.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/item")
@CrossOrigin("*")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    private RestTemplate restTemplate;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public String saveItem(@RequestBody ItemDTO itemDTO, UserDTO userDTO) {

        restTemplate.postForObject("http://localhost:8086/userService/users", userDTO, UserDTO.class);
        itemService.saveItem(itemDTO);

        return "Success";

    }

    @GetMapping("/get")
    public String getUser() {
        return restTemplate.getForObject("http://localhost:8086/userService/users/getUser", String.class);
    }
}
