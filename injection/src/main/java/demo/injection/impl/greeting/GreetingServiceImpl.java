package demo.injection.impl.greeting;

/*-
 * #%L
 * actframework app demo - dependency injection
 * %%
 * Copyright (C) 2018 ActFramework
 * %%
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
 * #L%
 */

import act.Act;
import act.app.ActionContext;
import act.sys.Env;
import demo.injection.GreetingService;

import javax.inject.Inject;
import javax.inject.Provider;

@Env.Mode(Act.Mode.PROD)
public class GreetingServiceImpl implements GreetingService {

    @Inject
    Provider<ActionContext> context;

    @Override
    public String greeting() {
        String who = context.get().paramVal("who");
        if (null == who) {
            who = "world";
        }
        return String.format("Hello %s!", who);
    }
}
