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
package org.apache.cxf.jaxrs.sse;

import javax.ws.rs.InternalServerErrorException;

/**
 * Exception indicates that there is no suitable message body writer for this class.
 */
public class NoSuitableMessageBodyWriterException extends InternalServerErrorException {

    public NoSuitableMessageBodyWriterException(String msg) {
        super(msg);
    }
}
