package com.favorite.color.favoritecolor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.favorite.color.favoritecolor.models.FavoriteColor;

public interface favoriteColorRepository extends JpaRepository<FavoriteColor, Long> {
	
}
