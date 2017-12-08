package ar.strellis.com.bgpsec.model;

public enum BgpNotificationType 
{
	MESSAGE_HEADER_ERROR(1),
	OPEN_MESSAGE_ERROR(2),
	UPDATE_MESSAGE_ERROR(3),
	HOLD_TIMER_EXPIRED(4),
	FINITE_STATE_MACHINE_ERROR(5),
	CEASE(6);
	private final int id;
	BgpNotificationType(int idNumber)
	{
		id=idNumber;
	}
	public int event_id()
	{
		return id;
	}
}
