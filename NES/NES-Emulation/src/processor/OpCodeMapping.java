package processor;

abstract class OpCodeMapping {
	OpCodes opMap[];
	AddressModes modeMap[];
	
	OpCodeMapping() {
		mapOps();
		mapModes();
	}

	private void mapOps() {
		opMap = new OpCodes[0x100];
		
		//LOAD AND STORE-------------------
		opMap[0xAD] = opMap[0xBD] = 
		opMap[0xB9] = opMap[0xA9] = 
		opMap[0xA5] = opMap[0xA1] = 
		opMap[0xB5] = opMap[0xB1] = OpCodes.LDA;

		opMap[0xAE] = opMap[0xBE] = 
		opMap[0xA2] = opMap[0xA6] = 
		opMap[0xB6] = OpCodes.LDX;

		opMap[0xAC] = opMap[0xBC] = 
		opMap[0xA0] = opMap[0xA4] = 
		opMap[0xB4] = OpCodes.LDY;

		opMap[0x8D] = opMap[0x9D] =
		opMap[0x99] = opMap[0x85] = 
		opMap[0x8] = opMap[0x95] = 
		opMap[0x91] = OpCodes.STA;

		opMap[0x8E] = opMap[0x86] = 
		opMap[0x96] = OpCodes.STX;

		opMap[0x8C] = opMap[0x84] = 
		opMap[0x94] = OpCodes.STY;

		//ARITHMATIC-----------------------
		opMap[0x6D] = opMap[0x65] =
		opMap[0x7D] = opMap[0x61] = 
		opMap[0x79] = opMap[0x75] = 
		opMap[0x69] = opMap[0x71] = OpCodes.ADC;

		opMap[0xED] = opMap[0xE5] =
		opMap[0xFD] = opMap[0xE1] = 
		opMap[0xF9] = opMap[0xF5] = 
		opMap[0xE9] = opMap[0xF1] = OpCodes.SBC;

		//INCREMENT AND DECREMENT----------
		opMap[0xEE] = opMap[0xFE] =
		opMap[0xE6] = opMap[0xF6] = OpCodes.INC;

		opMap[0xE8] = OpCodes.INX;

		opMap[0xC8] = OpCodes.INY;

		opMap[0xCE] = opMap[0xDE] =
		opMap[0xC6] = opMap[0xD6] = OpCodes.DEC;

		opMap[0xCA] = OpCodes.DEX;

		opMap[0x88] = OpCodes.DEY;

		//SHIFT AND ROTATE-----------------
		opMap[0x0E] = opMap[0x06] = 
		opMap[0x1E] = opMap[0x16] = 
		opMap[0x0A] = OpCodes.ASL;

		opMap[0x4E] = opMap[0x46] = 
		opMap[0x5E] = opMap[0x56] = 
		opMap[0x4A] = OpCodes.LSR;

		opMap[0x2E] = opMap[0x26] = 
		opMap[0x3E] = opMap[0x36] = 
		opMap[0x2A] = OpCodes.ROL;

		opMap[0x6E] = opMap[0x66] = 
		opMap[0x7E] = opMap[0x76] = 
		opMap[0x6A] = OpCodes.ROR;

		//LOGIC----------------------------
		opMap[0x2D] = opMap[0x25] =
		opMap[0x3D] = opMap[0x21] = 
		opMap[0x39] = opMap[0x35] = 
		opMap[0x29] = opMap[0x31] = OpCodes.AND;

		opMap[0x0D] = opMap[0x05] =
		opMap[0x1D] = opMap[0x01] = 
		opMap[0x19] = opMap[0x15] = 
		opMap[0x09] = opMap[0x11] = OpCodes.ORA;

		opMap[0x4D] = opMap[0x45] =
		opMap[0x5D] = opMap[0x41] = 
		opMap[0x59] = opMap[0x55] = 
		opMap[0x49] = opMap[0x51] = OpCodes.EOR;

		//COMPARE AND TEST BIT-------------
		opMap[0xCD] = opMap[0xC5] =
		opMap[0xDD] = opMap[0xC1] = 
		opMap[0xD9] = opMap[0xD5] = 
		opMap[0xC9] = opMap[0xD1] = OpCodes.CMP;

		opMap[0xEC] = opMap[0xE4] = 
		opMap[0xE0] = OpCodes.CPX;

		opMap[0xCC] = opMap[0xC4] = 
		opMap[0xC0] = OpCodes.CPY;

		opMap[0x2C] = opMap[0x24] = 
		opMap[0x89] = OpCodes.BIT;

		//BRANCH---------------------------
		opMap[0x90] = OpCodes.BCC;

		opMap[0xB0] = OpCodes.BCS;

		opMap[0xD0] = OpCodes.BNE;

		opMap[0xF0] = OpCodes.BEQ;

		opMap[0x10] = OpCodes.BPL;

		opMap[0x30] = OpCodes.BMI;

		opMap[0x50] = OpCodes.BVC;

		opMap[0x70] = OpCodes.BVS;

		//TRANSFER-------------------------
		opMap[0xAA] = OpCodes.TAX;
		
		opMap[0x8A] = OpCodes.TXA;

		opMap[0xA8] = OpCodes.TAY;

		opMap[0x98] = OpCodes.TYA;

		opMap[0xBA] = OpCodes.TSX;

		opMap[0x9A] = OpCodes.TXS;

		//STACK----------------------------
		opMap[0x48] = OpCodes.PHA;

		opMap[0x68] = OpCodes.PLA;

		opMap[0x08] = OpCodes.PHP;

		opMap[0x28] = OpCodes.PLP;
		
		//SUBROUTINES AND JUMP-------------
		opMap[0x4C] = opMap[0x6C] = OpCodes.JMP;

		opMap[0x20] = OpCodes.JSR;

		opMap[0x60] = OpCodes.RTS;

		opMap[0x40] = OpCodes.RTI;

		//SET AND CLEAR--------------------
		opMap[0x18] = OpCodes.CLC;

		opMap[0x38] = OpCodes.SEC;

		opMap[0xD8] = OpCodes.CLD;

		opMap[0xF8] = OpCodes.SED;

		opMap[0x58] = OpCodes.CLI;
		
		opMap[0x78] = OpCodes.SEI;
		
		opMap[0xB8] = OpCodes.CLV;
		
		opMap[0x00] = OpCodes.BRK;
		
		opMap[0xEA] = OpCodes.NOP;
		
		for (short i = 0x0; i < 0x100; i+=0x10) {
			for (short y = 0x0; y < 0x10; y++) {
				if (opMap[i + y] != null) {
					System.out.print(Integer.toString(i + y, 16) + ": " + opMap[i + y] + "   ");
				} else {
					System.out.print("          ");
				}

			}
			System.out.print("\n");
		}
		
	}
	
