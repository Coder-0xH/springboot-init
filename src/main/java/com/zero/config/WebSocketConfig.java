//package com.zero.config;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.server.standard.ServerEndpointExporter;
//
///**
// * @author Sonata
// */
//@Configuration
//public class WebSocketConfig {
//
////	@Bean
////	public ServerEndpointExporter serverEndpointExporter() {
////		return new ServerEndpointExporter();
////	}
//
//	@Bean
//	@ConditionalOnMissingBean
//	@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
//	public ServerEndpointExporter serverEndpointExporter() {
//		return new ServerEndpointExporter();
//	}
//
//
//}
