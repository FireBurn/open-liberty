/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
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
package com.ibm.wsspi.security.wim.exception;

public class InvalidArgumentException extends WIMApplicationException {

    private static final long serialVersionUID = -5472875166242746112L;

    /**
     *
     */
    public InvalidArgumentException() {
        super();
    }

    /**
     * @param message
     */
    public InvalidArgumentException(String key, String message) {
        super(key, message);
    }

    /**
     * @param cause
     */
    public InvalidArgumentException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public InvalidArgumentException(String key, String message, Throwable cause) {
        super(key, message, cause);
    }

}
