/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.langchain.llms.openai;

import com.hw.openai.utils.ProxyUtils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @description: OpenAITest
 * @author: HamaWhite
 */
class OpenAITest {

    /**
     * Test valid call to openai
     */
    @Test
    void testOpenAICall() {
        OpenAI llm = OpenAI.builder()
                .openaiProxy(ProxyUtils.http("127.0.0.1", 1087))
                .maxTokens(10)
                .build()
                .init();

        assertThat(llm.call("Say foo:")).isEqualTo("\n\nFoo!");
    }
}