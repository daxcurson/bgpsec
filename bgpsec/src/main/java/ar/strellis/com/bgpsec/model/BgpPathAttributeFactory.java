package ar.strellis.com.bgpsec.model;

public class BgpPathAttributeFactory 
{
	public static BgpPathAttribute returnPathAttribute(BgpAttributeTypeCode code)
	{
		BgpPathAttribute att=null;
		switch(code)
		{
		case AS_PATH:
			att=new BgpPathAttributeAsPath();
			break;
		case AGGREGATOR:
			att=new BgpPathAttributeAggregator();
			break;
		case ATOMIC_AGGREGATE:
			att=new BgpPathAttributeAtomicAggregate();
			break;
		case LOCAL_PREF:
			att=new BgpPathAttributeLocalPref();
			break;
		case MULTI_EXIT_DISC:
			att=new BgpPathAttributeMultiExitDisc();
			break;
		case NEXT_HOP:
			att=new BgpPathAttributeNextHop();
			break;
		case ORIGIN:
			att=new BgpPathAttributeOrigin();
			break;
		default:
			break;
		}
		return att;
	}
}
