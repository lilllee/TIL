package com.mockdata;

import com.main.People;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MockData {


    public static List<People> getPeople() throws IOException {
        InputStream inputStream = Resources.getResource("people.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type type = new TypeToken<ArrayList<People>>() {
        }.getType();
        return new Gson().fromJson(json, type);
    }
}
