package com.avvarga.popaballoon.services;

import org.springframework.stereotype.Service;

import com.avvarga.popaballoon.models.Reward;
import com.avvarga.popaballoon.repositories.RewardRepository;

@Service
public class RewardService {
	private RewardRepository rRepo;
	
	public RewardService (RewardRepository rRepo) {
		this.rRepo = rRepo;
	}

	public Reward findById(int id) {
		return rRepo.findById((long) id).get();
	}
}
