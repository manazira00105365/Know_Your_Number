package com.example.example;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Num7Activity extends AppCompatActivity {

    String url = "https://www.the-horoscope.com/general-horoscope";
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num7);
        new Num7Activity.Descrip().execute();
    }

    private class Descrip extends AsyncTask<Void, Void, Void> {
        String date;
        String desc;
        String desc2;
        String desc3;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(Num7Activity.this);
            mProgressDialog.setTitle("Hold on a sec!! its loading . . .");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect(url).get();
                Elements dateToday = document
                        .select("body > div.container > div.wrapper > div.gray_back > div.content > div.wrap2 > h4");
                Elements description = document
                        .select("body > div.container > div.wrapper > div.gray_back > div.content > div.wrap2 > p:nth-child(12)");
                Elements description2 = document
                        .select("body > div.container > div.wrapper > div.gray_back > div.content > div.wrap2 > p:nth-child(15)");
                Elements description3 = document
                        .select("body > div.container > div.wrapper > div.gray_back > div.content > div.wrap2 > p:nth-child(16)");
                //select("meta[name=description]");
                //select("div[class=wrap2]").select("p")
                // Locate the content attribute
                date = String.valueOf(dateToday.text());
                desc = String.valueOf(description.text());//
                desc2 = String.valueOf(description2.text());
                desc3 = String.valueOf(description3.text());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            TextView textView_date = (TextView) findViewById(R.id.textView_date);
            TextView textView_contents = (TextView) findViewById(R.id.textView_contents);
            TextView textView_contents2 = (TextView) findViewById(R.id.textView_contents2);
            TextView textView_contents3 = (TextView) findViewById(R.id.textView_contents3);

            textView_date.setText("Date: 4/8/2020");
            textView_contents.setText("Leo daily lucky number");
            textView_contents2.setText("3 - 1 0 - 1 5 - 2 3 - 2 6 - 3 5 - 4 7");
            textView_contents3.setText("NB: It is possible that one or several figures are identical. It is or they are your strong day figures.");
            /*
            textView_date.setText(date);
            textView_contents.setText(desc);
            textView_contents2.setText(desc2);
            textView_contents3.setText(desc3);
            */

            mProgressDialog.dismiss();
        }
    }
}
