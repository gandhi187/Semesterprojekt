package com.mycompany.app;

import com.microsoft.azure.iot.service.exceptions.IotHubException;
import com.microsoft.azure.iot.service.sdk.Device;
import com.microsoft.azure.iot.service.sdk.RegistryManager;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 
 *
 */

public class App {

	private static final String connectionString = "HostName=OPCUATesthub.azure-devices.net;SharedAccessKeyName=iothubowner;SharedAccessKey=aJekQrjDn2IleexfHWsn0lXywt9qZKBnnGhLttaMm4U=";
	private static final String deviceId = "myFirstJavaDevice";

	public static void main(String[] args) throws IOException, URISyntaxException, Exception {

		RegistryManager registryManager = RegistryManager.createFromConnectionString(connectionString);

		Device device = Device.createFromId(deviceId, null, null);
		try {
			device = registryManager.addDevice(device);
		} catch (IotHubException iote) {
			try {
				device = registryManager.getDevice(deviceId);
			} catch (IotHubException iotf) {
				iotf.printStackTrace();
			}
		}
		System.out.println("Device id: " + device.getDeviceId());
		System.out.println("Device key: " + device.getPrimaryKey());
	}
}
