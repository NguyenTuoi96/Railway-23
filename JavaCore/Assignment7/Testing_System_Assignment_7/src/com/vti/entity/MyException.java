package com.vti.entity;

public class MyException extends Exception {
	private String message;
	private Throwable reason;
	private StackTraceElement[] mStackTrace;
	private String time;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Throwable getReason() {
		return reason;
	}

	public void setReason(Throwable reason) {
		this.reason = reason;
	}

	public StackTraceElement[] getmStackTrace() {
		return mStackTrace;
	}

	public void setmStackTrace(StackTraceElement[] mStackTrace) {
		this.mStackTrace = mStackTrace;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "MyException [message=" + message + ", reason=" + reason + ", stackTrace=" + mStackTrace + ", time="
				+ time + "]";
	}

	public MyException(String message, Throwable reason, StackTraceElement[] mStackTrace, String time) {
		super();
		this.message = message;
		this.reason = reason;
		this.mStackTrace = mStackTrace;
		this.time = time;
	}
	
	
}
