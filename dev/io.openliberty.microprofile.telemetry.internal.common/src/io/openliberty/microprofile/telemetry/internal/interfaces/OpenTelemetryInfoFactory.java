/*******************************************************************************
 * Copyright (c) 2023, 2024 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package io.openliberty.microprofile.telemetry.internal.interfaces;

import io.openliberty.microprofile.telemetry.internal.common.info.OpenTelemetryInfo;

public interface OpenTelemetryInfoFactory {

    /**
     * @return
     */
    OpenTelemetryInfo createOpenTelemetryInfo(boolean runtimeEnabled);

    /**
     * @return
     */
    OpenTelemetryInfo createDisposedOpenTelemetryInfo();

    /**
     * @return
     */
    OpenTelemetryInfo createDisabledOpenTelemetryInfo();
}
