/*
 * Copyright © 2015-2019 Santer Reply S.p.A.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.reply.orchestrator.service.commands;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import it.reply.orchestrator.dto.deployment.DeploymentMessage;
import it.reply.orchestrator.service.deployment.providers.DeploymentProviderService;
import it.reply.orchestrator.service.deployment.providers.DeploymentProviderServiceRegistry;

import org.junit.Before;
import org.mockito.Mock;

public abstract class BaseDeployCommandTest<T extends BaseDeployCommand>
    extends BaseWorkflowCommandTest<DeploymentMessage, T> {

  @Mock
  protected DeploymentProviderService deploymentProviderService;

  @Mock
  protected DeploymentProviderServiceRegistry deploymentProviderServiceRegistry;

  public BaseDeployCommandTest(T command) {
    super(command);
  }

  @Before
  public void setupBaseDeployCommandTest() {
    when(deploymentProviderServiceRegistry.getDeploymentProviderService(anyString()))
        .thenReturn(deploymentProviderService);
  }

}
