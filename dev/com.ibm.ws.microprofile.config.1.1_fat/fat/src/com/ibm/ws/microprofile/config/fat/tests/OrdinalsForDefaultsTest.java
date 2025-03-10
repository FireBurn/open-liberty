/*******************************************************************************
* Copyright (c) 2016, 2024 IBM Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License 2.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*******************************************************************************/

package com.ibm.ws.microprofile.config.fat.tests;

import java.io.File;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import com.ibm.websphere.simplicity.ShrinkHelper;
import com.ibm.websphere.simplicity.ShrinkHelper.DeployOptions;
import com.ibm.ws.microprofile.appConfig.ordForDefaults.test.OrdinalsForDefaultsTestServlet;
import com.ibm.ws.microprofile.config.fat.suite.SharedShrinkWrapApps;

import componenttest.annotation.Server;
import componenttest.annotation.TestServlet;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.custom.junit.runner.Mode;
import componenttest.custom.junit.runner.Mode.TestMode;
import componenttest.rules.repeater.RepeatTests;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.FATServletClient;
import io.openliberty.microprofile.config.fat.repeat.ConfigRepeatActions;

/**
 *
 */
@RunWith(FATRunner.class)
@Mode(TestMode.FULL)
public class OrdinalsForDefaultsTest extends FATServletClient {

    public static final String SERVER_NAME = "OrdForDefaultsServer";
    public static final String APP_NAME = "ordForDefaults";

    @Server(SERVER_NAME)
    @TestServlet(servlet = OrdinalsForDefaultsTestServlet.class, contextRoot = APP_NAME)
    public static LibertyServer server;

    @ClassRule
    public static RepeatTests r = ConfigRepeatActions.repeatDefault(SERVER_NAME);

    @BeforeClass
    public static void setUp() throws Exception {
        WebArchive ordForDefaults_war = ShrinkWrap.create(WebArchive.class, APP_NAME + ".war")
                                                  .addPackages(true, "com.ibm.ws.microprofile.appConfig.ordForDefaults.test")
                                                  .addAsLibrary(SharedShrinkWrapApps.getTestAppUtilsJar())
                                                  .addAsManifestResource(new File("test-applications/" + APP_NAME + ".war/resources/META-INF/permissions.xml"), "permissions.xml")
                                                  .addAsManifestResource(new File("test-applications/" + APP_NAME + ".war/resources/META-INF/microprofile-config.properties"),
                                                                         "microprofile-config.properties");

        ShrinkHelper.exportDropinAppToServer(server, ordForDefaults_war, DeployOptions.SERVER_ONLY);

        server.startServer();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.stopServer();
    }

}
