/*
 * Copyright 2013 eXo Platform SAS
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

package juzu.request;

import juzu.Response;
import juzu.impl.request.Method;
import juzu.impl.request.Request;
import juzu.impl.bridge.spi.ActionBridge;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public class ActionContext extends RequestContext {

  /** . */
  private ActionBridge bridge;

  public ActionContext(Request request, Method method, ActionBridge bridge) {
    super(request, method);

    //
    this.bridge = bridge;
  }

  @Override
  protected ActionBridge getBridge() {
    return bridge;
  }

  public ClientContext getClientContext() {
    return bridge.getClientContext();
  }

  @Override
  public Phase.Action getPhase() {
    return Phase.ACTION;
  }

  public Response.View createResponse(Method<Phase.View> target) throws IllegalStateException {
    return createViewDispatch(target);
  }

  public Response.View createResponse(Method<Phase.View> target, Object arg) throws IllegalStateException {
    return createViewDispatch(target, arg);
  }

  public Response.View createResponse(Method<Phase.View> target, Object[] args) throws IllegalStateException {
    return createViewDispatch(target, args);
  }
}
