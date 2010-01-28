package gov.hhs.fha.nhinc.policyengine.adapterpep.proxy;

import gov.hhs.fha.nhinc.common.nhinccommonadapter.CheckPolicyResponseType;
import gov.hhs.fha.nhinc.common.nhinccommonadapter.CheckPolicyRequestType;
import oasis.names.tc.xacml._2_0.context.schema.os.DecisionType;
import oasis.names.tc.xacml._2_0.context.schema.os.ResponseType;
import oasis.names.tc.xacml._2_0.context.schema.os.ResultType;

/**
 * This is a "NoOp" implementation of the AdapterPEPProxy interface.
 */
public class AdapterPEPProxyDenyNoOpImpl implements AdapterPEPProxy {

    /**
     * NO-OP implementation of the checkPolicy operation returns "Deny"
     *
     * @param checkPolicyRequest The xacml request to check defined policy
     * @return The xacml response which contains the access denied
     */
    public CheckPolicyResponseType checkPolicy(CheckPolicyRequestType checkPolicyRequest) {
        CheckPolicyResponseType denyPolicyResponse = new CheckPolicyResponseType();
        ResponseType denyResponse = new ResponseType();
        ResultType result = new ResultType();
        result.setDecision(DecisionType.DENY);
        denyResponse.getResult().add(result);
        denyPolicyResponse.setResponse(denyResponse);
        return denyPolicyResponse;
    }
}
