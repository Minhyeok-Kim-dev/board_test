package com.edgc.login.model.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserInfo {
	private String userid;
	private String passwd;
	private String usernm;
	private String company;
	private String type;
	private LocalDateTime regdt;
	private String regid;
	private LocalDateTime updt;
	private String upid;
}
