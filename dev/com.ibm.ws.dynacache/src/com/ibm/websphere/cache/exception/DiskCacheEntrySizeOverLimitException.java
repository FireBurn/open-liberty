/*******************************************************************************
 * Copyright (c) 1997, 2006 IBM Corporation and others.
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
package com.ibm.websphere.cache.exception;

/**
 * Signals that the cache entry size is over the configured "diskCacheEntrySizeInMB" limit
 * when writing the cache entry to the disk cache.
 */
public class DiskCacheEntrySizeOverLimitException extends DynamicCacheException {

    private static final long serialVersionUID = 2656071545701845896L;

    /**
     * Constructs a DiskCacheEntrySizeOverLimitException with the specified detail message.
     */
    public DiskCacheEntrySizeOverLimitException(String message) {
        super(message);
    }

}


