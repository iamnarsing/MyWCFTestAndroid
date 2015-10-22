package com.utwo.mywcftestandroid.Services;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalDate;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by ammic on 2015/10/22.
 */
public class WCFTestService {

    private String Url;
    private String Contract;

    private final String NAMESPACE = "http://www.ammic.com";

    public WCFTestService(String url, String contract) {
        Url = url;
        Contract = contract;
    }

    public SoapObject Invoke(String methodName, ServiceParameter[] parameters, ServiceMapping[] mappings) {
        SoapObject soapRequest = new SoapObject(NAMESPACE, methodName);
        SoapObject result = null;

        if (parameters != null) {
            // The properties that will be passed as parameters
            PropertyInfo pi = new PropertyInfo();
            for (ServiceParameter param : parameters) {
                pi.setName(param.getName());
                pi.setValue(param.getValue());
                pi.setType(param.getType());
                // Assigning each property to the request
                soapRequest.addProperty(pi);
            }
        }

        // The envelop request
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.bodyOut = soapRequest;
        soapEnvelope.dotNet = true;
        soapEnvelope.setOutputSoapObject(soapRequest);

        if (mappings != null) {
            for (ServiceMapping mapping : mappings) {
                soapEnvelope.addMapping(NAMESPACE, mapping.Name, mapping.Class);
            }
        }

        //Marshal class.
        MarshalFloat marshalFloat = new MarshalFloat();
        marshalFloat.register(soapEnvelope);
        MarshalDate marshalDate = new MarshalDate();
        marshalDate.register(soapEnvelope);

        HttpTransportSE httpTransport = new HttpTransportSE(Url);
        httpTransport.debug = true;

        try {
            httpTransport.call(NAMESPACE + "/" + Contract + "/" + methodName, soapEnvelope);
            System.out.println("Call Successful!");

            result = (SoapObject)soapEnvelope.getResponse();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            System.out.println("XmlPullParserException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }

        return result;
    }
}
