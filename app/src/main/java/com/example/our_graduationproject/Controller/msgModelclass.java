//package com.av.avmessenger;
//
//public class msgModelclass {
//    String message;
//    String senderid;
//    long timeStamp;
//
//    public msgModelclass() {
//    }
//
//    public msgModelclass(String message, String senderid, long timeStamp) {
//        this.message = message;
//        this.senderid = senderid;
//        this.timeStamp = timeStamp;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getSenderid() {
//        return senderid;
//    }
//
//    public void setSenderid(String senderid) {
//        this.senderid = senderid;
//    }
//
//    public long getTimeStamp() {
//        return timeStamp;
//    }
//
//    public void setTimeStamp(long timeStamp) {
//        this.timeStamp = timeStamp;
//    }
//}


package com.example.our_graduationproject.Controller;

import java.io.File;
import java.io.Serializable;

public class msgModelclass  implements Serializable {
    int id ;
public String StringFile ;
    public int getId() {
        return id;
    }

    public String getStringFile() {
        return StringFile;
    }

    public void setStringFile(String stringFile) {
        StringFile = stringFile;
    }

    public void setId(int id) {
        this.id = id;
    }

    String message;
    int chat_room_id;
    String Date ;
 String urlFile="";

    String senderid;
    long timeStamp;
    File file;

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public msgModelclass(String message, int chat_room_id, String date, String senderid, long timeStamp) {
        this.message = message;
        this.chat_room_id = chat_room_id;
        Date = date;
        this.senderid = senderid;
        this.timeStamp = timeStamp;
    }

    public msgModelclass() {
    }
String url="" ;
    String fileName="" ;
    public msgModelclass(String message, String senderid, long timeStamp) {
        this.message = message;
        this.senderid = senderid;
        this.timeStamp = timeStamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getChat_room_id() {
        return chat_room_id;
    }

    public void setChat_room_id(int chat_room_id) {
        this.chat_room_id = chat_room_id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
