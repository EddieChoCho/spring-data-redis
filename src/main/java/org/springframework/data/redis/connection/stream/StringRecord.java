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
package org.springframework.data.redis.connection.stream;

import java.util.Map;

/**
 * A {@link Record} within the stream backed by a collection of {@link String} {@literal field/value} pairs.
 *
 * @author Christoph Strobl
 * @since 2.2
 */
public interface StringRecord extends MapRecord<String, String, String> {

	@Override
	StringRecord withId(RecordId id);

	/**
	 * Create a new {@link StringRecord} with the associated stream {@literal key}.
	 *
	 * @param key the stream key.
	 * @return a new {@link StringRecord}.
	 */
	StringRecord withStreamKey(String key);

	/**
	 * Create a {@link StringRecord} from a {@link Map} of {@link String strings}.
	 *
	 * @param source must not be {@literal null}.
	 * @return new instance of {@link StringRecord}.
	 * @since 2.7
	 */
	static StringRecord of(Map<String, String> source) {
		return StreamRecords.newRecord().ofStrings(source);
	}

	/**
	 * Convert a {@link MapRecord} of {@link String strings} into a {@link StringRecord}.
	 *
	 * @param source must not be {@literal null}.
	 * @return new instance of {@link StringRecord}.
	 */
	static StringRecord of(MapRecord<String, String, String> source) {
		return StreamRecords.newRecord().in(source.getRequiredStream()).withId(source.getId()).ofStrings(source.getValue());
	}
}
