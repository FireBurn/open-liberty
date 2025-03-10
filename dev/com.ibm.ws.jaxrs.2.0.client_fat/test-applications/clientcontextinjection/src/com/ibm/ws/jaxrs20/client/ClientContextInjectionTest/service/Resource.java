/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
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
package com.ibm.ws.jaxrs20.client.ClientContextInjectionTest.service;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Providers;

import com.ibm.ws.jaxrs20.client.ClientContextInjectionTest.client.ClientTestServlet;

@Path("resource")
public class Resource {

    @Context
    Application application;
    @Context
    UriInfo info;
    @Context
    Request request;
    @Context
    HttpHeaders headers;
    @Context
    SecurityContext security;
    @Context
    Providers providers;
    @Context
    ResourceContext resources;
    @Context
    Configuration configration;
    @Context
    HttpServletRequest servletRequest;

    @POST
    @Path("echo")
    public String returnGivenString(String string) {
        return string;
    }

    @POST
    @Path("reader")
    public String reader(StringBean bean) {
        return bean.get();
    }

    @POST
    @Path("writer")
    public StringBean writer(String entity) {
        return new StringBean(entity);
    }

    @GET
    @Path("instance")
    public String instance() {
        return StringBeanEntityProviderWithInjectables.computeMask(application,
                                                                   info, request, headers, security, providers, resources,
                                                                   configration);
    }

    @GET
    @Path("method")
    public String method(@Context Application application,
                         @Context UriInfo info, @Context Request request,
                         @Context HttpHeaders headers, @Context SecurityContext security,
                         @Context Providers providers, @Context ResourceContext resources) {
        return StringBeanEntityProviderWithInjectables.computeMask(application,
                                                                   info, request, headers, security, providers, resources,
                                                                   configration);
    }

    @GET
    @Path("application")
    public String application(@Context Application application) {
        Set<Object> singletons = application.getSingletons();
        SingletonWithInjectables singleton = (SingletonWithInjectables) singletons
                        .iterator().next();
        return singleton.getInjectedContextValues();
    }

    @GET
    @Path("invokeClient")
    public String invokeClient() {
        String response = "PASS";
        String serverNamePre = servletRequest.getServerName();
        String remoteUri = "http://" + serverNamePre + ":" + servletRequest.getServerPort() + "/"
                           + ClientTestServlet.moduleName + "/resource/remote";
        String s = ClientBuilder.newClient().target(remoteUri).request().get(String.class);
        System.out.println("Received from remote: " + s);
        if (s == null) {
            response = "FAIL";
        }
        String serverNamePost = servletRequest.getServerName();
        System.out.println("From LocalResource(" + serverNamePost + ")");
        if (serverNamePost == null || !serverNamePre.equals(serverNamePost)) {
            response = "FAIL";
        }
        return response;
    }

    @GET
    @Path("remote")
    public String remote() {
        String s = "From RemoteResource(" + servletRequest.getServerName() + ")";
        System.out.println(s);
        return s;
    }
}
