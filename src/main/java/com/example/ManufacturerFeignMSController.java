package com.example;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.example.model.Manufacturer;

@RestController
public class ManufacturerFeignMSController {

	@Autowired(required=true)
	private ManufacturerFeignClient feignClient;

	@RequestMapping(value = "/", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resources<Manufacturer> getData() throws RestClientException, URISyntaxException {
		return feignClient.findAll();

	}
}
