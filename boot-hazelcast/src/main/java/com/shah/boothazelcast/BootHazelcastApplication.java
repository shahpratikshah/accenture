package com.shah.boothazelcast;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.shah.boothazelcast.entity.UserAccount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
public class BootHazelcastApplication {


    public static void main(String[] args) {
        SpringApplication.run(BootHazelcastApplication.class, args);
    }

/*
    @Bean
    public Config hazelCastConfig(){
        MapConfig mapConfig = new MapConfig("defaultMap");
        mapConfig
                .setTimeToLiveSeconds(10)
                .setMaxIdleSeconds(10)
                .setEvictionConfig(
                        new EvictionConfig().setEvictionPolicy(EvictionPolicy.LRU)
                )
        ;
        Config config = new Config();
        config.addMapConfig(mapConfig);
        return config;
    }

    @Bean
    public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
        return Hazelcast.newHazelcastInstance(hazelCastConfig);
    }

    @Bean
    public Map<String, UserAccount> accountMap(HazelcastInstance hazelcastInstance){
        return hazelcastInstance.getMap("accountMap");
    }
*/


}
