package com.service;

import com.bean.People;

public interface ILoginService {
	People checkUserExist(int id, String pwd);
}
