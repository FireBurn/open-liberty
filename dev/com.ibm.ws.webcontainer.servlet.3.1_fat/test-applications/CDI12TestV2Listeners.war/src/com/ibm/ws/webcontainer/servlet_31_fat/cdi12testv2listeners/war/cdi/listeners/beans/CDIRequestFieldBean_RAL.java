/*******************************************************************************
 * Copyright (c) 2015 IBM Corporation and others.
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
package com.ibm.ws.webcontainer.servlet_31_fat.cdi12testv2listeners.war.cdi.listeners.beans;

import javax.enterprise.context.RequestScoped;

import com.ibm.ws.webcontainer.servlet_31_fat.cdi12testv2.jar.cdi.beans.v2.RequestFieldBean;

/**
 * CDI Testing: ServletRequestAttributeListener request scoped field bean.
 */
@RequestScoped
public class CDIRequestFieldBean_RAL extends RequestFieldBean {
    // EMPTY
}
