package com.avvarga.popaballoon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.popaballoon.models.UserReward;

@Repository
public interface UserRewardRepository extends CrudRepository<UserReward, Long> {
	
}
