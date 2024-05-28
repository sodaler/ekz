package com.example.examtest;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlParser {
    public static String Serialize() throws IllegalArgumentException, IllegalStateException, IOException
    {
        DbList db = DbList.getInstance();

        XmlSerializer xmlSerializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();

        xmlSerializer.setOutput(writer);

        xmlSerializer.startDocument("UTF-8", true);
        xmlSerializer.startTag("", "file");

        xmlSerializer.startTag("", "Patients");

        for (Patient p : db.getAll()) {
            xmlSerializer.startTag("", "Patient");

            xmlSerializer.startTag("", "Name");
            xmlSerializer.text(p.name);
            xmlSerializer.endTag("", "Name");
            xmlSerializer.startTag("", "Age");
            xmlSerializer.text(String.valueOf(p.age));
            xmlSerializer.endTag("", "Age");

            xmlSerializer.endTag("", "Patient");
        }

        xmlSerializer.endTag("", "Patients");

        xmlSerializer.endTag("", "file");
        xmlSerializer.endDocument();

        return writer.toString();
    }

    public static void Deserialize(String data) throws XmlPullParserException, IOException {
        DbList db = DbList.getInstance();

        db.clearAll();

        XmlPullParser parser = Xml.newPullParser();
        StringReader reader = new StringReader(data);

        parser.setInput(reader);

        while (parser.getEventType()!= XmlPullParser.END_DOCUMENT) {
            if (parser.getEventType() == XmlPullParser.START_TAG
                    && parser.getName().equals("Patient")) {
                String name = "";
                int age = 0;
                parser.next();
                while (parser.getEventType() != XmlPullParser.END_TAG
                && !parser.getName().equals("Patient")) {
                    if (parser.getEventType() == XmlPullParser.START_TAG
                    && parser.getName().equals("Name")) {
                        while (parser.getEventType() != XmlPullParser.TEXT)
                            parser.next();
                        name = parser.getText();
                    }

                    if (parser.getEventType() == XmlPullParser.START_TAG
                            && parser.getName().equals("Age")) {
                        while (parser.getEventType() != XmlPullParser.TEXT)
                            parser.next();
                        age = Integer.parseInt(parser.getText());
                    }

                    parser.next();
                }

                db.addPatient(new Patient(name, age));
            }
            parser.next();
        }
    }
}
