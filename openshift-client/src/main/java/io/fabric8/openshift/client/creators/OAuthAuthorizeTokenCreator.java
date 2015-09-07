/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.openshift.client.creators;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.ResourceCreator;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.dsl.internal.OAuthAuthorizeTokenOperationsImpl;

public class OAuthAuthorizeTokenCreator implements ResourceCreator<OAuthAuthorizeToken> {
  @Override
  public Class<OAuthAuthorizeToken> getKind() {
    return OAuthAuthorizeToken.class;
  }

  @Override
  public OAuthAuthorizeToken create(KubernetesClient client, String namespace, OAuthAuthorizeToken item) {
    try (OpenShiftClient osClient = client.adapt(OpenShiftClient.class)) {
      return new OAuthAuthorizeTokenOperationsImpl(osClient, namespace, item).create();
    }
  }
}