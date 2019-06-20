package com.pkfcooperparry.template.ui.main;

import android.content.Context;
import android.databinding.ObservableBoolean;

import com.google.gson.Gson;
import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.data.model.db.visit.Form;
import com.pkfcooperparry.template.data.model.db.visit.FormList;
import com.pkfcooperparry.template.ui.base.BaseViewModel;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class MainViewModel extends BaseViewModel<MainViewInterface> {
    @Getter
    @Setter
    ObservableBoolean itemsExist = new ObservableBoolean();

    MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        itemsExist.set(false);
    }

    @Override
    public void setViewInterface(Context context, MainViewInterface navigator) {
        super.setViewInterface(context, navigator);
        saveData();

    }

    public void saveData() {
        String jsonString = getAssetsJSON();
        Gson gson = new Gson();
        FormList page = gson.fromJson(jsonString, FormList.class);
        getDataManager().addForms(page.getForms());
    }

    /* Get File in Assets Folder */
    public String getAssetsJSON() {
        String json = null;
        try {
            InputStream inputStream = getContext().getAssets().open("example_json.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    public List<Form> getForms() {
        List<Form> forms = getDataManager().getForms();
        if (forms != null) {
            itemsExist.set(true);
        }
        return forms;
    }
}
