/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fastdev.test.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

//@SpringBootApplication
public class SampleRedisApplication implements CommandLineRunner {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void run(String... args) throws Exception {

        // key value 操作
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        String key = "spring.boot.redis.test";
        if (!this.stringRedisTemplate.hasKey(key)) {
            ops.set(key, "foo");
        }
        System.out.println("Found key " + key + ", value=" + ops.get(key));

        // list 操作
//        ListOperations<String, String> opsForList = this.stringRedisTemplate.opsForList();
//        opsForList.leftPop(key);
//        opsForList.leftPush(key, "value");

        // hash 操作
//        HashOperations<String, Object, Object> opsForHash = this.stringRedisTemplate.opsForHash();

        // set 操作
//        SetOperations<String, String> opsForSet = this.stringRedisTemplate.opsForSet();

        // zset 操作
//        ZSetOperations<String, String> opsForZSet = this.stringRedisTemplate.opsForZSet();
    }

    public static void main(String[] args) throws Exception {
        // Close the context so it doesn't stay awake listening for redis
        SpringApplication.run(SampleRedisApplication.class, args).close();
    }

}