	private void mapModes() {
		modeMap = new AddressModes[0x100];
		
		//LOW NIBBLE 0x0
		modeMap[0x00] = AddressModes.I;
		modeMap[0x10] = AddressModes.R;
		for (int i = 0x20; i <= 0x70; i+=0x10) {
			if (i % 2 == 0) {
				modeMap[i] = AddressModes.I;
			} else {
				modeMap[i] = AddressModes.R;
			}
		}
		for (int i = 0x90; i <= 0xF0; i+=0x10) {
			if (i % 2 == 0) {
				modeMap[i] = AddressModes.IM;
			} else {
				modeMap[i] = AddressModes.R;
			}
		}
		
		//LOW NIBBLE 0x1
		for (int i = 0x0; i <= 0xF0; i+=0x10) {
			if (i % 2 == 0) {
				modeMap[i + 0x1] = AddressModes.ZPIX;
			} else {
				modeMap[i + 0x1] = AddressModes.ZPIY;
			}
		}
		
		//LOW NIBBLE 0x2
		modeMap[0xA2] = AddressModes.IM;
		
		//LOW NIBBLE 0x3 NOT USED
		
		//LOW NIBBLE 0x4
		modeMap[0x24] = AddressModes.ZP;
		for (int i = 0x0; i <= 0xf0; i+=0x10) {
			if (i % 2 == 0) {
				modeMap[i + 0x4] = AddressModes.ZP;
			} else {
				modeMap[i + 0x4] = AddressModes.ZPX;
			}
		}
		modeMap[0x24] = AddressModes.ZP;
		
		//LOW NIBBLE 0X5 && 0x6
		for (int x = 0x0; x <= 0x1; x++) {
			for (int i = 0x0; i <= 0xf0; i+=0x10) {
				if (i % 2 == 0) {
					modeMap[i + 0x5 + x] = AddressModes.ZP;
				} else {
					modeMap[i + 0x5 + x] = AddressModes.ZPX;
				}
			}
		}
		
		//LOW NIBBLE 0x7 NOT USED
		
		//LOW NIBBLE 0x8
		for (int i = 0x0; i <= 0xf0; i+=0x10) {
			modeMap[i + 0x8] = AddressModes.I;
		}
		
		//LOW NIBBLE 0x9
		for (int i = 0x0; i <= 0xf0; i+=0x10) {
			if (opMap[i + 0x9] == null) continue;
			if (i % 2 == 0) {
				modeMap[i + 0x9] = AddressModes.IM;
			} else {
				modeMap[i + 0x9] = AddressModes.AIY;
			}
		}
		
		//LOW NIBBLE 0XA
		for (int i = 0x0; i <= 0xf0; i+=0x10) {
			if (opMap[i + 0xA] == null) continue;
			if (i < 0x7) {
				modeMap[i + 0xA] = AddressModes.A;
			} else {
				modeMap[i + 0xA] = AddressModes.I;
			}
		}
		
		//LOW NIBBLE 0xB NOT USED
		
		//LOW NIBBLE 0xC
		for (int i = 0x20; i <= 0xE0; i+=0x10) {
			if (opMap[i + 0xC] == null) continue;
			modeMap[i + 0xC] = AddressModes.AB;
		}
		modeMap[0x6C] = AddressModes.AI;
		modeMap[0xBC] = AddressModes.AIX;
		
		//LOW NIBBLE 0xD && 0xE
		for (int x = 0x0; x <= 0x1; x++) {
			for (int i = 0x0; i <= 0xf0; i+=0x10) {
				if (opMap[i + 0xD + x] == null) continue;
				if (i % 2 == 0) {
					modeMap[i + 0xD + x] = AddressModes.AB;
				} else {
					modeMap[i + 0xD + x] = AddressModes.AIX;
				}
			}
		}
		
		//LOW NIBBLE 0xF NOT USED
	}
}


