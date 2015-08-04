package com.ws_adv.tabslistview;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private Button[] tabs = {null, null, null, null, null, null, null};
    private LinearLayout tabbarLineLL;
    private int selected_index = 0;

    ArticlesAdapter articlesAdapter;
    ListView listview;
    ArrayList<ArrayList<Article>> articles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int []ids = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7};
        for (int i=0; i<ids.length; i++)
            tabs[i] = (Button)findViewById(ids[i]);

        tabbarLineLL = (LinearLayout)findViewById(R.id.tabbarLineLL);
        listview = (ListView)findViewById(R.id.listView);

        articles.add(new ArrayList<Article>());
        articles.add(new ArrayList<Article>());
        articles.add(new ArrayList<Article>());
        articles.add(new ArrayList<Article>());
        articles.add(new ArrayList<Article>());
        articles.add(new ArrayList<Article>());
        articles.add(new ArrayList<Article>());

        Article article = new Article();
        article.setDesc("Black-ish Creator Kenya Barris to Co-Write Shaft Reboot - IGN");
        article.setImageUrl(R.drawable.image1);

        Article article1 = new Article();
        article1.setDesc("Michael Jackson's Iconic White Glove Is Upper for Auction");
        article1.setImageUrl(R.drawable.image2);

        Article article2 = new Article();
        article2.setDesc("Olsen Twins Could Still Return to Fuller House");
        article2.setImageUrl(R.drawable.image3);

        Article article3 = new Article();
        article3.setDesc("Lake Shore Drive");
        article3.setImageUrl(R.drawable.image4);

        Article article4 = new Article();
        article4.setDesc("Solitary Confinement: Punished for Life");
        article4.setImageUrl(R.drawable.image5);

        Article article5 = new Article();
        article5.setDesc("Massive California wildfire jumps containment line");
        article5.setImageUrl(R.drawable.image1);

        Article article6 = new Article();
        article6.setDesc("Doctor who linked to illegal lion killing and has practice in Pittsburgh mauled on social media");
        article6.setImageUrl(R.drawable.image2);

        Article article7 = new Article();
        article7.setDesc("54 things to know about US President Barack Obama");
        article7.setImageUrl(R.drawable.image3);

        Article article8 = new Article();
        article8.setDesc("Image of the day");
        article8.setImageUrl(R.drawable.image4);

        Article article9 = new Article();
        article9.setDesc("Disturbing Video Shows Kentucky Officer Handcuff Crying Third-Grader At School");
        article9.setImageUrl(R.drawable.image5);

        Article article10 = new Article();
        article10.setDesc("Use of bat boys and ball boys suspended after 9-year-old’s death");
        article10.setImageUrl(R.drawable.image1);

        Article article11 = new Article();
        article11.setDesc("Ex-con accused of killing Memphis police officer turns self in");
        article11.setImageUrl(R.drawable.image2);

        articles.get(0).add(article);
        articles.get(0).add(article1);
        articles.get(0).add(article2);
        articles.get(0).add(article3);
        articles.get(0).add(article4);
        articles.get(0).add(article5);
        articles.get(0).add(article6);

        articles.get(1).add(article7);
        articles.get(1).add(article8);
        articles.get(1).add(article9);
        articles.get(1).add(article10);
        articles.get(1).add(article11);

        articles.get(2).add(article);
        articles.get(2).add(article1);
        articles.get(2).add(article2);
        articles.get(2).add(article3);
        articles.get(2).add(article4);
        articles.get(2).add(article5);
        articles.get(2).add(article6);
        articles.get(2).add(article7);
        articles.get(2).add(article8);
        articles.get(2).add(article9);
        articles.get(2).add(article10);
        articles.get(2).add(article11);

        articles.get(3).add(article3);
        articles.get(3).add(article4);
        articles.get(3).add(article5);
        articles.get(3).add(article6);
        articles.get(3).add(article7);
        articles.get(3).add(article8);

        articles.get(4).add(article8);
        articles.get(4).add(article9);
        articles.get(4).add(article10);
        articles.get(4).add(article11);
        articles.get(4).add(article3);
        articles.get(4).add(article4);
        articles.get(4).add(article5);

        articles.get(5).add(article11);
        articles.get(5).add(article10);
        articles.get(5).add(article9);
        articles.get(5).add(article8);
        articles.get(5).add(article7);
        articles.get(5).add(article6);
        articles.get(5).add(article5);
        articles.get(5).add(article4);

        articles.get(6).add(article4);
        articles.get(6).add(article5);
        articles.get(6).add(article8);
        articles.get(6).add(article);
        articles.get(6).add(article1);
        articles.get(6).add(article7);
        articles.get(6).add(article11);
        articles.get(6).add(article10);

        setupAdapter();
    }

    public void tabClicked(View view)
    {
        LinearLayout.LayoutParams tempLL;

        // reset current selected button size
        Button currentButton = tabs[selected_index];
        tempLL = (LinearLayout.LayoutParams)currentButton.getLayoutParams();
        tempLL.width = (int) getResources().getDimension(R.dimen.button_width);
        tempLL.height = (int) getResources().getDimension(R.dimen.button_height);
        currentButton.setLayoutParams(tempLL);

        // change selected tab
        selected_index = Integer.parseInt(view.getTag().toString());

        // change color for the new selected button
        tempLL = (LinearLayout.LayoutParams)view.getLayoutParams();
        tempLL.width = (int) getResources().getDimension(R.dimen.button_width);
        tempLL.height = (int) getResources().getDimension(R.dimen.tabbar_height);
        view.setLayoutParams(tempLL);

        // change tabbar line color
        ColorDrawable buttonColor = (ColorDrawable) view.getBackground();
        tabbarLineLL.setBackgroundColor(buttonColor.getColor());

        setupAdapter();
    }

    public void setupAdapter()
    {
        // setup adapter for selected tab
        articlesAdapter = new ArticlesAdapter(this, 0, articles.get(selected_index));
        listview.setAdapter(articlesAdapter);
        articlesAdapter.notifyDataSetChanged();
    }
}
