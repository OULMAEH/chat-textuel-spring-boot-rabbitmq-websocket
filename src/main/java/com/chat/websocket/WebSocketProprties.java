package com.chat.websocket;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
public class WebSocketProprties {
	
	private String relayHost = "localhost";
	
	private int relayPort = 61613;
	
	private String clientLogin = "guest";
	
	private String passcode = "guest";

	/**
	 * @param relayHost
	 * @param relayPort
	 * @param clientLogin
	 * @param passcode
	 */
	public WebSocketProprties(String relayHost, int relayPort, String clientLogin, String passcode) {
		super();
		this.relayHost = relayHost;
		this.relayPort = relayPort;
		this.clientLogin = clientLogin;
		this.passcode = passcode;
	}

	/**
	 * 
	 */
	public WebSocketProprties() {
		super();
	}

	/**
	 * @return the relayHost
	 */
	public String getRelayHost() {
		return relayHost;
	}

	/**
	 * @param relayHost the relayHost to set
	 */
	public void setRelayHost(String relayHost) {
		this.relayHost = relayHost;
	}

	/**
	 * @return the relayPort
	 */
	public int getRelayPort() {
		return relayPort;
	}

	/**
	 * @param relayPort the relayPort to set
	 */
	public void setRelayPort(int relayPort) {
		this.relayPort = relayPort;
	}

	/**
	 * @return the clientLogin
	 */
	public String getClientLogin() {
		return clientLogin;
	}

	/**
	 * @param clientLogin the clientLogin to set
	 */
	public void setClientLogin(String clientLogin) {
		this.clientLogin = clientLogin;
	}

	/**
	 * @return the passcode
	 */
	public String getPasscode() {
		return passcode;
	}

	/**
	 * @param passcode the passcode to set
	 */
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	@Override
	public String toString() {
		return "WebSocketProprties [relayHost=" + relayHost + ", relayPort=" + relayPort + ", clientLogin="
				+ clientLogin + ", passcode=" + passcode + "]";
	}

	
}
