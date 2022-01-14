package processor;

public enum AddressModes {
	//Accumulator 
	A,
	//Implied.
	I,
	//Immediate
	IM,
	//Absolute.
	AB,
	//Zero Page.
	ZP,
	//Relative.
	R,
	//Absolute indirect.
	AI,
	//Absolute indexed with X reg.
	AIX,
	//Absolute indexed with Y reg.
	AIY,
	//Zero paged indexed with X reg.
	ZPX,
	//Zero paged indexed with Y reg.
	ZPY,
	//Zero page inderect indexed with X reg.
	ZPIX,
	//Zero page inderect indexed with Y reg.
	ZPIY
}
