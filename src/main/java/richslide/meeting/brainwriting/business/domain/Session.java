package richslide.meeting.brainwriting.business.domain;

import java.io.Serializable;

public class Session implements Serializable {

	private static final long serialVersionUID = 7959554794021511714L;
	
	private int sessionId;
	private String subject;
	private User master;
}
