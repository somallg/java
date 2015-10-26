package com.somallg.myactionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MyActionBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_action_bar);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        // actionBar.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        createMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return menuChoice(item);
    }

    private void createMenu(Menu menu) {
        MenuItem menu1 = menu.add(0, 0, 0, "Item 1");
        {
            menu1.setIcon(R.drawable.abc_ab_share_pack_holo_dark);
            menu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        }

        MenuItem menu2 = menu.add(0, 1, 1, "Item 2");
        {
            menu2.setIcon(R.drawable.abc_ab_share_pack_holo_dark);
            menu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        }

        MenuItem menu3 = menu.add(0, 2, 2, "Item 3");
        {
            menu3.setIcon(R.drawable.abc_ab_share_pack_holo_dark);
            menu3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }

        MenuItem menu4 = menu.add(0, 3, 3, "Item 4");
        {
            menu4.setIcon(R.drawable.abc_ab_share_pack_holo_dark);
            menu4.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }

        MenuItem menu5 = menu.add(0, 4, 4, "Item 5");
        {
            menu5.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
    }

    private boolean menuChoice(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "You clicked on the Application icon", Toast.LENGTH_SHORT).show();
                return true;
            case 0:
                Toast.makeText(this, "You clicked on Item 1", Toast.LENGTH_SHORT).show();
                return true;
            case 1:
                Toast.makeText(this, "You clicked on Item 2", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(this, "You clicked on Item 3", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(this, "You clicked on Item 4", Toast.LENGTH_SHORT).show();
                return true;
            case 4:
                Toast.makeText(this, "You clicked on Item 5", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
