package uk.co.ElmHoe.Utilities;

public class MessageUtility {
	
	
	public enum Responses{
		INVALID_VOLUME("Invalid Volume Level. \n" + "Only 100 < & > 0 is accepted."),
		INVALID_INT("The value you've submitted is not a valid integer."),
		INVALID_INT_VOLUME("The volume level you've submitted is not a valid integer."),
		CMD_PLAY("PLAY"),
		CMD_PAUSE("PAUSE"),
		CMD_STOP("STOP"),
		CMD_SHUFFLE("SHUFFLE"),
		CMD_VOLUME("VOLUME"),
		CMD_REPEAT("REPEAT"),
		CMD_BACK("BACK")
		;
		
		private final String response;
        
        private Responses(String response) {
            this.response = response;
        }

        public String toString() {
            return response;
        }

	}

	
}
