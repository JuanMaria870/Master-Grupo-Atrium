package com.grupoatrium.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(value = {ClaseConfig1.class,ClaseConfig2.class})
public class ClaseConfig {


}
