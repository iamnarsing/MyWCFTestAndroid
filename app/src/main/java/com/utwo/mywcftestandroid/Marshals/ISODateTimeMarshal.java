package com.utwo.mywcftestandroid.Marshals;

import org.kobjects.isodate.IsoDate;
import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.Date;

/**
 * Created by ammic on 2015/10/26.
 */
public class ISODateTimeMarshal implements Marshal{
    @Override
    public Object readInstance(XmlPullParser xmlPullParser, String s, String s1, PropertyInfo propertyInfo) throws IOException, XmlPullParserException {
        return IsoDate.stringToDate(xmlPullParser.nextText(), IsoDate.DATE_TIME);
    }

    @Override
    public void writeInstance(XmlSerializer xmlSerializer, Object o) throws IOException {
        xmlSerializer.text(IsoDate.dateToString((Date)o, IsoDate.DATE_TIME));
    }

    @Override
    public void register(SoapSerializationEnvelope soapSerializationEnvelope) {
        soapSerializationEnvelope.addMapping(soapSerializationEnvelope.xsd, "dateTime", Date.class, this);
    }
}
