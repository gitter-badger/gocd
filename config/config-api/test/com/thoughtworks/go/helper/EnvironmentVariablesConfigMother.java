/*************************GO-LICENSE-START*********************************
 * Copyright 2014 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *************************GO-LICENSE-END***********************************/

package com.thoughtworks.go.helper;

import com.thoughtworks.go.config.EnvironmentVariablesConfig;

public class EnvironmentVariablesConfigMother {
    public static EnvironmentVariablesConfig env(String name, String value) {
        EnvironmentVariablesConfig config = new EnvironmentVariablesConfig();
        config.add(name, value);
        return config;
    }

    public static EnvironmentVariablesConfig env(String[] names, String[] values) {
        EnvironmentVariablesConfig config = new EnvironmentVariablesConfig();
        for (int i = 0; i < names.length; i++) {
            config.add(names[i], values[i]);
        }
        return config;
    }
}
