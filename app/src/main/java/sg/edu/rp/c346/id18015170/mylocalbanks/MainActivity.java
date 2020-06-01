package sg.edu.rp.c346.id18015170.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);



        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);


    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v== tvDBS){
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Contact the bank");
        }
        else if (v == tvOCBC){
            menu.add(1,0,0,"Website");
            menu.add(1,1,1,"Contact the bank");
        }
        else if (v == tvUOB){
            menu.add(2,0,0,"Website");
            menu.add(2,1,1,"Contact the bank");
        }



    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getGroupId()==0){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0

                //code for action
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intent);


                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"1800 111 1111"));
                startActivity(intentCall);


                return true;  //menu item successfully handled
            }

        }
        else if(item.getGroupId()==1){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0

                //code for action
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/group-home.html"));
                startActivity(intent);


                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"1800 363 3333"));
                startActivity(intentCall);


                return true;  //menu item successfully handled
            }
            else if(item.getGroupId()==2) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0

                    //code for action
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/personal/index.page"));
                    startActivity(intent);


                    return true; //menu item successfully handled
                } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                    //code for action

                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800 222 2121"));
                    startActivity(intentCall);


                    return true;  //menu item successfully handled
                }
            }
        }
        return super.onContextItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText("展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("关于我们");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
