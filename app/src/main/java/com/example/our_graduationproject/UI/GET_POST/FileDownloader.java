package com.example.our_graduationproject.UI.GET_POST;

//import android.content.Context;
//import android.os.Environment;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//import android.content.Context;
//import android.os.Environment;
//
//import com.android.volley.NetworkResponse;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.HttpHeaderParser;
//import com.android.volley.toolbox.Volley;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//public class FileDownloader {
//
//    public interface DownloadListener {
//        void onDownloadComplete(File file);
//
//        void onDownloadError(VolleyError error);
//    }
//
//    public static void downloadFile(Context context, String fileUrl, final DownloadListener listener) {
//        RequestQueue requestQueue = Volley.newRequestQueue(context);
//        InputStreamRequest inputStreamRequest = new InputStreamRequest(Request.Method.GET, fileUrl,
//                new Response.Listener<InputStream>() {
//                    @Override
//                    public void onResponse(InputStream response) {
//                        try {
//                            String fileName = getFileNameFromUrl(fileUrl);
//                            File downloadDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//                            File outputFile = new File(downloadDirectory, fileName);
//
//                            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
//                            byte[] buffer = new byte[4096];
//                            int bytesRead;
//                            while ((bytesRead = response.read(buffer)) != -1) {
//                                fileOutputStream.write(buffer, 0, bytesRead);
//                            }
//                            fileOutputStream.close();
//
//                            listener.onDownloadComplete(outputFile);
//                        } catch (IOException e) {
//                            listener.onDownloadError(new VolleyError(e));
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        listener.onDownloadError(error);
//                    }
//                });
//
//        requestQueue.add(inputStreamRequest);
//    }
//
//    private static String getFileNameFromUrl(String url) {
//        String[] segments = url.split("/");
//        return segments[segments.length - 1];
//    }
//
//    private static class InputStreamRequest extends Request<InputStream> {
//        private final Response.Listener<InputStream> mListener;
//
//        public InputStreamRequest(int method, String url, Response.Listener<InputStream> listener,
//                                  Response.ErrorListener errorListener) {
//            super(method, url, errorListener);
//            mListener = listener;
//        }
//
//        @Override
//        protected Response<InputStream> parseNetworkResponse(NetworkResponse response) {
//            try {
//                byte[] data = response.data;
//                ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
//                return Response.success(inputStream, HttpHeaderParser.parseCacheHeaders(response));
//            } catch (Exception e) {
//                return Response.error(new VolleyError(e));
//            }
//        }
//        @Override
//        protected void deliverResponse(InputStream response) {
//            mListener.onResponse(response);
//        }
//    }
//}
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.Volley;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileDownloader {

    public interface DownloadListener {
        void onDownloadComplete(File file);

        void onDownloadError(VolleyError error);
    }

    public static void downloadFile(Context context, String fileUrl, final DownloadListener listener) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        InputStreamRequest inputStreamRequest = new InputStreamRequest(Request.Method.GET, fileUrl,
                new Response.Listener<InputStream>() {
                    @Override
                    public void onResponse(InputStream response) {
                        try {
                            String fileName = getFileNameFromUrl(fileUrl);
                            File downloadDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                            File outputFile = new File(downloadDirectory, fileName);

                            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
                            byte[] buffer = new byte[4096];
                            int bytesRead;
                            while ((bytesRead = response.read(buffer)) != -1) {
                                fileOutputStream.write(buffer, 0, bytesRead);
                            }
                            fileOutputStream.close();

                            listener.onDownloadComplete(outputFile);
                        } catch (IOException e) {
                            listener.onDownloadError(new VolleyError(e));
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onDownloadError(error);
                    }
                });

        requestQueue.add(inputStreamRequest);
    }

    private static String getFileNameFromUrl(String url) {
        String[] segments = url.split("/");
        return segments[segments.length - 1];
    }

    private static class InputStreamRequest extends Request<InputStream> {
        private final Response.Listener<InputStream> mListener;

        public InputStreamRequest(int method, String url, Response.Listener<InputStream> listener,
                                  Response.ErrorListener errorListener) {
            super(method, url, errorListener);
            mListener = listener;
        }

        @Override
        protected Response<InputStream> parseNetworkResponse(NetworkResponse response) {
            try {
                byte[] data = response.data;
                ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
                return Response.success(inputStream, HttpHeaderParser.parseCacheHeaders(response));
            } catch (Exception e) {
                return Response.error(new VolleyError(e));
            }
        }

        @Override
        protected void deliverResponse(InputStream response) {
            mListener.onResponse(response);
        }
    }
}