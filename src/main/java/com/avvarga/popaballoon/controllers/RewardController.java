package com.avvarga.popaballoon.controllers;

import org.springframework.stereotype.Controller;

import com.avvarga.popaballoon.services.RewardService;

@Controller
public class RewardController {

		private RewardService rServ;
		public RewardController (RewardService rServ) {
			this.rServ = rServ;
		}
		
}
