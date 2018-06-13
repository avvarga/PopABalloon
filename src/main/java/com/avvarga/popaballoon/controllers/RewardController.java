package com.avvarga.popaballoon.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avvarga.popaballoon.models.Reward;
import com.avvarga.popaballoon.models.User;
import com.avvarga.popaballoon.models.UserReward;
import com.avvarga.popaballoon.services.RewardService;
import com.avvarga.popaballoon.services.UserRewardService;
import com.avvarga.popaballoon.services.UserService;

@Controller
public class RewardController {

		private RewardService rServ;
		private UserService uServ;
		private UserRewardService urServ;
		
		public RewardController (RewardService rServ, UserService uServ, UserRewardService urServ) {
			this.rServ = rServ;
			this.uServ = uServ;
			this.urServ = urServ;
		}
		
		@RequestMapping("/prize")
		@ResponseBody
		public Reward generatePrize(Principal principal) {
			User user = uServ.findByUsername(principal.getName());
			List <UserReward> prizes = user.getPrizes();
			Random random = new Random();
			Long id = (long) (random.nextInt(4)+1);
			Reward prize = rServ.findById(id);
			UserReward ur = new UserReward();
			ur.setUser(user);
			ur.setReward(prize);
			ur.setStatus("Pending");
			urServ.save(ur);
			SecurityContextHolder.getContext().setAuthentication(null);
			System.out.println(prize.getName());
			return prize;
		}
		
}
