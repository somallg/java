package com.somallg.sample.bundle.service.impl;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;

import com.somallg.sample.bundle.service.HelloService;

@Component(label = "Hello Service",
		description = "Hello Service Description",
		metatype = true)
@Service(HelloService.class)
@Properties({
	@Property(name = "hello.message", value = {"Hello Lala", "Hello Lolo"})
})
public class HelloServiceImpl implements HelloService {
	
	private String[] helloMessage;
	
	@Activate
	protected void activate(ComponentContext context) {
		this.helloMessage = PropertiesUtil.toStringArray(context.getProperties().get("hello.message"));
	}

	@Override
	public String[] getMessage() {
		return this.helloMessage;
	}
}
