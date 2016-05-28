package pe.edu.utp.groupfavorites.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import pe.edu.utp.groupfavorites.R;
import pe.edu.utp.groupfavorites.models.PeopleAdapter;
import pe.edu.utp.groupfavorites.models.Person;

import java.util.ArrayList;

public class CatalogActivity extends AppCompatActivity {
  private ArrayList<Person> people;
  private RecyclerView mPeopleRecyclerView;
  private RecyclerView.Adapter mPeopleAdapter;
  private RecyclerView.LayoutManager mPeopleLayoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_catalog);
    people = new ArrayList<>();
    initializeData();
    mPeopleRecyclerView = (RecyclerView) findViewById(R.id.peopleRecyclerView);
    mPeopleRecyclerView.setHasFixedSize(true);
    mPeopleLayoutManager = new LinearLayoutManager(this);
    mPeopleRecyclerView.setLayoutManager(mPeopleLayoutManager);
    mPeopleAdapter = new PeopleAdapter(people);
    mPeopleRecyclerView.setAdapter(mPeopleAdapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_catalog, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  public void initializeData() {
    people = new ArrayList<>();
    people.add(new Person("Steve", "Jobs", Integer.toString(R.mipmap.ic_watch_launcher),
        "Steve Jobs met Steve Wozniak while in high school and in 1976, they started Apple Computers. Jobs oversaw the development of revolutionary products like the iPhone and iPad."));
    people.add(new Person("Steve", "Wozniak", Integer.toString(R.mipmap.ic_watch_launcher),
        "Steve Wozniak is the co-founder of Apple Computers. Wozniak has always been credited with being the main designer of the first Apples."));
    people.add(new Person("Bill", "Gates", Integer.toString(R.mipmap.ic_watch_launcher), "Bill Gates and his partner Paul Allen built the world's largest software business, Microsoft."));
    people.add(new Person("Mark", "Zuckerberg", Integer.toString(R.mipmap.ic_watch_launcher),"Mark Zuckerberg was the Harvard computer science student who along with a few friends launched the world's most popular social networking website called Facebook in February 2004."));

  }
}
