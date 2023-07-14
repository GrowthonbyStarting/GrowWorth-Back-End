package com.growworth.gotofpatent.storage;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
//	private String location = "C:/testimg";
	private String location = "/root/groworth-spring/upload-dir";
//	private String location = "src/main/resources/file";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
