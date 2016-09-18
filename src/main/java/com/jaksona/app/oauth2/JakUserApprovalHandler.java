package com.jaksona.app.oauth2;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.ApprovalStoreUserApprovalHandler;

import java.util.Collection;

/**
 * @author jaksona
 */
public class JakUserApprovalHandler extends ApprovalStoreUserApprovalHandler {

	private boolean useApprovalStore = true;

	private ClientDetailsService clientDetailsService;

	@Override
	public void setClientDetailsService(ClientDetailsService clientDetailsService) {
		this.clientDetailsService = clientDetailsService;
		super.setClientDetailsService(clientDetailsService);
	}

	@Override
	public void setApprovalStore(ApprovalStore store) {
		super.setApprovalStore(store);
	}

	@Override
	public AuthorizationRequest checkForPreApproval(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {

		boolean approved = false;
		if(useApprovalStore) {
			authorizationRequest = super.checkForPreApproval(authorizationRequest, userAuthentication);
			approved = authorizationRequest.isApproved();
		}else {
			if(clientDetailsService != null) {
				Collection<String> requestedScope = authorizationRequest.getScope();
				try {
					ClientDetails client = clientDetailsService.loadClientByClientId(authorizationRequest.getClientId());
					for (String scope : requestedScope) {
						if(client.isAutoApprove(scope)) {
							approved = true;
							break;
						}
					}
				}catch (ClientRegistrationException e) {}
			}
		}
		authorizationRequest.setApproved(approved);
		return authorizationRequest;
	}

	public void setUseApprovalStore(boolean useApprovalStore) {
		this.useApprovalStore = useApprovalStore;
	}

}
