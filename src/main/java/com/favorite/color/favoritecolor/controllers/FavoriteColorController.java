package com.favorite.color.favoritecolor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.favorite.color.favoritecolor.models.FavoriteColor;
import com.favorite.color.favoritecolor.repositories.favoriteColorRepository;

@RestController
@RequestMapping("/api/v1/favoriteColor")
public class FavoriteColorController {
	
	//inject the favoriteColor repo
	@Autowired
	private favoriteColorRepository fcRepo;
	
	//get list of favorite colors
	@GetMapping 
	public List<FavoriteColor> list(){
		return fcRepo.findAll();
	}
	
	// add color to the list
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody FavoriteColor item) {
		fcRepo.save(item);
	}
	
	// get color item with vote from the list by id
	@GetMapping("/{id}")
	public FavoriteColor get(@PathVariable("id") long id) {
		return fcRepo.getById(id); 
	}
}
