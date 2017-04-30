package lonsec.performance.exception;

public class FundProcessingException extends Exception {

	private static final long serialVersionUID = 1L;

	public FundProcessingException() {
		super();
	}

	public FundProcessingException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public FundProcessingException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FundProcessingException(String arg0) {
		super(arg0);
	}

	public FundProcessingException(Throwable arg0) {
		super(arg0);
	}

}
