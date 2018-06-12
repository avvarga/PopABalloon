package com.avvarga.popaballoon.services;

import org.springframework.stereotype.Service;

import com.avvarga.popaballoon.models.UserReward;
import com.avvarga.popaballoon.repositories.UserRewardRepository;

@Service
public class UserRewardService {

		private UserRewardRepository urRepo;
		public UserRewardService (UserRewardRepository urRepo) {
			this.urRepo = urRepo;
		}
		
		public void save(UserReward ur) {
			urRepo.save(ur);
		}
		
}
