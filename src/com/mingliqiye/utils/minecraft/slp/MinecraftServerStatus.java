package com.mingliqiye.utils.minecraft.slp;

import lombok.Data;

@Data
public class MinecraftServerStatus {

	private Description description;
	private Players players;
	private Version version;
	private String favicon;
	private boolean enforcesSecureChat;
	private boolean previewsChat;
	private String jsonData;
}
