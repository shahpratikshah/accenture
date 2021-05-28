package com.shah.boothazelcast.config;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.shah.boothazelcast.entity.UserAccount;
import com.shah.boothazelcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class HazelcastConfig {

    @Autowired
    UserService userService;


    @Bean
    public Map<String, UserAccount> accountMap(){
        MapConfig mapConfig = new MapConfig("accountMap");
        mapConfig
                .setTimeToLiveSeconds(10)
                .setMaxIdleSeconds(10);


        Config config = new Config();
        config.setManagementCenterConfig(new ManagementCenterConfig()
          .addTrustedInterface("localhost"));
        config.addMapConfig(mapConfig);
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        Map<String, UserAccount> accountMap =  hazelcastInstance.
                getMap("accountMap");
        if(accountMap.isEmpty()){
            userService.loadToMap().stream().forEach(userAccount -> accountMap.put(userAccount.getAccountNumber(), userAccount));
        }
        return accountMap;

    }


}
