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
package io.getlime.security.powerauth.rest.api.model.response.v2;

/**
 * Response object for the /pa/token endpoint, that enables fetching token for simple authentication.
 *
 * @author Petr Dvorak, petr@wultra.com
 */
public class TokenCreateResponse {

    private String mac;
    private String encryptedData;

    /**
     * Get MAC signature of the request.
     * @return MAC of the request.
     */
    public String getMac() {
        return mac;
    }

    /**
     * Set MAC signature of the request.
     * @param mac MAC of the request.
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * Get encrypted data payload.
     * @return Encrypted data.
     */
    public String getEncryptedData() {
        return encryptedData;
    }

    /**
     * Set encrypted data payload.
     * @param encryptedData Encrypted data.
     */
    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }
}
