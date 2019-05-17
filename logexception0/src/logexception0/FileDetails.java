package logexception1;

class FileDetails {
	long lastModifiedline;
	long lastModifiedStackTrace;
	long lastModifiedcount;
	String line;
	String stacktrace;
	int count;
	
	FileDetails(){
		 lastModifiedline=-1;
		 lastModifiedStackTrace=-1;
		 lastModifiedcount=-1;
		 count=-1;
	}

	public long getLastModifiedline() {
		return lastModifiedline;
	}

	public void setLastModifiedline(long lastModifiedline) {
		this.lastModifiedline = lastModifiedline;
	}

	public long getLastModifiedStackTrace() {
		return lastModifiedStackTrace;
	}

	public void setLastModifiedStackTrace(long lastModifiedStackTrace) {
		this.lastModifiedStackTrace = lastModifiedStackTrace;
	}

	public long getLastModifiedcount() {
		return lastModifiedcount;
	}

	public void setLastModifiedcount(long lastModifiedcount) {
		this.lastModifiedcount = lastModifiedcount;
	}

	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getStacktrace() {
		return stacktrace;
	}
	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
