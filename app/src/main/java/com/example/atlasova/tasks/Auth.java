package com.example.atlasova.tasks;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Handler;


import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;




public class Auth extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void authInApp(View v) throws IOException {
        System.out.println("yes");
        EditText login;
        EditText password;
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        String login_text = login.getText().toString();
        String pasword_text = password.getText().toString();
        //System.out.println(login_text);
        //System.out.println(pasword_text);

        /*OkHttpClient client = new OkHttpClient();
        String json = "{“name”:”Ivan”, “surname”:”Petrov”, “age”:”40”}";
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("http://tasks/auth/checkUserAndroid")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();*/

        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Ураа");
                OkHttpClient client = new OkHttpClient();
                String json = "{“name”:”Ivan”, “surname”:”Petrov”, “age”:”40”}";
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
                Request request = new Request.Builder()
                        .url("http://new.buket116.ru//auth/checkUserAndroid")
                        .post(body)
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    System.out.println(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        //System.out.println(response);
        Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show();
    }


}
