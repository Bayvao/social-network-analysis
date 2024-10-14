package com.social.network.analysis;

import org.apache.coyote.ProtocolHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executors;

@SpringBootApplication
public class SocialNetworkAnalysisApplication {

	private static final Logger log = LoggerFactory.getLogger(SocialNetworkAnalysisApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SocialNetworkAnalysisApplication.class, args);
	}

	@Bean
	public TomcatProtocolHandlerCustomizer<ProtocolHandler> protocolHandlerVirtualThreadExecutorCustomizer() {
		return protocolHandler -> {
			log.info("Configuring {} to use VirtualThreadPerTaskExecutor", protocolHandler);
			protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
		};
	}
}
