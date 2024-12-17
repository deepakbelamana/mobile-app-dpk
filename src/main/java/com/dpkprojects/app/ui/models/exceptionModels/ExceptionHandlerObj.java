package com.dpkprojects.app.ui.models.exceptionModels;

import java.util.Date;

public class ExceptionHandlerObj {
    Date timeStamp;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public ExceptionHandlerObj(Date timeStamp, String message) {
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;
}
