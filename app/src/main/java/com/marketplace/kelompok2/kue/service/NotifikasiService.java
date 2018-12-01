package com.marketplace.kelompok2.kue.service;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.marketplace.kelompok2.kue.common.UserState;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NotifikasiService {
    private static NotifikasiService instance = null;
    private final String AUTH_KEY =
            "key=AAAA7AQ_U7Q:APA91bFl16pk-HU5PYBL13uRu2M3UKJSUs5yFknBnk-V8cb3iIgWSsuPpod5EQeP2fjIZq1OumLv_GKIBynHl5g_mqo1J2vVoykxAOTd1WSnXBM2mF19CateYxCXHfGxdA1MxatHZRxR";

    private final String aocNumber = "1013683540916";
    private final String TAG = NotifikasiService.class.getSimpleName();
    private NotifikasiService(){
        init();
    }

    private void init(){

    }

    public static NotifikasiService getInstance(){
        if(instance == null){
            instance = new NotifikasiService();
        }
        return instance;
    }

    public void sendNotification(final boolean state,final String topic){
        new Thread(new Runnable() {
            @Override
            public void run() {
                pushNotification(state, topic);
            }
        }).start();
    }

    private boolean pushNotification(boolean state, String topic){
        JSONObject jPayload = new JSONObject();
        JSONObject jNotification = new JSONObject();
        JSONObject jData = new JSONObject();
        // String IID_TOKEN = FirebaseInstanceId.getInstance().getInstanceId().getResult().getToken();

        try{
            jNotification.put("idpembeli", UserState.getInstance().getIdUser().toString());
            jNotification.put("title", "Pesanan Baru");
            jNotification.put("body", "Anda Mendapat Pesanan dari " + UserState.getInstance().getPembeli().getUsername());
            jNotification.put("uang", "uang");
            jNotification.put("state", state);

            jData.put("body", "Anda Mendapat Pesanan dari " + UserState.getInstance().getPembeli().getUsername());
            jData.put("title", "Pesanan Baru");
            jPayload.put("to", "/topics/" + topic);
            jPayload.put("collapse_key", "type_a");
            jPayload.put("priority", "high");
            jPayload.put("notification", jNotification);
            jPayload.put("data", jData);

            URL url = new URL("https://fcm.googleapis.com/fcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", AUTH_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Send FCM message content.
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(jPayload.toString().getBytes());

            // Read FCM response.
            InputStream inputStream = conn.getInputStream();
            final String resp = convertStreamToString(inputStream);

            Handler h = new Handler(Looper.getMainLooper());
            h.post(new Runnable() {
                @Override
                public void run() {
                    Log.d(TAG + " DebugPushNotip : ",resp);
                }
            });

            return true;
        }
        catch (Exception e){
            Log.d(TAG + " errorpush", e.getMessage());
            return false;
        }

    }

    private String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next().replace(",", ",\n") : "";
    }
}
