package com.tongo.backend.controllers;


import com.tongo.backend.data.dtos.PlayDto;
import com.tongo.backend.services.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("/play")
public class PlayController {
    @Autowired
    PlayService playService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity getCurrentPlays(){
    return new ResponseEntity(playService.getCurrentPlays(), HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping
    public ResponseEntity postNewPlay(@RequestBody PlayDto playDto){
        playService.postNewPlay(playDto);
        System.out.println(playDto.getDescription());
        return new ResponseEntity(HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/all") //all
    public ResponseEntity getPlayDetailsSimple(){
        return new ResponseEntity(playService.getPlayDetailsSimple(), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity getPlayDetailsById(@PathVariable int id){
        return new ResponseEntity(playService.getPlayDetailsById(id), HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity editPlay(@PathVariable int id, @RequestBody PlayDto playDto){
        playService.editPlay(id, playDto);
        return new ResponseEntity(HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deletePlay(@PathVariable int id){
        playService.deletePlay(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
