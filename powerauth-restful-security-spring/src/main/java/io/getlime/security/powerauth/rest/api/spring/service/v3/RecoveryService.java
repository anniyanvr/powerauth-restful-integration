/*
 * PowerAuth integration libraries for RESTful API applications, examples and
 * related software components
 *
 * Copyright (C) 2019 Wultra s.r.o.
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
package io.getlime.security.powerauth.rest.api.spring.service.v3;

import io.getlime.powerauth.soap.v3.ConfirmRecoveryCodeResponse;
import io.getlime.security.powerauth.rest.api.base.encryption.EciesEncryptionContext;
import io.getlime.security.powerauth.rest.api.base.exception.PowerAuthRecoveryException;
import io.getlime.security.powerauth.rest.api.model.request.v3.EciesEncryptedRequest;
import io.getlime.security.powerauth.rest.api.model.response.v3.EciesEncryptedResponse;
import io.getlime.security.powerauth.soap.spring.client.PowerAuthServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementing recovery functionality.
 *
 * <p><b>PowerAuth protocol versions:</b>
 * <ul>
 *     <li>3.0</li>
 * </ul>
 *
 * @author Roman Strobl, roman.strobl@wultra.com
 */
@Service
public class RecoveryService {

    private static final Logger logger = LoggerFactory.getLogger(RecoveryService.class);

    private final PowerAuthServiceClient powerAuthClient;

    /**
     * Controller constructor.
     * @param powerAuthClient PowerAuth client.
     */
    @Autowired
    public RecoveryService(PowerAuthServiceClient powerAuthClient) {
        this.powerAuthClient = powerAuthClient;
    }

    /**
     * Confirm recovery code.
     * @param request Ecies encrypted request.
     * @param eciesContext Ecies encryption context.
     * @return Ecies encrypted response.
     * @throws PowerAuthRecoveryException In case confirm recovery fails.
     */
    public EciesEncryptedResponse confirmRecoveryCode(EciesEncryptedRequest request,
                                                      EciesEncryptionContext eciesContext) throws PowerAuthRecoveryException {
        try {
            String activationId = eciesContext.getActivationId();
            String applicationKey = eciesContext.getApplicationKey();
            if (activationId == null || applicationKey == null || request.getEphemeralPublicKey() == null
                    || request.getEncryptedData() == null || request.getMac() == null) {
                logger.error("PowerAuth confirm recovery failed because of invalid request");
                throw new PowerAuthRecoveryException();
            }
            ConfirmRecoveryCodeResponse paResponse = powerAuthClient.confirmRecoveryCode(activationId, applicationKey,
                    request.getEphemeralPublicKey(), request.getEncryptedData(), request.getMac());
            if (!paResponse.getActivationId().equals(activationId)) {
                logger.error("PowerAuth confirm recovery failed because of invalid activation ID in response");
                throw new PowerAuthRecoveryException();
            }
            return new EciesEncryptedResponse(paResponse.getEncryptedData(), paResponse.getMac());
        } catch (Exception ex) {
            logger.warn("PowerAuth confirm recovery failed", ex);
            throw new PowerAuthRecoveryException();
        }
    }
}
