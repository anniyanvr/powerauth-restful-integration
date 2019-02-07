/*
 * PowerAuth integration libraries for RESTful API applications, examples and
 * related software components
 *
 * Copyright (C) 2018 Wultra s.r.o.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.getlime.security.powerauth.rest.api.model.request.v3;

/**
 * Request object for activation layer 2.
 *
 * @author Roman Strobl, roman.strobl@wultra.com
 *
 */
public class ActivationLayer2Request {

    private String devicePublicKey;
    private String activationName;
    private String extras;

    /**
     * Get Base64 encoded device public key.
     * @return Device public key.
     */
    public String getDevicePublicKey() {
        return devicePublicKey;
    }

    /**
     * Set Base64 encoded device public key.
     * @param devicePublicKey Device public key.
     */
    public void setDevicePublicKey(String devicePublicKey) {
        this.devicePublicKey = devicePublicKey;
    }

    /**
     * Get activation name.
     * @return Activation name.
     */
    public String getActivationName() {
        return activationName;
    }

    /**
     * Set activation name.
     * @param activationName Activation name.
     */
    public void setActivationName(String activationName) {
        this.activationName = activationName;
    }

    /**
     * Get activation extras.
     * @return Activation extras.
     */
    public String getExtras() {
        return extras;
    }

    /**
     * Set activation extras.
     * @param extras Activation extras.
     */
    public void setExtras(String extras) {
        this.extras = extras;
    }
}