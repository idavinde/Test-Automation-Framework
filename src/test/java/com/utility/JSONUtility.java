package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.constant.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {

	public static Environment readJSON(Env env) {
		Gson gson = new Gson();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/config.json");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		

		Config config = gson.fromJson(inputStreamReader, Config.class);
		Environment enviroment = config.getEnvironment().get(env.name());
		return enviroment;

	}

}
