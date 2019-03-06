package com.six.chunfeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.service.IndexService;

@RestController
public class IndexController {

	@Autowired
	private IndexService indexService;
	
}
