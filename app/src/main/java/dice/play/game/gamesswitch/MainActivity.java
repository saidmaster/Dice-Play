package dice.play.game.gamesswitch;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(dice.play.game.gamesswitch.R.layout.activity_main);

        Button btnPlay = (Button) findViewById(dice.play.game.gamesswitch.R.id.btnStartPlay);


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startPlay = new Intent(MainActivity.this,Activity_Play.class);
                startActivity(startPlay);

                MediaPlayer mpButton = MediaPlayer.create(getBaseContext(), dice.play.game.gamesswitch.R.raw.buttonstart);

                mpButton.start();
                overridePendingTransition(dice.play.game.gamesswitch.R.anim.slide_in_left, dice.play.game.gamesswitch.R.anim.slide_out_left);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(dice.play.game.gamesswitch.R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case dice.play.game.gamesswitch.R.id.about:

          Intent i_about = new Intent(MainActivity.this,About.class);
                startActivity(i_about);
                overridePendingTransition(dice.play.game.gamesswitch.R.anim.slide_in_right, dice.play.game.gamesswitch.R.anim.slide_out_righ);
                return true;

            case dice.play.game.gamesswitch.R.id.contact_us:


                String[] TO = {"saidmaster88@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");


                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();

                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this,
                            "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }


                return true;

        }

        return super.onOptionsItemSelected(item);

    }
}
