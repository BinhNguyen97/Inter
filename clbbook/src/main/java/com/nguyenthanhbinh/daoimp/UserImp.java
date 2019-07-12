package com.nguyenthanhbinh.daoimp;

import com.nguyenthanhbinh.entity.User;

public interface UserImp {
	User KiemTraDangNhap(String username,String password);
	boolean AddUser(User user);

}
