package net.atec.analyzer;

import net.atec.sender.DeviceEvent;

public class Analizer {
	public Analizer(){
		
	}
	
	public String getDeviceEventFormat(){
		String ret = null;
			
		return ret;
	}
	
	public DeviceEvent getDeviceEvent(){
		ServiceCenter.copyEventType();
		DeviceEvent de = ServiceCenter.getDeviceEvent("/sdcard/tmp");
		return de;
	}
	
	
	
}
