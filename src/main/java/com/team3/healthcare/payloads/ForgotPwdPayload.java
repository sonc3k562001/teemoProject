package com.team3.healthcare.payloads;

import java.io.Serializable;

public class ForgotPwdPayload implements Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 8551487877616925475L;

	private String username;

  public ForgotPwdPayload() {
  }

  public ForgotPwdPayload(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
