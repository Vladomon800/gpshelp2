package com.example.gpshelp2.server;

import android.util.Log;

import java.io.IOException;
import java.net.Socket;

public class LaptopServer {
    private static final String LOG_TAG = "myServerApp"; // ip адрес сервера, который принимает соединения
    private Socket mSocket = null;

    public LaptopServer() {
    }

    public void openConnection() throws Exception {
        closeConnection();
        try {
            // номер порта, на который сервер принимает соединения
            String mServerName = "192.168.43.21";
            // сокет, через которий приложения общается с сервером
            int mServerPort = 1111;
            mSocket = new Socket(mServerName, mServerPort);
        } catch (IOException e) {
            throw new Exception("Невозможно создать сокет: " + e.getMessage());
        }
    }

    public void closeConnection() {
        if (mSocket != null && !mSocket.isClosed()) {
            try {
                mSocket.close();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Невозможно закрыть сокет: " + e.getMessage());
            } finally {
                mSocket = null;
            }
        }
        mSocket = null;
    }
    //функция отправления данных по сокету/////////////////////////////////////////
//переменная data - данные, которые отправляем/////////////////////////////////
    public void sendData(byte[] data) throws Exception{
        if(mSocket == null || mSocket.isClosed()){
            throw new Exception("Невозможно отправить данные. Сокет не создан или закрыт");
        }
        try {
//отправка данных
            mSocket.getOutputStream().write(data);
            mSocket.getOutputStream().flush();
        } catch (IOException e){
            throw new Exception("Невозможно отправить данные: " + e.getMessage());
        }
    }
    @Override
    protected void finalize() throws Throwable { super.finalize(); closeConnection(); }
}

