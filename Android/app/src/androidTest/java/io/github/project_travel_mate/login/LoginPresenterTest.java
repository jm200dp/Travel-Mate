package io.github.project_travel_mate.login;

import android.os.Handler;
import android.os.Looper;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static org.junit.Assert.assertEquals;


public class LoginPresenterTest {

    @Test
    public void ok_login() throws IOException, InterruptedException {
        MockWebServer server = new MockWebServer();

        // Schedule some responses.

        // Start the server.
        server.start();

        // Ask the server for its URL. You'll need this to make HTTP requests.
        HttpUrl baseUrl = server.url("/sign-in");

        LoginPresenter loginPresenter = new LoginPresenter();
        Handler mHandler = new Handler(Looper.getMainLooper());
        server.enqueue(new MockResponse().setBody("first call"));
        loginPresenter.ok_login("janko.hrasko@tuke.sk", "p@sSw0rd", mHandler, baseUrl.toString());
        TimeUnit.SECONDS.sleep(5);
        server.enqueue(new MockResponse().setBody("second call"));
        loginPresenter.ok_login("janko.hrasko@tuke.sk", "p@sSw0rd", mHandler, baseUrl.toString());
        TimeUnit.SECONDS.sleep(5);
        server.enqueue(new MockResponse().setBody("third call"));
        loginPresenter.ok_login("janko.hrasko@tuke.sk", "p@sSw0rd", mHandler, baseUrl.toString());
        TimeUnit.SECONDS.sleep(5);
        System.out.println(loginPresenter.responses().toArray().toString());
        assertEquals("first call", loginPresenter.responses().get(0));
        assertEquals("second call", loginPresenter.responses().get(1));
        assertEquals("third call", loginPresenter.responses().get(2));

        server.shutdown();
    }
}