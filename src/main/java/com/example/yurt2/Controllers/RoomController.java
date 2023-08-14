package com.example.yurt2.Controllers;

import com.example.yurt2.Services.RoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    RoomService roomService;

}
