/*******************************************************************************
 * Copyright (c) 2020 IBM Corporation and others.
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

//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//

package com.ibm.was.wssample.sei.echo;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "EchoService12", targetNamespace = "http://com/ibm/was/wssample/sei/echo/", wsdlLocation = "WEB-INF/wsdl/Echo12.wsdl")
public class EchoService12 extends Service {

    private final static URL ECHOSERVICE12_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = com.ibm.was.wssample.sei.echo.EchoService12.class.getResource("/WEB-INF/wsdl/Echo12.wsdl");
            if (url == null)
                throw new MalformedURLException("/WEB-INF/wsdl/Echo12.wsdl does not exist in the module.");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ECHOSERVICE12_WSDL_LOCATION = url;
    }

    public EchoService12(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EchoService12() {
        super(ECHOSERVICE12_WSDL_LOCATION, new QName("http://com/ibm/was/wssample/sei/echo/", "EchoService12"));
    }

    /**
     *
     * @return
     *         returns EchoService12PortType
     */
    @WebEndpoint(name = "EchoService12Port")
    public EchoService12PortType getEchoService12Port() {
        return super.getPort(new QName("http://com/ibm/was/wssample/sei/echo/", "EchoService12Port"), EchoService12PortType.class);
    }

    /**
     *
     * @param features
     *                     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy. Supported features not in the <code>features</code> parameter will have their
     *                     default values.
     * @return
     *         returns EchoService12PortType
     */
    @WebEndpoint(name = "EchoService12Port")
    public EchoService12PortType getEchoService12Port(WebServiceFeature... features) {
        return super.getPort(new QName("http://com/ibm/was/wssample/sei/echo/", "EchoService12Port"), EchoService12PortType.class, features);
    }

}
