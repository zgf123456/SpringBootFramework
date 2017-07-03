package com.fastdev.sample.huaiyujia.controller;/*
 * Copyright 2012-2016 the original author or authors.
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

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.UUID;

@Controller
public class UtilController {

    private Logger logger = LoggerFactory.getLogger(UtilController.class);

    private static final int DEFAULT_RANDOM_LEN = 16;

    @RequestMapping("/")
    @ResponseBody
    public HashMap<String, String> welcome() {
        return random(DEFAULT_RANDOM_LEN);
    }

    @RequestMapping("/util/random/{randomLen}/")
    @ResponseBody
    public HashMap<String, String> random(@PathVariable("randomLen") int randomLen) {
        logger.info("call method random len=" + randomLen);
        HashMap<String, String> welcomeMap = new HashMap<>();
        welcomeMap.put("uuid1", UUID.randomUUID().toString());
        welcomeMap.put("uuid2", UUID.randomUUID().toString().replace("-", ""));
        welcomeMap.put("time", System.currentTimeMillis() + "");

        if (randomLen > 64 || randomLen < 0) {
            randomLen = DEFAULT_RANDOM_LEN;
        }

        logger.info("execute method random len=" + randomLen);
        welcomeMap.put("randomAlphanumeric", RandomStringUtils.randomAlphanumeric(randomLen));
        welcomeMap.put("randomAlphabetic", RandomStringUtils.randomAlphabetic(randomLen));
        welcomeMap.put("randomNumeric", RandomStringUtils.randomNumeric(randomLen));
        welcomeMap.put("randomPrint", RandomStringUtils.randomPrint(randomLen));
        return welcomeMap;
    }

    @RequestMapping("/util/delay/{delayTime}/")
    @ResponseBody
    public String delay(@PathVariable("delayTime") int delayTime) {
        logger.info("call method delay time=" + delayTime);
        if (delayTime < 0) {
            delayTime = 0;
        }

        if (delayTime > 60000) {
            delayTime = 60000;
        }

        try {
            logger.info("execute method delay time=" + delayTime);
            Thread.sleep(delayTime);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return "delay " + delayTime;
    }
}
