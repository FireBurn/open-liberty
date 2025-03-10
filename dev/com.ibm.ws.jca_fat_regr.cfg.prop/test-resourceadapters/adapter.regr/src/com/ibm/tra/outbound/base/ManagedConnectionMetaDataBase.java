/*******************************************************************************
 * Copyright (c) 2003, 2022 IBM Corporation and others.
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
package com.ibm.tra.outbound.base;

import javax.resource.ResourceException;
import javax.resource.spi.ManagedConnectionMetaData;

/**
 * @author kwok
 * 
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ManagedConnectionMetaDataBase implements ManagedConnectionMetaData {

    private static final String EIS_PRODUCT_NAME = "FVTCCIAdapter";
    private static final String EIS_PRODUCT_VERSION = "1.0";
    private static final int MAX_CONNECTIONS = 5;

    private ManagedConnectionBase mc;

    public ManagedConnectionMetaDataBase(ManagedConnectionBase mc) {
        this.mc = mc;
    }

    /**
     * @see javax.resource.spi.ManagedConnectionMetaData#getEISProductName()
     */
    public String getEISProductName() throws ResourceException {
        return EIS_PRODUCT_NAME;
    }

    /**
     * @see javax.resource.spi.ManagedConnectionMetaData#getEISProductVersion()
     */
    public String getEISProductVersion() throws ResourceException {
        return EIS_PRODUCT_VERSION;
    }

    /**
     * @see javax.resource.spi.ManagedConnectionMetaData#getMaxConnections()
     */
    public int getMaxConnections() throws ResourceException {
        return MAX_CONNECTIONS;
    }

    /**
     * @see javax.resource.spi.ManagedConnectionMetaData#getUserName()
     */
    public String getUserName() throws ResourceException {
        return mc.getUserName();
    }

}
