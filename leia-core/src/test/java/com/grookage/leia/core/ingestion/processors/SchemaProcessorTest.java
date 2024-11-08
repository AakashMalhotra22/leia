/*
 * Copyright (c) 2024. Koushik R <rkoushik.14@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.grookage.leia.core.ingestion.processors;

import com.grookage.leia.core.ingestion.VersionIDGenerator;
import com.grookage.leia.repository.SchemaRepository;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public abstract class SchemaProcessorTest {

    @Getter
    private static final VersionIDGenerator generator = new VersionIDGenerator() {
        @Override
        public String generateVersionId(String prefix) {
            return "V1234";
        }
    };
    @Getter
    private static SchemaRepository schemaRepository;
    private static SchemaProcessor schemaProcessor;

    abstract SchemaProcessor getSchemaProcessor();

    @BeforeEach
    void setup() {
        schemaRepository = Mockito.mock(SchemaRepository.class);
        schemaProcessor = getSchemaProcessor();
    }

}
