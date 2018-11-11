package com.example.rkjc.news_app_2;

        import android.content.Context;
        import android.os.AsyncTask;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.AdapterView;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    static final String mTAG = "MainActivity";
    private NewsRecyclerViewAdapter mNa;
    private RecyclerView mRV;
    ArrayList<NewsItem> articles=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRV = findViewById(R.id.news_recyclerview);
        mNa=new NewsRecyclerViewAdapter(articles,this);
        mRV.setAdapter(mNa);
        mRV.setLayoutManager(new LinearLayoutManager(this));
        NetworkTask task=new NetworkTask();
        task.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemNumber = item.getItemId();
        if(itemNumber == R.id.action_search){
            Toast.makeText(this, "Searching...", Toast.LENGTH_LONG).show();
            NetworkTask task = new NetworkTask();
            task.execute();
        }
        return true;
    }

    class NetworkTask extends AsyncTask<String, Void,String> {




        protected String doInBackground(String... s) {
            ArrayList<NewsItem> allArticles = null;
            URL newsSourceUrl = NetworkUtils.makeURL();
            Log.d(mTAG, "url: " + newsSourceUrl.toString());
            String newsJson=null;
            try {
                newsJson = NetworkUtils.getResponseFromHttpUrl(newsSourceUrl);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return newsJson;
        }

        @Override
        protected void onPostExecute(String s) {
            inflateView(s);
        }
    }

    public void inflateView(String s){
        articles=JsonUtils.parseNews(s);
        mNa.articles1.addAll(articles);
        mNa.notifyDataSetChanged();
    }

}
