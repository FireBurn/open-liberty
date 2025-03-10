/*******************************************************************************
 * Copyright (c) 2011, 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.logstash.collector.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ibm.ws.logstash.collector.tests.ContainerEnvVarTest;
import com.ibm.ws.logstash.collector.tests.CustomizedTagTest;
import com.ibm.ws.logstash.collector.tests.LogStashWithBinaryLoggingTest;
import com.ibm.ws.logstash.collector.tests.LogstashCollectorIndependentTest;
import com.ibm.ws.logstash.collector.tests.LogstashSSLTest;
import com.ibm.ws.logstash.collector.tests.MaxFieldLengthTest;
import com.ibm.ws.logstash.collector.tests.ThrottleMaxEventsTest;

import componenttest.containers.TestContainerSuite;
import componenttest.custom.junit.runner.AlwaysPassesTest;

@RunWith(Suite.class)
@SuiteClasses({
                AlwaysPassesTest.class, // Must keep this test to run something in the Java 6 builds.
                CustomizedTagTest.class,
                ThrottleMaxEventsTest.class,
                LogstashSSLTest.class,
                MaxFieldLengthTest.class,
                LogStashWithBinaryLoggingTest.class,
                LogstashCollectorIndependentTest.class,
                ContainerEnvVarTest.class
})

/**
 * Purpose: This suite collects and runs all known good test suites.
 */
public class FATSuite extends TestContainerSuite {
}
