package cn.caregg.o2o.business.engine.parse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonParse implements ResponseParse {

	@Override
	public  <E> E paserObject(Object result, Class<E> clazz) {
		return new Gson().fromJson(result.toString(), clazz);
	}

	@Override
	public <E> E paserCollection(Object result, TypeToken<E> typeToken) {
		return new Gson().fromJson(result.toString(), typeToken.getType());
	}

	
}
