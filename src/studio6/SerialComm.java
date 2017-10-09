package studio6;

import jssc.*;

public class SerialComm {

	SerialPort port;

	private boolean debug; // Indicator of "debugging mode"

	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

		debug = false; // Default is to NOT be in debug mode
	}

	// TODO: Add writeByte() method from Studio 5
	void writeByte(byte sendByte) {

		try {
			port.writeByte(sendByte);

		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (debug == true) {

			try {
				port.writeByte(sendByte);
			} catch (SerialPortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String typingByte = String.format("%02x", sendByte); // converts our typer byte to hex
			System.out.println("0x" + typingByte); // print to java console

		}

	}

	// TODO: Add available() method
	
	boolean  available() {
		try {
			if(port.getInputBufferBytesCount() >0)
			{
				return true;
			}
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	// TODO: Add readByte() method
	
		
//	int readBytes(){
//		
//		int byteCount = new int[2];
//		try {
//			port.readBytes(byteCount);
//		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byteCount;
		
	}

	// TODO: Add a main() method

	public static void main(String[] args) {

	}
}
