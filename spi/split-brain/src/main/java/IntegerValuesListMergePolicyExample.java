/*
 * Copyright (c) 2008-2018, Hazelcast, Inc. All Rights Reserved.
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

import com.hazelcast.config.Config;
import com.hazelcast.config.ListConfig;
import com.hazelcast.config.MergePolicyConfig;
import com.hazelcast.core.Hazelcast;
import mergepolicies.MergeCollectionOfIntegerValuesMergePolicy;

/**
 * Shows the merge policy configuration for the IList via the
 * custom {@link MergeCollectionOfIntegerValuesMergePolicy}.
 */
public final class IntegerValuesListMergePolicyExample {

    private static final String LIST_NAME = "myList";

    public static void main(String[] args) {
        // for a custom merge policy we have to provide the FQCN, not just the simple classname
        MergePolicyConfig mergePolicyConfig = new MergePolicyConfig()
                .setPolicy(MergeCollectionOfIntegerValuesMergePolicy.class.getName());


        final ListConfig listConfig = new ListConfig()
                .setName(LIST_NAME)
                .setMergePolicyConfig(mergePolicyConfig);

        final Config config = new Config()
                //.setProperty("hazelcast.logging.type", "none")
                .addListConfig(listConfig);


        Hazelcast.newHazelcastInstance(config);

        Hazelcast.shutdownAll();
    }
}
