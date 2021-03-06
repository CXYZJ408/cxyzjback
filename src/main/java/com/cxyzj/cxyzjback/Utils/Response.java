package com.cxyzj.cxyzjback.Utils;

import com.cxyzj.cxyzjback.Data.Data;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wanyu
 * @Date: 2018-01-18
 * @Time: 19:09
 * To change this template use File | Settings | File Templates.
 * @desc 响应请求
 */
@Slf4j
public class Response {
    private HashMap<String, Object> data = new HashMap<>();//数据是map型
    private HashMap<String, Object> response = new HashMap<>();//响应

    public void insert(Data data) {//插入单个对象数据
        insert(data.getName(), data);
    }

    /**
     * @param key   要发送的信息的键值
     * @param value
     */
    public void insert(String key, Object value) {//插入单条数据
        data.put(key, value);
    }

    /**
     * @param objs 要发送的对象数组
     */
    public void insert(Data[] objs) {//插入多个对象数据
        ArrayList<Object> tmp = new ArrayList<>(Arrays.asList(objs));
        data.put(objs[0].getName(), tmp);
    }

    public void insert(List<Data>[] objs) {//插入多个对象数据
        ArrayList<Object> tmp = new ArrayList<>(Arrays.asList(objs));
        data.put(objs[0].get(0).getName(), tmp);
    }

    /**
     * @return 将要发送的信息转为json格式并返回
     */
    public String sendSuccess() {
        response.clear();//清空，防止缓存
        response.put("status", Status.SUCCESS);
        response.put("data", data);
        return new Gson().toJson(response, HashMap.class);//格式转换
    }

    /**
     * @param code       错误代码
     * @param statusInfo 错误信息
     * @return 错误json信息
     */
    public String sendFailure(int code, String statusInfo) {
        response.clear();//清空，防止缓存
        response.put("status", code);
        response.put("statusInfo", statusInfo);
        return new Gson().toJson(response, HashMap.class);//格式转换
    }
}

