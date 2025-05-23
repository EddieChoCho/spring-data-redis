/*
 * Copyright 2018-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.redis.stream;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.extension.LettuceConnectionFactoryExtension;
import org.springframework.data.redis.test.condition.EnabledOnCommand;

/**
 * Integration tests for {@link StreamMessageListenerContainer} using Lettuce.
 *
 * @author Mark Paluch
 * @author Christoph Strobl
 */
@ExtendWith(LettuceConnectionFactoryExtension.class)
@EnabledOnCommand("XREAD")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LettuceStreamMessageListenerContainerIntegrationTests
		extends AbstractStreamMessageListenerContainerIntegrationTests {

	public LettuceStreamMessageListenerContainerIntegrationTests(RedisConnectionFactory connectionFactory) {
		super(connectionFactory);
	}

}
