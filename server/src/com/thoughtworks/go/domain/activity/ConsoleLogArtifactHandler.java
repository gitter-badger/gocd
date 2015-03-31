package com.thoughtworks.go.domain.activity;

import com.thoughtworks.go.domain.JobInstance;
import com.thoughtworks.go.server.domain.JobStatusListener;
import com.thoughtworks.go.server.service.ArtifactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * **********************GO-LICENSE-START*********************************
 * Copyright 2015 ThoughtWorks, Inc.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ************************GO-LICENSE-END**********************************
 */
@Component
public class ConsoleLogArtifactHandler implements JobStatusListener {
    private ArtifactsService service;

    @Autowired
    public ConsoleLogArtifactHandler(ArtifactsService service) {
        this.service = service;
    }

    @Override
    public void jobStatusChanged(JobInstance job) {
        if (job.getState().isCompleted()) {
            service.moveConsoleArtifacts(job.getIdentifier());
        }
    }
}